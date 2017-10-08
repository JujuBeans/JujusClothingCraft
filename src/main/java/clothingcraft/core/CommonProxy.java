package clothingcraft.core;

import clothingcraft.blocks.ClothingCraftCottonBlockList;
import clothingcraft.blocks.ClothingCraftHaliteBlockList;
import clothingcraft.client.ClientProxy;
import clothingcraft.generation.ClothingCraftWorldGen;
import clothingcraft.items.*;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;

public class CommonProxy implements IFuelHandler {
    public static ClothingCraftWorldGen clothingCraftWorldGen; // generation of cotton plants in the world

    public static Item cotton; // the harvested product from the plant
    public static Item cottonSeeds; // the seeds from the plant
    public static Item cottonArmorHelmet; // cotton armor helmet
    public static Item cottonArmorChestPlate; // cotton armor chest plate
    public static Item cottonArmorLeggings; // cotton armor leggings
    public static Item cottonArmorBoots; // cotton armor boots


    public void preInit(FMLPreInitializationEvent e) {
        /*
         * blocks
		 */

        ClothingCraftCottonBlockList.preInit();
        ClothingCraftHaliteBlockList.preInit();

		/*
         * items
		 */

        // cotton plant produce (harvested)
        cotton = new ItemCotton()
                .setMaxStackSize(64)
                .setUnlocalizedName("cotton_harvested")
                .setCreativeTab(ClientProxy.tabCore)
                .setTextureName(ClothingCraftInfo.MODID + ":cotton_harvested");
        GameRegistry.registerItem(cotton, "cotton_harvested");

        // cotton seeds
        cottonSeeds = new ItemCottonSeeds(ClothingCraftCottonBlockList.cottonPlant, Blocks.farmland)
                .setMaxStackSize(64)
                .setUnlocalizedName("cotton_seeds")
                .setCreativeTab(ClientProxy.tabCore)
                .setTextureName(ClothingCraftInfo.MODID + ":cotton_seeds");
        GameRegistry.registerItem(cottonSeeds, "cotton_seeds");

        // generate cotton seeds when grass is harvested
        MinecraftForge.addGrassSeed(new ItemStack(cottonSeeds), 5);

        ClothingCraftHaliteItemList.preInit(); // halite, rock salt...
        ClothingCraftFabricItemList.preInit(); // cotton fabric, including all other colors
        ClothingCraftToolsItemList.preInit(); // tools: scissors, measuring tape, ...
        ClothingCraftPatternItemList.preInit(); // tools > patterns ...
        ClothingCraftAccessoriesItemList.preInit(); // accessory items
        ClothingCraftWardrobeItemList.preInit(); // wardrobe items (armor)

        ItemArmor.ArmorMaterial CottonArmorMaterial = EnumHelper.addArmorMaterial(
                "cotton_armor", 16, new int[]{3, 8, 6, 3}, 30);

        GameRegistry.registerItem(cottonArmorHelmet = new ItemCottonArmor(
                "cottonArmorHelmet", // unlocalizedName
                "cotton_armor_helmet", // itemTextureName
                CottonArmorMaterial, // armor material
                "cottonarmor_layer", // armorTextureName
                0 // armor type 0 = helmet
        ), "cottonArmorHelmet"); // name key for en_US.lang file
        GameRegistry.registerItem(cottonArmorChestPlate = new ItemCottonArmor(
                "cottonArmorChestPlate", // unlocalizedName
                "cotton_armor_chestplate", // itemTextureName
                CottonArmorMaterial, // armor material
                "cottonarmor_layer", // armorTextureName
                1 // armor type 1 = chest plate
        ), "cottonArmorChestPlate"); // name key for en_US.lang file
        GameRegistry.registerItem(cottonArmorLeggings = new ItemCottonArmor(
                "cottonArmorLeggings", // unlocalizedName
                "cotton_armor_leggings", // itemTextureName
                CottonArmorMaterial, // armor material
                "cottonarmor_layer", // armorTextureName
                2 // armor type 2 = leggings
        ), "cottonArmorLeggings"); // name key for en_US.lang file
        GameRegistry.registerItem(cottonArmorBoots = new ItemCottonArmor(
                "cottonArmorBoots", // unlocalizedName
                "cotton_armor_boots", // itemTextureName
                CottonArmorMaterial, // armor material
                "cottonarmor_layer", // armorTextureName
                3 // armor type 3 = boots
        ), "cottonArmorBoots"); // name key for en_US.lang file
    }

    public void init(FMLInitializationEvent e) {
        /*
         * world generator creates:
		 * 	- wild cotton plants (used in Overworld)
		 * 	- halite ore underground (used in Overworld)
		 */
        clothingCraftWorldGen = new ClothingCraftWorldGen();

        // register generator for world
        GameRegistry.registerWorldGenerator(clothingCraftWorldGen, 10);
        GameRegistry.registerFuelHandler(this);

        GameRegistry.addRecipe(new ItemStack(cottonSeeds, 1),
                "0XX", "XXX", "XXX",
                '0', new ItemStack(cotton, 1));

        GameRegistry.addRecipe(new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                "012", "345", "XXX",
                '0', new ItemStack(cotton, 1),
                '1', new ItemStack(cotton, 1),
                '2', new ItemStack(cotton, 1),
                '3', new ItemStack(cotton, 1),
                '4', new ItemStack(cotton, 1),
                '5', new ItemStack(cotton, 1));

        GameRegistry.addRecipe(new ItemStack(ClothingCraftHaliteBlockList.cottonFabricBundle, 1),
                "012", "345", "678",
                '0', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                '1', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                '2', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                '3', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                '4', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                '5', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                '6', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                '7', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                '8', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1));

        // cotton armor recipes
        GameRegistry.addRecipe(new ItemStack(cottonArmorHelmet, 1),
                "012", "3X5", "XXX",
                '0', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                '1', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                '2', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                '3', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                '5', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1));
        GameRegistry.addRecipe(new ItemStack(cottonArmorChestPlate, 1),
                "0X2", "345", "678",
                '0', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                '2', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                '3', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                '4', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                '5', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                '6', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                '7', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                '8', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1));
        GameRegistry.addRecipe(new ItemStack(cottonArmorLeggings, 1),
                "012", "3X5", "6X8",
                '0', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                '1', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                '2', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                '3', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                '5', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                '6', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                '8', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1));
        GameRegistry.addRecipe(new ItemStack(cottonArmorBoots, 1),
                "0X2", "3X5", "XXX",
                '0', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                '2', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                '3', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                '5', new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1));


        ClothingCraftHaliteItemList.init(); // register recipes for halite, rock salt...
        ClothingCraftFabricItemList.init(); // register recipes for cotton fabric, including all other colors
        ClothingCraftToolsItemList.init(); // register recipes for tools: sewing scissors, measuring tape, ...
        ClothingCraftPatternItemList.init(); // register recipes for tools: patterns by category (beach, career, casual, costume, formal, sleep)
        ClothingCraftAccessoriesItemList.init(); // register recipes for accessory items
        ClothingCraftWardrobeItemList.init(); // register recipes for wardrobe items
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

    /**
     * @see cpw.mods.fml.common.IFuelHandler#getBurnTime(net.minecraft.item.ItemStack)
     */
    @Override
    public int getBurnTime(ItemStack fuel) {
        // TODO Auto-generated method stub
        return 0;
    }
}
