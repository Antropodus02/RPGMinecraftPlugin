package local.antropodus.models;

import it.unimi.dsi.fastutil.Hash;
import local.antropodus.enums.RutaHabilidad;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Objects;

/**
 * Clase con los datos de las habilidades
 */
public class Skill implements ConfigurationSerializable, Hash {
    /* TODO Revisar si se puede implementar unos atributos de EventType y Handler para que cada habilidad ejecute una
            función distinta con su correspondiente detonador. ej: Al entrar el jugador se le añade prisa minera,
            al matar a un mob se cura un corazón...*/
    private final String nombre;
    private final RutaHabilidad rutaHabilidad;
    private int level;
    private final int maxLevel;


    //Constructor
    public Skill(String nombre, RutaHabilidad rutaHabilidad, int level, int maxLevel) {
        this.nombre = nombre;
        this.rutaHabilidad = rutaHabilidad;
        this.level = level;
        this.maxLevel = maxLevel;
    }

    //GETTERS & SETTERS
    public String getNombre() {
        return nombre;
    }

    public RutaHabilidad getRutaHabilidad() {
        return rutaHabilidad;
    }

    public int getLevel() {
        return level;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    // REVIEW Revisar si era necesario para algo como el método Serialize
    @Override
    public int hashCode() {
        return Objects.hash(nombre, rutaHabilidad, level, maxLevel);
    }

    /**
     * Método de serialización para yml
     *
     * @return
     */
    @Override
    public @NotNull Map<String, Object> serialize() {
        return Map.of(
                "Nombre", this.nombre,
                "Ruta", this.rutaHabilidad,
                "NivelActual", this.level,
                "NivelMaximo", this.maxLevel
        );
    }

    /**
     * Método de deserialización del yml
     *
     * @param map
     * @return La Skill creada
     */
    public static Skill deserialize(Map<String, Object> map) {
        String nombre = (String) map.get("Nombre");
        RutaHabilidad especialidad = (RutaHabilidad) map.get("Ruta");
        int nivelActual = (int) map.get("NivelActual");
        int nivelMaximo = (int) map.get("NivelMaximo");
        return new Skill(nombre, especialidad, nivelActual, nivelMaximo);
    }

    /**
     * Aumenta el nivel de la habilidad en uno, siempre que sea posible
     *
     * @return true Si el aumento fue exitoso, false en caso contrario.
     */
    public boolean levelUp() {
        if (this.level == this.maxLevel) return false;
        this.level += 1;
        return true;
    }

}


