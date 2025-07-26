package local.antropodus;

import local.antropodus.models.Skill;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * Clase encargada de poner en marcha el plugin
 */
public final class RPGSkills extends JavaPlugin {

    // Atributo para tener a mano la carpeta del plugin
    public static File pluginFolder;

    /**
     * Método obligatorio mediante el cúal se pone en marcha en el server
     */
    @Override
    public void onEnable() {
        pluginFolder = getDataFolder();

        // Registro de la clase Skill para poder hacer serializaciones en yml.
        ConfigurationSerialization.registerClass(Skill.class);
        // TODO Añadir el listener de EntradaServer.

    }

    /**
     * Método obligatorio mediante el cúal se termina el programa y se guardan los datos
     */
    @Override
    public void onDisable() {
        // TODO Guardado de los datos y posible limpieza.
    }
}
