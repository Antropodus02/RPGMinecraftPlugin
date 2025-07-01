package local.antropodus.enums;

import java.util.List;

import net.md_5.bungee.api.ChatColor;

/**
 *
 * @author sergio
 */
public enum RutaHabilidad {
    BERSERKER("Berserker", ChatColor.RED, List.of("furia")),
    EXPLORADOR("Explorador", ChatColor.RED, List.of("furia")),
    ARTESANO("Berserker", ChatColor.RED, List.of("furia"));

    private final String displayName;
    private final ChatColor color;
    private final List<String> allowedSkills;

    RutaHabilidad(String displayName, ChatColor color, List<String> allowedSkills) {
        this.displayName = displayName;
        this.color = color;
        this.allowedSkills = allowedSkills;
    }

}
