package n0devx.lobbynav;

import n0devx.lobbynav.commands.MessageCommand;
import n0devx.lobbynav.commands.WarpCommand;
import n0devx.lobbynav.util.Config;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class LobbyNAV extends JavaPlugin {
    private static Config cfg;

    @Override
    public void onEnable() {
        getCommand("message").setExecutor(new MessageCommand());
        getCommand("warp").setExecutor(new WarpCommand());
        cfg = new Config("warps.yml", getDataFolder());

    }

    @Override
    public void onDisable() {

    }

    public static Config getCfg() {
        return cfg;
    }


}
