package eu.spotlightforbugs.challenge;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class eHandler implements Listener {

    //every time a player jumps, the surrounding floor will be set on fire for 5 seconds
    @EventHandler
    public void onPlayerJump(PlayerJumpEvent event) {
        Player player = event.getPlayer();
        Location loc = player.getLocation();
        World world = player.getWorld();
        int x = loc.getBlockX();
        int y = loc.getBlockY();
        int z = loc.getBlockZ();
        for (int i = x - 2; i <= x + 2; i++) {
            for (int j = z - 2; j <= z + 2; j++) {
                if (world.getBlockAt(i, y, j).getType() == Material.AIR) {


                    if (i == x && j == z) {
                        continue;

                    } else{
                        world.getBlockAt(i, y, j).setType(Material.FIRE);
                }
            }
        }
        Bukkit.getScheduler().scheduleSyncDelayedTask(Challenge.getPlugin(Challenge.class), new Runnable() {
            @Override
            public void run() {
                for (int i = x - 2; i <= x + 2; i++) {
                    for (int j = z - 2; j <= z + 2; j++) {

                        world.getBlockAt(i, y , j).setType(Material.AIR);
                    }
                }
            }
        }, 100L); // 5 seconds
    } }

    //if a player gets damaged by fire, they will die. Only applies to players
    @EventHandler
    public void onPlayerDamage(org.bukkit.event.entity.EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            if (event.getCause() == EntityDamageEvent.DamageCause.FIRE || event.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK) {
                event.setCancelled(true);
                Player player = (Player) event.getEntity();
                player.setHealth(0);
            }
        }
    }


}
