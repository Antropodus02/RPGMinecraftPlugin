package local.antropodus;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

public final class RPGSkills extends JavaPlugin {

    public static File pluginFolder;

    @Override
    public void onEnable() {
        pluginFolder = getDataFolder();
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
