package local.antropodus.listeners;

import local.antropodus.controllers.ConfigController;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Clase encargada de la puesta en marcha para cada jugador que entra al juego.
 */
public class EntradaServer implements Listener {

    /**
     * Evento de entrada del jugador al servidor
     *
     * @param event
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        ConfigController config = new ConfigController();
        config.LoadUserData(event.getPlayer());

    }

}
