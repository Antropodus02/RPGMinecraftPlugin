package local.antropodus;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

import local.antropodus.controllers.ConfigController;
import local.antropodus.controllers.LevelController;
import local.antropodus.controllers.SkillController;

/**
 * Hello world!
 *
 * @author sergio
 */
public class PluginCore extends JavaPlugin {

    private ConfigController configct;
    private SkillController skillct;
    private LevelController levelct;
    public static File pluginFolder;
    public static File playerDataFolder;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        this.configct = new ConfigController();
        this.skillct = new SkillController();
        this.levelct = new LevelController();

        pluginFolder = getDataFolder(); // Esto es plugins/MiPlugin/
        playerDataFolder = new File(pluginFolder, "players");

        if (!playerDataFolder.exists()) {
            playerDataFolder.mkdirs(); // crea la carpeta si no existe
        }

        getLogger().info("Trabajos activado");
    }

    @Override
    public void onDisable() {
        saveConfig();
        getLogger().info("Trabajos desactivado");
    }
}
