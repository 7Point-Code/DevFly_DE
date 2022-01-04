package de.devfly.devfly.command;

import com.sun.tools.javac.jvm.Target;
import de.devfly.devfly.Devfly;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Wenn der Sender ein Spieler ist, darf er den Command nutzen
        if (sender instanceof Player) {
            System.out.println("Spieler");
            if (args.length == 0) {
                System.out.println("Länge 0");
        // Player Methode wird implementiert, sodass wir den Spieler mit p. und nicht mit sender. ansprechen können
        Player p = (Player) sender;
        // Wenn der Spieler diese Permission hat, kann er den Fly Command benutzen
        if(p.hasPermission("command.fly")) {
            System.out.println("Permission command.fly");
            // Wenn der Spieler bereits im Flugmodus ist und den Command nochmal ausführt, deaktiviert er den Flugmodus
            if (p.getAllowFlight()) {
                System.out.println("kann fliegen");
                // Sendet die Nachricht, dass er nun nicht mehr Fliegen kann mit dem Prefix
                p.sendMessage(Devfly.PREFIX + "§cDu kannst nun nicht mehr Fliegen.");
                // Setzt den Spieler nicht mehr
                p.setAllowFlight(false);
                // Wenn nicht, passiert dies:
            } else {
                System.out.println("Kann nicht fliegen");
                // Setzt den Spieler in den Flugmodus.
                p.setAllowFlight(true);
                // Sendet die Nachricht, dass er nun Fliegen kann mit dem Prefix
                p.sendMessage(Devfly.PREFIX + "§aDu kannst nun Fliegen.");
            }
            // Das ist die Methode, mit der einem anderen Spieler der Flugmodus verliehen werden kann.
        }
        else {
            p.sendMessage(Devfly.PREFIX + "§cDu hast dazu nicht die Berechtigung.");
        }
        } else if (args.length == 1) {
            System.out.println("Länge 1");
            // Player Methode wird implementiert, sodass wir den Spieler mit p. und nicht mit sender. ansprechen können
            Player player = (Player) sender;
            // Wenn der Spieler diese Permission hat, kann er den Fly Command benutzen
            if (player.hasPermission("command.fly")) {
                System.out.println("Permission");
                // Target Methode wird gecastet, sodass man den Spieler der ausgewählt wurde in den Flugmodus setzen kann
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    if (target.getAllowFlight()) {
                        System.out.println("kann fliegen");
                        player.sendMessage(Devfly.PREFIX + "Du hast §e" + target.getDisplayName() + " §7den Flugmodus entfernt!");
                        target.sendMessage(Devfly.PREFIX + "§e" + player.getDisplayName() + " §7hat dir den Flugmodus entfernt!");
                        target.setAllowFlight(false);
                    } else {
                        System.out.println("Kann nicht fliegen");
                        target.setAllowFlight(true);
                        player.sendMessage(Devfly.PREFIX + "Du hast §e" + target.getDisplayName() + " §7den Flugmodus verliehen!");
                        target.sendMessage(Devfly.PREFIX + "§e" + player.getDisplayName() + " §7hat dir den Flugmodus verliehen!");
                    }
                }
                else {
                    player.sendMessage(Devfly.PREFIX + "§cDer Spieler §6" + args[0] + " §c existiert nicht.");
                }
            }
            else {
                // Sende die Nachricht, dass er keine Berechtigung zu dem Command hat mit dem Prefix
                Player p = (Player) sender;
                p.sendMessage(Devfly.PREFIX + "§cDazu hast du keine Rechte.");
            }
            }
        }
            // Falls er nicht die Permission hat, mache dies
        return false;
    }
}
