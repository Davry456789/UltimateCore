package ru.renix.ultimatecore;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ru.renix.ultimatecore.command.CommandRegister;


@Getter
public final class UltimateCore extends JavaPlugin {

    public static UltimateCore getInstance;

    @Override
    public void onEnable() {
        getInstance = this;
        //CommandRegister.registerCommands(this, new TairCommand(), new TestCommand());
    }
    @Override
    public void onDisable() {
    }
}
