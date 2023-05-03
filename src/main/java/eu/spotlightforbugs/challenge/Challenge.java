package eu.spotlightforbugs.challenge;

import org.bukkit.plugin.java.JavaPlugin;

public final class Challenge extends JavaPlugin {

    @Override
    public void onEnable() {
        // register the event listener inside the eHandler class
        getServer().getPluginManager().registerEvents(new eHandler(), this);
        //add a basic fly command to the plugin
        this.getCommand("fly").setExecutor(new flyCommand());
        //in the plugin.yml:
        //commands:
        //  fly:
        //    description: "Allows you to fly"
        //    usage: /fly
        //    permission: fly.use
        //    permission-message: "You do not have permission to use this command"
        //    aliases: [flight, flymode,bird]

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
