package local.antropodus.controllers;

import local.antropodus.RPGSkills;
import local.antropodus.models.PlayerData;
import local.antropodus.models.Skill;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * Clase de carga inicial del jugador
 */
public class ConfigController {

    /**
     * Revisa si existe un fichero de configuración para el jugador, en caso negativo lo crea
     *
     * @param uuid Identificador del jugador
     * @return Devuelve el fichero de configuración del jugador
     */
    private @NotNull File CheckFile(@NotNull UUID uuid) {
        File folder = RPGSkills.pluginFolder;
        File playerFile = new File(folder, uuid.toString() + ".yml");
        if (!playerFile.exists()) {
            try {
                if (!playerFile.createNewFile()) {
                    throw new Exception("Fallo al crear el fichero de configuración");
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        return playerFile;
    }

    // NOTE Queda pendiente de ver que hacer con los datos cargados, donde guardar el playerData, y como
    //      y como iniciar los eventos.

    /**
     * Carga la configuración del usuario
     *
     * @param player Jugador
     */
    public void LoadUserData(@NotNull Player player) {
        File configFile = this.CheckFile(player.getUniqueId());
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(configFile);
        UUID uuid = player.getUniqueId();
        float actualExp = (float) yaml.getDouble("actualExp");
        float neededExp = (float) yaml.getDouble("neededExp");
        int level = yaml.getInt("level");
        List<Skill> habilidades = (List<Skill>) yaml.getList("skills");
    }

    /**
     * Guardado de los datos del jugador en el fichero
     *
     * @param playerData Datos del jugador a guardar
     */
    public void SaveUserData(PlayerData playerData) {
        File configFile = this.CheckFile(playerData.uuid);
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(configFile);
        yaml.set("uuid", playerData.uuid.toString());
        yaml.set("actualExp", playerData.actualExp);
        yaml.set("neededExp", playerData.neededExp);
        yaml.set("skills", playerData.habilidades);

    }
}
