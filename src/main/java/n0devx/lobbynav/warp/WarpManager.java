package n0devx.lobbynav.warp;

import n0devx.lobbynav.LobbyNAV;
import org.bukkit.Location;

public class WarpManager {

    public static Location getWarp(String name){
        LobbyNAV.getCfg().getConfiguration().getLocation(name);

        return null;
    }

    public static void createWarp(String name, Location location){
        LobbyNAV.getCfg().set(name, location);
        LobbyNAV.getCfg().save();
    }
    public static void deleteWarp(String name){
        LobbyNAV.getCfg().set(name, null);
        LobbyNAV.getCfg().save();
    }
}
