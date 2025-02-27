package filip.hardcorecode.antiMinecartCrash;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class AntiMinecartCrash extends JavaPlugin {
    public static AntiMinecartCrash instance;
    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getPluginManager().registerEvents(new AntiMinecartListener(),this);
        Config config = ConfigUtil.getConfig("config");
        config.setDefault("max-minecarts_per_chunk",AntiMinecartListener.MAX_MINECARTS_PER_CHUNK);
        AntiMinecartListener.MAX_MINECARTS_PER_CHUNK = config.getInt("max-minecarts_per_chunk");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
