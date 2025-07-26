package local.antropodus.models;

import local.antropodus.enums.RutaHabilidad;

import java.util.List;
import java.util.UUID;

/**
 * Clase con los datos del plugin para el jugador
 */
public class PlayerData {

    public UUID uuid;
    public float actualExp;
    public float neededExp;
    public int level;
    public List<Skill> habilidades;
    public RutaHabilidad especialidad;

    public PlayerData(UUID uuid, float actualExp, float neededExp, int level, List<Skill> habilidades,
                      RutaHabilidad especialidad) {
        this.uuid = uuid;
        this.actualExp = actualExp;
        this.neededExp = neededExp;
        this.level = level;
        this.habilidades = habilidades;
        this.especialidad = especialidad;
    }
}
