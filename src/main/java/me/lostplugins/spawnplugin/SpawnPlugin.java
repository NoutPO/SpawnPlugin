package me.lostplugins.spawnplugin;

import me.lostplugins.spawnplugin.Commands.SetSpawnCommand;
import me.lostplugins.spawnplugin.Commands.SpawnCommand;
import me.lostplugins.spawnplugin.listeners.SpawnListeners;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpawnPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));

        getServer().getPluginManager().registerEvents(new SpawnListeners(this), this);

    }

}
