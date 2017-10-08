/**
 *
 */
package clothingcraft.blocks;

import clothingcraft.items.ClothingCraftHaliteItemList;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;

/**
 * List of blocks and their registrations into the world
 *
 * @author JujuAwesomeBeans
 * @author NinjaSoldier40
 * @since 02/10/2017 05:35 AM (-7:00 GMT)
 */
public class ClothingCraftHaliteBlockList {

    public static Block haliteOre;
    public static Block haliteBlock;
    public static Block cottonFabricBundle;
    public static Block sandCastleBlock;

    public static void preInit() {
        // halite ore
        haliteOre = (BlockHaliteOre) new BlockHaliteOre();
        GameRegistry.registerBlock(haliteOre, "halite_ore");

        haliteBlock = (BlockHaliteBlock) new BlockHaliteBlock(Material.ground);
        GameRegistry.registerBlock(haliteBlock, "halite_block");

        cottonFabricBundle = (BlockCottonFabric) new BlockCottonFabric(Material.cloth);
        GameRegistry.registerBlock(cottonFabricBundle, "cotton_fabric_bundle");

        sandCastleBlock = (BlockSandCastle) new BlockSandCastle();
        GameRegistry.registerBlock(sandCastleBlock, "sandcastle");
    }

    public static void init() {
        GameRegistry.addRecipe(new ItemStack(haliteBlock, 1),
                new Object[]{"012", "345", "678",
                        Character.valueOf('0'), new ItemStack(ClothingCraftHaliteItemList.rockSalt, 1),
                        Character.valueOf('1'), new ItemStack(ClothingCraftHaliteItemList.rockSalt, 1),
                        Character.valueOf('2'), new ItemStack(ClothingCraftHaliteItemList.rockSalt, 1),
                        Character.valueOf('3'), new ItemStack(ClothingCraftHaliteItemList.rockSalt, 1),
                        Character.valueOf('4'), new ItemStack(ClothingCraftHaliteItemList.rockSalt, 1),
                        Character.valueOf('5'), new ItemStack(ClothingCraftHaliteItemList.rockSalt, 1),
                        Character.valueOf('6'), new ItemStack(ClothingCraftHaliteItemList.rockSalt, 1),
                        Character.valueOf('7'), new ItemStack(ClothingCraftHaliteItemList.rockSalt, 1),
                        Character.valueOf('8'), new ItemStack(ClothingCraftHaliteItemList.rockSalt, 1),
                });

        GameRegistry.addShapelessRecipe(new ItemStack(haliteBlock),
                new Object[]{
                        ClothingCraftHaliteItemList.haliteIngot,
                        ClothingCraftHaliteItemList.haliteIngot,
                        ClothingCraftHaliteItemList.haliteIngot,
                        ClothingCraftHaliteItemList.haliteIngot,
                });
    }
}
