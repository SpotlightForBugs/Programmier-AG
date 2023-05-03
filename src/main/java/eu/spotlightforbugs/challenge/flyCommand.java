package eu.spotlightforbugs.challenge;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class flyCommand implements CommandExecutor {
    /**
     * @param commandSender The sender of the command
     * @param command      The command that was executed
     * @param s           The label of the command
     * @param strings     The arguments of the command
     * @return true if the command was executed successfully, otherwise false
     */
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) commandSender;
        if (player.hasPermission("fly.use")) { //this permission is defined in the plugin.yml
            if (player.getAllowFlight()) {
                player.setAllowFlight(false);
                player.sendMessage("You can no longer fly");
                return true;
            } else {
                player.setAllowFlight(true);
                player.sendMessage("You can now fly");
                return true;
            }
        } else {
            player.sendMessage("You do not have permission to use this command");
            return false;
        }

    }
}
