package ru.renix.ultimatecore;

import org.bukkit.plugin.java.JavaPlugin;
import ru.renix.ultimatecore.command.CommandRegister;
import ru.renix.ultimatecore.command.annotation.Command;
import ru.renix.ultimatecore.command.implement.TestCommand;

public final class UltimateCore extends JavaPlugin {

    @Override
    public void onEnable() {

        CommandRegister.registerCommands(this, new TestCommand());
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
