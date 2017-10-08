/**
 *
 */
package clothingcraft.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Contains all creative tabs for the mod that
 * show up on the Graphical User Interface (GUI)
 * <p>
 * 0 = Core [
 * Halite (ore, block, ingot, dust, tools, sword, armor),
 * Cotton (plant, seeds, bale)
 * ]
 * 1 = Materials [Dyes, Fabric]
 * 2 = Accessories [Sand-castle, Ring, Clipboard, et al]
 * 3 = Tools [
 * Needle and Thread,
 * Scissors, Knitting Needles,
 * Measuring Tape, Pin-cushion,
 * Patterns
 * ]
 * 4 = Wardrobe [Outfits, Head-gear, et al]
 *
 * @author JujuAwesomeBeans
 * @author NinjaSoldier40
 * @since 02/05/2017 10:42 AM
 */
public class CreativeTabsClothingCraft extends CreativeTabs {
    /* src: https://gist.github.com/Choonster/42602d38a94b915fc0b2 */
    private Comparator<ItemStack> itemSorter = new ItemOreSorter();

    public CreativeTabsClothingCraft(String index) {
        super(index);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {
        return Item.getItemFromBlock(Blocks.sapling);
    }

    @Override
    public void displayAllReleventItems(List items) {
        super.displayAllReleventItems(items);

        // Sort the item list using the ItemSorter instance
        Collections.sort(items, itemSorter);
    }

//	/*
//	 * TABS
//	 */
//	
//	// Core tab
//	public static CreativeTabs tabCore = 
//			new CreativeTabs("tabClothingCraftCore") {
//				@SideOnly(Side.CLIENT)
//				public Item getTabIconItem() {
//					return ;
//				}
//			};
//	// Materials tab
//	public static CreativeTabs tabMaterials = 
//			new CreativeTabs("tabClothingCraftMaterials") {
//				@SideOnly(Side.CLIENT)
//				public Item getTabIconItem() {
//					//return mcreator_cottonFabric.block;
//					return ClothingCraft.bollsCotton;
//				}
//			};
//	// Accessories tab
//	public static CreativeTabs tabAccessories = 
//			new CreativeTabs("tabClothingCraftAccessories") {
//				@SideOnly(Side.CLIENT)
//				public Item getTabIconItem() {
//					//return mcreator_brownPurse.block;
//					return ClothingCraft.bollsCotton;
//				}
//			};
//	// Tools tab
//	public static CreativeTabs tabTools = 
//			new CreativeTabs("tabClothingCraftTools") {
//				@SideOnly(Side.CLIENT)
//				public Item getTabIconItem() {
//					//return mcreator_sewingScissors.block;
//					return ClothingCraft.bollsCotton;
//				}
//			};
//	// Wardrobe tab
//	public static CreativeTabs tabWardrobe = 
//			new CreativeTabs("tabClothingCraftWardrobe") {
//				@SideOnly(Side.CLIENT)
//				public Item getTabIconItem() {
//					//return mcreator_needleandThread.block;
//					return ClothingCraft.bollsCotton;
//				}
//			};

}
