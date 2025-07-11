# UltimateCore - Удобная библиотека для разработки плагинов bukkit api
Была сделана на версию 1.16.5 в будущем добавлю больше библиотек, на данный момент содержит в себе только:


- CommandApi
- TextFormatter 

#CommandApi


    @Command(name = "pivo", perm = "bar.admin", desc = "Выдаёт священный напиток", aliases = {"beer", "пиво"}, onlyPlayers = true)
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

