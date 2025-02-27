package filip.hardcorecode.antiMinecartCrash;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ConfigUtil {
    static Map<String, Config> cachemap = new HashMap<>();

    public static Config getConfig(String name) {
        if (cachemap.get(name) != null)
            return cachemap.get(name);
        Config sConfig = new Config(new File(AntiMinecartCrash.instance.getDataFolder(), name + ".yml"), name);
        cachemap.put(name, sConfig);
        return sConfig;
    }

    public static void saveALL() {
        cachemap.forEach((a, b) -> b.save());
    }
}