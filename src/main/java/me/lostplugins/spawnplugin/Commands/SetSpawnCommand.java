package me.lostplugins.spawnplugin.Commands;

import me.lostplugins.spawnplugin.SpawnPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

    private final SpawnPlugin plugin;

    public SetSpawnCommand(SpawnPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player){

            Player p = (Player) commandSender;
            String prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("prefix"));

            Location location = p.getLocation();

            plugin.getConfig().set("spawn", location);

            p.sendMessage(prefix + "Spawn location set to: x: " + ChatColor.GOLD + location.getX() + ChatColor.WHITE + " y: " + ChatColor.GOLD +  location.getY() + ChatColor.WHITE + " z: " + ChatColor.GOLD +  location.getZ());

        }else{
            System.out.println("You are not a player!");;
        }

        return true;
    }
}
