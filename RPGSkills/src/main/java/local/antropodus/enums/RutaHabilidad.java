package local.antropodus.enums;

import net.kyori.adventure.text.format.NamedTextColor;

import java.util.List;

/**
 * Enum con las distintas rutas de habilidades
 */
public enum RutaHabilidad {
    // NOTE Revisar como cargar la lista de habilidades al enum
    BERSERK("Berserker", NamedTextColor.DARK_RED, List.of("furia")),
    EXPLORADOR("Explorador", NamedTextColor.BLUE, List.of("furia")),
    ARTESANO("Artesano", NamedTextColor.GREEN, List.of("furia"));

    public final String displayName;
    public final NamedTextColor color;
    public final List<String> habilidades;

    RutaHabilidad(String displayName, NamedTextColor color, List<String> habilidades) {
        this.displayName = displayName;
        this.color = color;
        this.habilidades = habilidades;
    }
}
