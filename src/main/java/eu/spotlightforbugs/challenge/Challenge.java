package eu.spotlightforbugs.challenge;

import org.bukkit.plugin.java.JavaPlugin;

public final class Challenge extends JavaPlugin {

    @Override
    public void onEnable() {
        // register the event listener inside the eHandler class
        getServer().getPluginManager().registerEvents(new eHandler(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
