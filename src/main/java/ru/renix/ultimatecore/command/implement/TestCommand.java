package ru.renix.ultimatecore.command.implement;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import ru.renix.ultimatecore.command.AbstractCommand;
import ru.renix.ultimatecore.command.annotation.Command;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Command(name = "sex", perm = "core.sex", desc = "гей секс для настоящих таиров", aliases = {"гейсексстаиром", "гейсекс"})

public class TestCommand extends AbstractCommand {
    @Override
    public void execute(@NotNull CommandSender sender, @NotNull String[] args) {
        Player player = (Player) sender;

        if (args.length == 1) {
            player.sendMessage("Таир гей");

        }



    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull String[] arg) {
        return List.of("гейсекс");
    }
}
