/**
 *
 */
package clothingcraft.items;

import clothingcraft.core.ClothingCraft;
import clothingcraft.core.ClothingCraftInfo;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.LinkedHashMap;

/**
 * List of dye and fabric items and their registrations into the world
 *
 * @author JujuAwesomeBeans
 * @author NinjaSoldier40
 * @since 02/10/2017 05:58 AM (-7:00 GMT)
 */
public class ClothingCraftFabricItemList {
    public static Item cottonFabric;
    public static LinkedHashMap<COLORS, Item> dyeItemsMap = new LinkedHashMap<ClothingCraftFabricItemList.COLORS, Item>();

    ; // pinklight removed (no fabric for it).
    public static LinkedHashMap<COLORS, Item> fabricItemsMap = new LinkedHashMap<ClothingCraftFabricItemList.COLORS, Item>();
    public static LinkedHashMap<COLORS, Object[]> dyeRecipeMap = new LinkedHashMap<ClothingCraftFabricItemList.COLORS, Object[]>();

    public static void preInit() {

        buildRecipesByColor();

        cottonFabric = (Item) new ItemCottonFabric()
                .setMaxDamage(0)
                .setMaxStackSize(64)
                .setUnlocalizedName("cotton_fabric")
                .setTextureName(ClothingCraftInfo.MODID + ":cotton_fabric")
                .setCreativeTab(ClothingCraft.tabCore);
        GameRegistry.registerItem(cottonFabric, "cotton_fabric");

        for (COLORS enumColor : COLORS.values()) {
            dyeItemsMap.put(enumColor, new ItemDye(enumColor.toString()));
            GameRegistry.registerItem((dyeItemsMap.get(enumColor)), "dye_" + enumColor.toString());

            fabricItemsMap.put(enumColor, new ItemDyedFabric(enumColor.toString()));
            GameRegistry.registerItem((fabricItemsMap.get(enumColor)), "fabric_" + enumColor.toString());
        }
    }


    public static void init() {

        for (COLORS enumColor : COLORS.values()) {
            // register dye recipes
            ItemStack stack = new ItemStack(dyeItemsMap.get(enumColor), 1);
            GameRegistry.addRecipe(stack, dyeRecipeMap.get(enumColor));
            // register fabric recipes
            GameRegistry.addRecipe(new ItemStack(fabricItemsMap.get(enumColor), 1),
                    new Object[]{"01X", "XXX", "XXX",
                            Character.valueOf('0'), new ItemStack(cottonFabric, 1),
                            Character.valueOf('1'), new ItemStack(dyeItemsMap.get(enumColor), 1)
                    });
        }
    }

    /**
     * builds the dye specific recipes according to effective color.
     *
     * @param enumColor COLORS enum value to key on.
     */
    public static void buildRecipesByColor() {
        int dyeMetaValue = 0;
        for (COLORS enumColor : COLORS.values()) {
            if (dyeMetaValue < 16) {
                dyeRecipeMap.put(enumColor, getTemplateRecipe(dyeMetaValue));
            } else {
                switch (enumColor) {
                    case coral:
                        dyeRecipeMap.put(enumColor, getCoralRecipe());
                        break;
                    case galaxy:
                        dyeRecipeMap.put(enumColor, getGalaxyRecipe());
                        break;
                    case glowstone:
                        dyeRecipeMap.put(enumColor, getGlowstoneRecipe());
                        break;
                    case lavender:
                        dyeRecipeMap.put(enumColor, getLavenderRecipe());
                        break;
                    case mint:
                        dyeRecipeMap.put(enumColor, getMintRecipe());
                        break;
                    case redstone:
                        dyeRecipeMap.put(enumColor, getRedstoneRecipe());
                        break;
                    case rainbow:
                        dyeRecipeMap.put(enumColor, getRainbowRecipe());
                        break;
                    case tan:
                        dyeRecipeMap.put(enumColor, getTanRecipe());
                        break;
                    case pinklight:
                        dyeRecipeMap.put(enumColor, getPinkLightRecipe());
                        break;
                    default:

                }
            }
            dyeMetaValue++;
        }


    }

    private static Object[] getTemplateRecipe(int dyeMetaValue) {
        return new Object[]{"012", "XXX", "XXX",
                Character.valueOf('0'), new ItemStack(Items.potionitem, 1),
                Character.valueOf('1'), new ItemStack(ClothingCraftHaliteItemList.rockSalt, 1),
                Character.valueOf('2'), new ItemStack(Items.dye, 1, dyeMetaValue)
        };
    }

    private static Object[] getCoralRecipe() {
        return new Object[]{"012", "3XX", "XXX",
                Character.valueOf('0'), new ItemStack(Items.potionitem, 1),
                Character.valueOf('1'), new ItemStack(ClothingCraftHaliteItemList.rockSalt, 1),
                Character.valueOf('2'), new ItemStack(Items.dye, 1, 9),  // pink
                Character.valueOf('3'), new ItemStack(Items.dye, 1, 14), // orange
        };
    }

