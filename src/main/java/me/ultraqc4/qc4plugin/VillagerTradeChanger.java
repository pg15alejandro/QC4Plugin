package me.ultraqc4.qc4plugin;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;
import java.util.List;


public class VillagerTradeChanger {

    public void ReadBook(Player player, Entity villagerClicked){
        System.out.println("READING BOOK");
        ItemStack item = player.getInventory().getItemInOffHand();
            if(!item.getType().equals(Material.AIR)) {
                if(item.getType().equals(Material.WRITTEN_BOOK)) {
                    System.out.println("WRITEN BOOK CHECK");
                    Entity villager = villagerClicked;
                    System.out.println("VILLAGERRRRRRRRRRR " + villager);
                    BookMeta meta = (BookMeta) item.getItemMeta();
                    if (meta.hasTitle()) {
                        if (meta.getTitle().equals("TRADES")) {
                            System.out.println("ENTERED IF OF READ");
                            List<String> pages = meta.getPages();
                            pages.forEach(page -> {
                                System.out.println("FOR EACH");
                                String[] text = page.split(",");
                                SetTrades(text, villager);
                            });
                        }
                    }
                }
            }
            else
        System.out.println("PIPI PUPU CHECK");
}

public void SetTrades(String[] trades, Entity villager)
{
    System.out.println("TRADES READ PAGE ");
    String amountItemToSell = trades[0];//amount required to sell
    String itemToSell = trades[1];//item to sell
    String amountItemToBuy = trades[2];//item to buy
    String itemToBuy = trades[3];//amount required to buy
    ItemStack itemSell = new ItemStack(Material.getMaterial(itemToSell), Integer.parseInt(amountItemToSell));
    ItemStack itemBuy = new ItemStack(Material.getMaterial(itemToBuy), Integer.parseInt(amountItemToBuy));
    MerchantRecipe recipe =  new MerchantRecipe(itemBuy, 100000);
    recipe.addIngredient(itemSell);
    Villager vil = (Villager) villager;
    List<MerchantRecipe> currentRecipes = new ArrayList<>((vil.getRecipes()));
    currentRecipes.add(recipe);
    vil.setRecipes(currentRecipes);


}
}
