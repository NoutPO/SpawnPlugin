package me.lostplugins.spawnplugin.listeners;

import me.lostplugins.spawnplugin.SpawnPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SpawnListeners implements Listener {

    private final SpawnPlugin plugin;

    public SpawnListeners(SpawnPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();
        String prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("prefix"));

        if (!p.hasPlayedBefore()) {

            Location location = plugin.getConfig().getLocation("spawn");

            if (location != null) {

                p.teleport(location);
                p.sendMessage( prefix + ChatColor.GOLD + "Welcome to the server!");

            } else {

                p.sendMessage( prefix + ChatColor.GOLD + "There is no spawn point set.");

            }

        }

    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {

        Player p = e.getPlayer();

        Location location = plugin.getConfig().getLocation("");

        if (location != null) {

            e.setRespawnLocation(location);

        }

    }

}