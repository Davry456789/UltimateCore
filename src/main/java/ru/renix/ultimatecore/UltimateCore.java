package ru.renix.ultimatecore;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ru.renix.ultimatecore.command.CommandRegister;
import ru.renix.ultimatecore.command.implement.TairCommand;
import ru.renix.ultimatecore.command.implement.TestCommand;

public final class UltimateCore extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Плагин включился");
        CommandRegister.registerCommands(this, new TairCommand(), new TestCommand());
    }
    @Override
    public void onDisable() {
    }
}
