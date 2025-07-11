package ru.renix.ultimatecore.command.implement;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.renix.ultimatecore.command.AbstractCommand;
import ru.renix.ultimatecore.command.annotation.Command;

import java.util.List;

@Command(name = "pivo", perm = "bar.admin", desc = "Выдаёт священный напиток", aliases = {"beer", "пиво"}, onlyPlayers = true
)
public class TestCommand extends AbstractCommand {
    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof Player player) {
            player.getInventory().addItem(new ItemStack(Material.POTION));
            player.sendMessage("На алкаш, выпей за здоровье!");
        }
    }

    @Override
    public List<String> tabExec(@NotNull CommandSender sender, @NotNull String[] args) {
        return List.of("ник");
    }

}