    private static Object[] getGalaxyRecipe() {
        return new Object[]{"012", "34X", "XXX",
                Character.valueOf('0'), new ItemStack(Items.potionitem, 1),
                Character.valueOf('1'), new ItemStack(ClothingCraftHaliteItemList.rockSalt, 1),
                Character.valueOf('2'), new ItemStack(Items.nether_star, 1), // netherstar item
                Character.valueOf('3'), new ItemStack(Items.dye, 1, 4), // bluedark
                Character.valueOf('4'), new ItemStack(Items.dye, 1, 5), // purple
        };
    }

    private static Object[] getGlowstoneRecipe() {
        return new Object[]{"012", "XXX", "XXX",
                Character.valueOf('0'), new ItemStack(Items.potionitem, 1),
                Character.valueOf('1'), new ItemStack(ClothingCraftHaliteItemList.rockSalt, 1),
                Character.valueOf('2'), new ItemStack(Items.glowstone_dust, 1), // glowstone_dust item
        };
    }

    private static Object[] getLavenderRecipe() {
        return new Object[]{"012", "3XX", "XXX",
                Character.valueOf('0'), new ItemStack(Items.potionitem, 1),
                Character.valueOf('1'), new ItemStack(ClothingCraftHaliteItemList.rockSalt, 1),
                Character.valueOf('2'), new ItemStack(Items.dye, 1, 5),  // purple
                Character.valueOf('3'), new ItemStack(Items.dye, 1, 15), // white
        };
    }

    private static Object[] getMintRecipe() {
        return new Object[]{"012", "3XX", "XXX",
                Character.valueOf('0'), new ItemStack(Items.potionitem, 1),
                Character.valueOf('1'), new ItemStack(ClothingCraftHaliteItemList.rockSalt, 1),
                Character.valueOf('2'), new ItemStack(Items.dye, 1, 2),     // green
                Character.valueOf('3'), new ItemStack(Items.dye, 1, 15), // white
        };
    }

    private static Object[] getRedstoneRecipe() {
        return new Object[]{"012", "XXX", "XXX",
                Character.valueOf('0'), new ItemStack(Items.potionitem, 1),
                Character.valueOf('1'), new ItemStack(ClothingCraftHaliteItemList.rockSalt, 1),
                Character.valueOf('2'), new ItemStack(Items.redstone, 1), // redstone item
        };
    }

    private static Object[] getRainbowRecipe() {
        return new Object[]{"012", "345", "67X",
                Character.valueOf('0'), new ItemStack(Items.potionitem, 1),
                Character.valueOf('1'), new ItemStack(ClothingCraftHaliteItemList.rockSalt, 1),
                Character.valueOf('2'), new ItemStack(Items.dye, 1, 1),  // red
                Character.valueOf('3'), new ItemStack(Items.dye, 1, 14), // orange
                Character.valueOf('4'), new ItemStack(Items.dye, 1, 11), // yellow
                Character.valueOf('5'), new ItemStack(Items.dye, 1, 2),  // green
                Character.valueOf('6'), new ItemStack(Items.dye, 1, 4),  // bluedark
                Character.valueOf('7'), new ItemStack(Items.dye, 1, 5),  // purple
        };
    }

    private static Object[] getTanRecipe() {
        return new Object[]{"012", "3XX", "XXX",
                Character.valueOf('0'), new ItemStack(Items.potionitem, 1),
                Character.valueOf('1'), new ItemStack(ClothingCraftHaliteItemList.rockSalt, 1),
                Character.valueOf('2'), new ItemStack(Items.dye, 1, 3),  // brown
                Character.valueOf('3'), new ItemStack(Items.dye, 1, 15), // white
        };
    }

    private static Object[] getPinkLightRecipe() {
        return new Object[]{"012", "3XX", "XXX",
                Character.valueOf('0'), new ItemStack(Items.potionitem, 1),
                Character.valueOf('1'), new ItemStack(ClothingCraftHaliteItemList.rockSalt, 1),
                Character.valueOf('2'), new ItemStack(Items.dye, 1, 9),  // pink
                Character.valueOf('3'), new ItemStack(Items.dye, 1, 15), // white
        };
    }

    /**
     * 0	Ink Sac				Black
     * 1	Rose Red			Red
     * 2	Cactus Green		Green
     * 3	Cocoa Beans			Brown
     * 4	Lapis Lazuli		Blue Dark
     * 5	Purple Dye			Purple
     * 6	Cyan Dye			Cyan
     * 7	Light Gray Dye		Gray Light
     * 8	Gray Dye			Grey Dark
     * 9	Pink Dye			Pink
     * 10	Lime Dye			Lime
     * 11	Dandelion Yellow	Yellow
     * 12	Light Blue Dye		Blue Light
     * 13	Magenta Dye			Magenta
     * 14	Orange Dye			Orange
     * 15	Bone Meal			White
     * <p>
     * special recipes for the following:
     * - coral,
     * - galaxy,
     * - glowstone,
     * - lavender,
     * - mint,
     * - redstone,
     * - rainbow,
     * - tan,
     * - pinklight,
     *
     * @param enumColor COLORS enum value to key on.
     */
    public static enum COLORS {
        black, red, green, brown, bluedark,
        purple, cyan, graylight, graydark, pink,
        lime, yellow, bluelight, magenta, orange, white,
        galaxy, glowstone, lavender, mint, coral, rainbow, redstone, tan, pinklight
    }
}
