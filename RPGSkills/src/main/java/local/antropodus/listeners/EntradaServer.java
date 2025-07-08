package local.antropodus.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import local.antropodus.controllers.ConfigController;

public class EntradaServer implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        ConfigController config = new ConfigController();

    }

}
