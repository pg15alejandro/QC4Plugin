package me.ultraqc4.qc4plugin;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.inventory.meta.BookMeta;
import java.util.List;


public class VillagerTradeChanger {

    public void ReadBook(Player player, Entity villagerClicked){
        System.out.println("READING BOOK");
        ItemStack item = player.getInventory().getItemInOffHand();
            if(!item.getType().equals(Material.AIR)) {
                if(item.getType().equals(Material.WRITTEN_BOOK)) {
                    System.out.println("WRITEN BOOK CHECK");
                    BookMeta meta = (BookMeta) item.getItemMeta();
                    if (meta.hasTitle()) {
                        if (meta.getTitle().equals("TRADES")) {
                            System.out.println("ENTERED IF OF READ");
                            List<String> pages = meta.getPages();
                            pages.forEach(page -> {
                                System.out.println("FOR EACH");
                                String[] text = page.split(",");
                                SetTrades(text, (Villager) villagerClicked);
                            });
                        }
                    }
                }
            }
            else
        System.out.println("PIPI PUPU CHECK");
}

public void SetTrades(String[] trades, Villager villager)
{
    System.out.println("SET TRADES 1");
    String amountItemToSell = trades[0];//amount required to sell
    System.out.println(amountItemToSell);
    System.out.println("SET TRADES 2");
    String itemToSell = trades[1];//item to sell
    System.out.println(itemToSell);
    System.out.println("SET TRADES 3");
    String amountItemToBuy = trades[2];//item to buy
    System.out.println(amountItemToBuy);
    System.out.println("SET TRADES 4");
    String itemToBuy = trades[3];//amount requried to buy
    System.out.println(itemToBuy);
    System.out.println("SET TRADES 5");
    ItemStack itemSell = new ItemStack(Material.getMaterial(itemToSell), Integer.parseInt(amountItemToSell));
    System.out.println(itemSell);
    System.out.println("SET TRADES 6");
    ItemStack itemBuy = new ItemStack(Material.getMaterial(itemToBuy), Integer.parseInt(amountItemToBuy));
    System.out.println(itemBuy);
    System.out.println("SET TRADES 7");
    MerchantRecipe recipe =  new MerchantRecipe(itemBuy, 1000, 10000, false,0,0,0,0);
    System.out.println(recipe.getResult());
    System.out.println("SET TRADES 8");
    recipe.addIngredient(itemSell);
    System.out.println(recipe.getIngredients());
    System.out.println("SET TRADES 9");
    List<MerchantRecipe> currentRecipes = villager.getRecipes();
    System.out.println(currentRecipes);
    System.out.println("SET TRADES 10");
    ///////////////
    currentRecipes.add(recipe);
    System.out.println(currentRecipes);
    System.out.println("SET TRADES 11");
    villager.setRecipes(currentRecipes);
    System.out.println(villager.getRecipes());
    System.out.println("SET TRADES 12");
}
}
