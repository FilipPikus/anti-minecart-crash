package filip.hardcorecode.antiMinecartCrash;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Minecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Arrays;

public class AntiMinecartListener implements Listener {
    public static int MAX_MINECARTS_PER_CHUNK = 150;

    @EventHandler
    public void onMinecartSpawn(CreatureSpawnEvent event) {
        if (event.getEntityType() == EntityType.MINECART) {
            Chunk chunk = event.getEntity().getLocation().getChunk();
            long minecartCount = Arrays.stream(chunk.getEntities())
                    .filter(entity -> entity instanceof Minecart)
                    .count();

            if (minecartCount >= MAX_MINECARTS_PER_CHUNK) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onMinecartPlace(PlayerInteractEvent event) {
        if (event.getItem() != null && event.getItem().getType() == Material.MINECART) {
            Chunk chunk = event.getPlayer().getLocation().getChunk();
            long minecartCount = Arrays.stream(chunk.getEntities())
                    .filter(entity -> entity instanceof Minecart)
                    .count();

            if (minecartCount >= MAX_MINECARTS_PER_CHUNK) {
                event.setCancelled(true);
            }
        }
    }
}
