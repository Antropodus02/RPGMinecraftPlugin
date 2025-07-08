package local.antropodus.controllers;

import java.io.File;
import java.util.UUID;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import local.antropodus.RPGSkills;

public class ConfigController {

    private File CheckFile(Player player) {

        File folder = RPGSkills.pluginFolder;
        File playerFile = new File(folder, player.getUniqueId().toString() + ".yml");
        if (!playerFile.exists()) {
            try {
                playerFile.createNewFile();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        return playerFile;
    };

    public void LoadUserData(Player player) {
        File configFile = this.CheckFile(player);
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(configFile);
        UUID uuid = UUID.fromString(yaml.getString("uuid"));
        float actualExp = (float) yaml.getDouble("actualExp");
        float neededExp = (float) yaml.getDouble("neededExp");
        int level = yaml.getInt("level");

    }
}
