package ru.renix.ultimatecore.command;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.units.qual.A;
import org.jetbrains.annotations.NotNull;
import ru.renix.ultimatecore.command.annotation.Command;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class CommandRegister {

    public static void registerCommands(JavaPlugin plugin, AbstractCommand... commands) {
        try {
            // Рефлексия - боль, но без нее нихуя
            final Field cmdMapField = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            cmdMapField.setAccessible(true);
            CommandMap cmdMap = (CommandMap) cmdMapField.get(Bukkit.getServer());

            for (AbstractCommand cmd : commands) {
                Command meta = cmd.meta();
                if (meta == null) continue;

                // букитовская команда
                BukkitCommand bukkitCmd = new BukkitCommand(meta.name(), meta.desc(), meta.usage(), Arrays.asList(meta.aliases())) {
                    @Override
                    public boolean execute(CommandSender sender, String alias, String[] args) {
                        if (!meta.perm().isEmpty() && !sender.hasPermission(meta.perm())) {
                            sender.sendMessage("У тебя прав нету!!! XDD");
                            return true;
                        }
                        if (meta.onlyPlayers() && !(sender instanceof Player)) {
                            sender.sendMessage("Только игроки, бро!");
                            return true;
                        }
                        cmd.execute(sender, args);
                        return true;
                    }
                    @Override
                    public List<String> tabComplete(CommandSender sender, String alias, String[] args) {
                        return cmd.onTabComplete(sender, args);
                    }
                };
                cmdMap.register(plugin.getName(), bukkitCmd);
            }

        } catch (Exception e) {
            plugin.getLogger().severe("ОШИБКА РЕГИСТРАЦИИ КОМАНД: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
