package local.antropodus.controllers;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import local.antropodus.PluginCore;
import local.antropodus.enums.RutaHabilidad;
import local.antropodus.models.PlayerData;
import local.antropodus.models.Skill;

/**
 *
 * @author sergio
 */
public class ConfigController {

    public void loadStats(Player player) {
        File folder = PluginCore.pluginFolder;
        File playerFile = new File(folder, player.getUniqueId().toString() + ".yml");
        if (!playerFile.exists()) {
            try {
                playerFile.createNewFile();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    private PlayerData loadData(File file) {
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);
        UUID uuid = UUID.fromString(yaml.getString("uuid"));
        int nivel = yaml.getInt("nivel");
        float xp = (float) yaml.getDouble("xp");
        float xpProgress = (float) yaml.getDouble("nivel.progreso");
        List<String> skills = yaml.getStringList("skills");
        RutaHabilidad especialidad = RutaHabilidad.valueOf(yaml.getString("especialidad"));

        return PlayerData();
    }

    private boolean writeData(File file) {
    }
}
