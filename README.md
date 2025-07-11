# UltimateCore - Удобная библиотека для разработки плагинов bukkit api
Была сделана на версию 1.16.5 в будущем добавлю больше апи
На данный момент содержит в себе только:

- CommandApi
- TextFormatter (немой)

#CommandApi 
`@Command(name = "pivo", perm = "bar.admin", desc = "Выдаёт священный напиток", aliases = {"beer", "пиво"}, onlyPlayers = true
)
public class TestCommand extends AbstractCommand {
    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if (args.length == 1) {
            p.getInventory().addItem(new ItemStack(Material.POTION));
            p.sendMessage("На алкаш, выпей за здоровье!");
        }
    }
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull String[] arg) {
        return List.of("test");
    }`
