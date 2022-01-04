package de.devfly.devfly;

import de.devfly.devfly.command.Fly;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.*;
import org.bukkit.*;

public final class Devfly extends JavaPlugin
{
    public static String PREFIX = "§8[§eFly§8] §7";

    // Wenn das Plugin aktiviert wird, passiert Folgendes:
    public void onEnable() {
        // Sende folgende Nachricht in die Konsole, wenn das Plugin gestartet wurde
        log("§2---------------");
        log("§aPlugin §2geladen §aund §2gestartet§a.");
        log("§2---------------");
        // Registriere folgende Klassen aus der: log, Methode
        this.register();
    }

    // Wenn das Plugin deaktiviert wird, passiert Folgendes:
    public void onDisable() {
        log("§2---------------");
        log("§aPlugin §4entladen §aund §4gestoppt§a.");
        log("§2---------------");
    }

    // Log Methode (Wird registriert in der onEnable Methode)
    public void log(final String text) {
        //Sende eine Konsolennachricht immer, mit dem Fly Prefix
        Bukkit.getConsoleSender().sendMessage(Devfly.PREFIX + text);
    }

    //Commandregistriermethode
    public void register() {
        Bukkit.getPluginCommand("fly").setExecutor((CommandExecutor)new Fly());
    }
}
