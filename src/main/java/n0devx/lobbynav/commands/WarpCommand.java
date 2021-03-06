package n0devx.lobbynav.commands;

import n0devx.lobbynav.warp.WarpManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class WarpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)){
            return false;
        }
        Player p = (Player) sender;
        if (args.length == 1){
            if (WarpManager.getWarp(args[0]) != null){
                p.teleport(WarpManager.getWarp(args[0]));
                p.sendMessage("§aDu wurdest zu dem Warp " + args[0] + " teleportiert!");

            }else {
                p.sendMessage("§cDiesen Warp gibt es nicht");
            }
        }else if (args.length == 2){
            if (!p.hasPermission("warp.manage")){
                p.sendMessage("§cKeine Rechte!");
                return false;
            }
            if (args[0].equalsIgnoreCase("add")){
                if (WarpManager.getWarp(args[1]) == null){
                    WarpManager.createWarp(args[1], p.getLocation());
                    p.sendMessage("§aDu hast den Warp " + args[1] + " erstellt!");

                }else {
                    p.sendMessage("§cDiesen Warp gibt es schon!");
                }
            }

            }else if (args[0].equalsIgnoreCase("delete")){
            if (WarpManager.getWarp(args[1]) != null){
                WarpManager.deleteWarp(args[1]);
                p.sendMessage("§aDu hast den Warp " + args[1] + " gelöscht!");

            }else {
                p.sendMessage("§cDiesen Warp gibt es nicht!");
            }

        }
        return false;
    }
}
