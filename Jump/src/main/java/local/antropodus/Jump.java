package local.antropodus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.StringUtil;

public class Jump
        extends JavaPlugin {
    private FileConfiguration config;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        config = getConfig();
        getLogger().info("JumpPlugin activado");
        this.getCommand("jump").setTabCompleter(this);
    }

    @Override
    public void onDisable() {
        saveConfig();
        getLogger().info("JumpPlugin desactivado");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Este comando solo puede ser usado por jugadores.");
            return true;
        }

        if (args.length < 2) {
            player.sendMessage("Uso: /jump <guardar|ir|borrar> <nombre>");
            return true;
        }

        String subcomando = args[0].toLowerCase();
        String nombre = args[1].toLowerCase();

        switch (subcomando) {
            case "guardar" -> {
                Location loc = player.getLocation();
                config.set("saltos." + nombre + ".world", loc.getWorld().getName());
                config.set("saltos." + nombre + ".x", loc.getX());
                config.set("saltos." + nombre + ".y", loc.getY());
                config.set("saltos." + nombre + ".z", loc.getZ());
                config.set("saltos." + nombre + ".yaw", loc.getYaw());
                config.set("saltos." + nombre + ".pitch", 0.0f);
                saveConfig();
                player.sendMessage("Coordenadas guardadas como '" + nombre + "'.");
            }
            case "ir" -> {
                if (!config.contains("saltos." + nombre)) {
                    player.sendMessage("No hay coordenadas guardadas con ese nombre.");
                    return true;
                }
                String world = config.getString("saltos." + nombre + ".world");
                double x = config.getDouble("saltos." + nombre + ".x");
                double y = config.getDouble("saltos." + nombre + ".y");
                double z = config.getDouble("saltos." + nombre + ".z");
                float yaw = (float) config.getDouble("saltos." + nombre + ".yaw");
                float pitch = (float) config.getDouble("saltos." + nombre + ".pitch");

                Location loc = new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
                player.teleport(loc);
                player.sendMessage("Teletransportado a '" + nombre + "'.");
            }
            case "borrar" -> {
                if (!config.contains("saltos." + nombre)) {
                    player.sendMessage("No hay coordenadas guardadas con ese nombre.");
                    return true;
                }
                config.set("saltos." + nombre, null);
                saveConfig();
                player.sendMessage("Coordenadas '" + nombre + "' eliminadas.");
            }
            case "lista" -> {
                if (!config.contains("saltos")) {
                    player.sendMessage("No hay coordenadas guardadas aún.");
                    return true;
                }

                String mundoActual = player.getWorld().getName();
                Set<String> nombres = config.getConfigurationSection("saltos").getKeys(false);

                List<String> encontrados = new ArrayList<>();
                for (String nombreClave : nombres) {
                    String mundoGuardado = config.getString("saltos." + nombreClave + ".world");
                    if (mundoActual.equals(mundoGuardado)) {
                        double x = config.getDouble("saltos." + nombreClave + ".x");
                        double y = config.getDouble("saltos." + nombreClave + ".y");
                        double z = config.getDouble("saltos." + nombreClave + ".z");

                        String info = nombreClave + " (" +
                                String.format("%.1f", x) + ", " +
                                String.format("%.1f", y) + ", " +
                                String.format("%.1f", z) + ")";
                        encontrados.add(info);
                    }
                }

                if (encontrados.isEmpty()) {
                    player.sendMessage("No hay coordenadas guardadas para este mundo.");
                } else {
                    player.sendMessage("📌 Coordenadas guardadas en este mundo:");
                    for (String s : encontrados) {
                        player.sendMessage("» " + s);
                    }
                }
            }

            default -> {
                player.sendMessage("Subcomando no válido. Usa guardar, ir, lista o borrar.");
            }
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (!(sender instanceof Player))
            return Collections.emptyList();

        List<String> completions = new ArrayList<>();
        if (args.length == 1) {
            // Sugerir subcomandos en la primera palabra
            List<String> subcommands = List.of("guardar", "ir", "borrar", "lista");
            StringUtil.copyPartialMatches(args[0], subcommands, completions);
            Collections.sort(completions);
            return completions;
        } else if (args.length == 2) {
            // Para el segundo argumento, sugerir nombres guardados en el mundo del jugador
            Player player = (Player) sender;
            String mundoActual = player.getWorld().getName();
            if (config.contains("saltos")) {
                Set<String> nombres = config.getConfigurationSection("saltos").getKeys(false);
                List<String> nombresFiltrados = new ArrayList<>();
                for (String nombre : nombres) {
                    String mundoGuardado = config.getString("saltos." + nombre + ".world");
                    if (mundoActual.equals(mundoGuardado)) {
                        nombresFiltrados.add(nombre);
                    }
                }
                StringUtil.copyPartialMatches(args[1], nombresFiltrados, completions);
                Collections.sort(completions);
                return completions;
            }
        }

        return Collections.emptyList();
    }
}