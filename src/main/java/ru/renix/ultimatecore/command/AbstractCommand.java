package ru.renix.ultimatecore.command;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import ru.renix.ultimatecore.command.annotation.Command;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class AbstractCommand implements TabExecutor {

    public abstract void execute (CommandSender sender, String[] args);

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull org.bukkit.command.Command command, @NotNull String alias, @NotNull String[] args ) {
        Command meta = meta();

        if (!meta.perm().isEmpty() && !sender.hasPermission(meta.perm())) {
            sender.sendMessage("У тебя прав нету!!! XDD");
            return true;
        }
        if (meta.onlyPlayers() && !(sender instanceof Player)) {
            sender.sendMessage("Только игроки, бро!");
            return true;
        }
        execute(sender, args);
        return true;
    }


    public abstract List<String> tabExec(@NotNull final CommandSender sender, @NotNull final String[] args);

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull org.bukkit.command.Command command, @NotNull String alias, @NotNull String[] args) {
        return tabExec(sender, args);
    }


    public Command meta() {
        return this.getClass().getAnnotation(Command.class);
    }
}
