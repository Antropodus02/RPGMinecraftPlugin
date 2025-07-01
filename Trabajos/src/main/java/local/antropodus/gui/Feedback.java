package local.antropodus.gui;

import org.bukkit.entity.Player;

import local.antropodus.models.PlayerData;
import net.kyori.adventure.text.Component;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

/**
 *
 * @author sergio
 */
public class Feedback {

    public void mostrarBarraNivel(Player jugador, PlayerData datos) {
        float progreso = (float) datos.getCurrentXp() / datos.getXpToNextLevel();
        String bar = generateBar(progreso);
        Component message = Component
                .text(ChatColor.GOLD + "Nivel " + datos.getLevel() + " " + bar + " " + (int) (progreso * 100)
                        + "%");
        jugador.sendActionBar(message);
    }

    private String generateBar(float progreso) {
        int total = 10;
        int filled = (int) (progreso * total);
        return ChatColor.GREEN + "█".repeat(filled) + ChatColor.GRAY + "█".repeat(total - filled);
    }

}
