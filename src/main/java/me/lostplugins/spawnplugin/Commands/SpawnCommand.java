package me.lostplugins.spawnplugin.Commands;

import me.lostplugins.spawnplugin.SpawnPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    private final SpawnPlugin plugin;

    public SpawnCommand(SpawnPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player){

            Player p = (Player) commandSender;
            String prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("prefix"));

            Location location = plugin.getConfig().getLocation("spawn");

            if (location != null){

                p.teleport(location);

                p.sendMessage( prefix + ChatColor.GOLD + "You have been teleported to spawn");

            }else{

                p.sendMessage(prefix + ChatColor.GOLD + "There is no spawn point set.");

            }

        }

        return true;
    }
}
