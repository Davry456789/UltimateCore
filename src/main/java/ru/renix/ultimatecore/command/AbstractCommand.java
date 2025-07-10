package ru.renix.ultimatecore.command;

import org.bukkit.command.CommandSender;
import ru.renix.ultimatecore.command.annotation.Command;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class AbstractCommand {

    public abstract void execute (CommandSender sender, String[] args);

    public List<String> onTabComplete(CommandSender sender, String[] args) {
        return Collections.emptyList();
    }

    public Command meta() {
        return this.getClass().getAnnotation(Command.class);
    }
}
