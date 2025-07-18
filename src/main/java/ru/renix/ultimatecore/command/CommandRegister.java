package ru.renix.ultimatecore.command;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import ru.renix.ultimatecore.command.annotation.Command;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class CommandRegister {

    public static void registerCommands(JavaPlugin plugin, AbstractCommand... commands) {
        try {
            final Field cmdMapField = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            cmdMapField.setAccessible(true);
            CommandMap cmdMap = (CommandMap) cmdMapField.get(Bukkit.getServer());

            for (AbstractCommand cmd : commands) {
                Command meta = cmd.meta();
                if (meta == null) continue;
                BukkitCommand bukkitCmd = getBukkitCommand(cmd, meta);
                cmdMap.register(plugin.getName(), bukkitCmd);
            }

        } catch (Exception e) {
            plugin.getLogger().severe("ОШИБКА РЕГИСТРАЦИИ КОМАНД: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static @NotNull BukkitCommand getBukkitCommand(AbstractCommand cmd, Command meta) {
        BukkitCommand bukkitCmd = new BukkitCommand(
                meta.name(),
                meta.desc(),
                meta.usage(),
                Arrays.asList(meta.aliases())) {
            @Override
            public boolean execute(@NotNull CommandSender sender, @NotNull String alias, String[] args) {
                return cmd.onCommand(sender, this, alias, args);
            }
            @Override
            public @NotNull List<String> tabComplete(@NotNull CommandSender sender, @NotNull String alias, String[] args) {
                return cmd.onTabComplete(sender, this, alias, args);
            }
        };

        bukkitCmd.setPermission(meta.perm());
        return bukkitCmd;
    }

}
