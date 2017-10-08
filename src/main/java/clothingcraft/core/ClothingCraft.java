package clothingcraft.core;

import clothingcraft.blocks.ClothingCraftCottonBlockList;
import clothingcraft.blocks.ClothingCraftHaliteBlockList;
import clothingcraft.generation.ClothingCraftWorldGen;
import clothingcraft.gui.CreativeTabsClothingCraft;
import clothingcraft.items.*;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = ClothingCraftInfo.MODID, name = ClothingCraftInfo.NAME, version = ClothingCraftInfo.VERSION)
public class ClothingCraft implements IFuelHandler {

    @SidedProxy(
            clientSide = "clothingcraft.client.ClientProxy",
            serverSide = "clothingcraft.core.CommonProxy"
    )
    public static CommonProxy proxy;

    @Instance(ClothingCraftInfo.MODID)
    public static ClothingCraft instance;

    public static CreativeTabs tabCore;
    public static CreativeTabs tabMaterials;
    public static CreativeTabs tabTools;
    public static CreativeTabs tabAccessories;
    public static CreativeTabs tabWardrobe;


    public static ItemCottonSeeds cottonSeeds; // the seeds from the plant
    public static ClothingCraftWorldGen clothingCraftWorldGen; // generation of cotton plants in the world

    public static Item cotton; // the harvested product from the plant

    public static ArmorMaterial ARMOR = EnumHelper.addArmorMaterial(
            "cotton_armor", 16, new int[]{3, 8, 6, 3}, 30);
    public static Item cottonArmorHelmet; // cotton armor helmet
    public static Item cottonArmorChestPlate; // cotton armor chest plate
    public static Item cottonArmorLeggings; // cotton armor leggings
    public static Item cottonArmorBoots; // cotton armor boots

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);

        tabCore = new CreativeTabsClothingCraft("tabClothingCraftCore") {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {
                return ClothingCraft.cotton;
            }
        };
        tabMaterials = new CreativeTabsClothingCraft("tabClothingCraftMaterials") {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {
                return ClothingCraftFabricItemList.cottonFabric;
            }
        };
        tabTools = new CreativeTabsClothingCraft("tabClothingCraftTools") {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {
                return ClothingCraftToolsItemList.sewingScissors;
            }
        };
        tabAccessories = new CreativeTabsClothingCraft("tabClothingCraftAccessories") {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {
                return ClothingCraftAccessoriesItemList.purse;
            }
        };
        tabWardrobe = new CreativeTabsClothingCraft("tabClothingCraftWardrobe") {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {
                return ClothingCraftToolsItemList.needleAndThread;
            }
        };

		/*
		 * blocks
		 */

        // cotton blocks
        ClothingCraftCottonBlockList.preInit();
        // halite ore and block
        ClothingCraftHaliteBlockList.preInit();
		
		
		/*
		 * items
		 */

        // cotton plant produce (harvested)
        cotton = (Item) new ItemCotton()
                .setMaxStackSize(64)
                .setUnlocalizedName("cotton_harvested")
                .setCreativeTab(ClothingCraft.tabCore)
                .setTextureName(ClothingCraftInfo.MODID + ":cotton_harvested");
        GameRegistry.registerItem(cotton, "cotton_harvested");

        // cotton seeds
        cottonSeeds = (ItemCottonSeeds) (new ItemCottonSeeds(ClothingCraftCottonBlockList.cottonPlant, Blocks.farmland)
                .setMaxStackSize(64)
                .setUnlocalizedName("cotton_seeds")
                .setCreativeTab(ClothingCraft.tabCore)
                .setTextureName(ClothingCraftInfo.MODID + ":cotton_seeds"));
        GameRegistry.registerItem(cottonSeeds, "cotton_seeds");
        // generate cotton seeds when grass is harvested
        MinecraftForge.addGrassSeed(new ItemStack(cottonSeeds), 5);

        // halite, rock salt...
        ClothingCraftHaliteItemList.preInit();

        // cotton fabric, including all other colors
        ClothingCraftFabricItemList.preInit();

        // tools: scissors, measuring tape, ...
        ClothingCraftToolsItemList.preInit();

        // tools > patterns ...
        ClothingCraftPatternItemList.preInit();

        // accessory items
        ClothingCraftAccessoriesItemList.preInit();

        // wardrobe items (armor)
        ClothingCraftWardrobeItemList.preInit();

        GameRegistry.registerItem(cottonArmorHelmet = new ItemCottonArmor(
                "cottonArmorHelmet", // unlocalizedName
                "cotton_armor_helmet", // itemTextureName
                ARMOR, // armor material
                "cottonarmor_layer", // armorTextureName
                0 // armor type 0 = helmet
        ), "cottonArmorHelmet"); // name key for en_US.lang file
        GameRegistry.registerItem(cottonArmorChestPlate = new ItemCottonArmor(
                "cottonArmorChestPlate", // unlocalizedName
                "cotton_armor_chestplate", // itemTextureName
                ARMOR, // armor material
                "cottonarmor_layer", // armorTextureName
                1 // armor type 1 = chest plate
        ), "cottonArmorChestPlate"); // name key for en_US.lang file
        GameRegistry.registerItem(cottonArmorLeggings = new ItemCottonArmor(
                "cottonArmorLeggings", // unlocalizedName
                "cotton_armor_leggings", // itemTextureName
                ARMOR, // armor material
                "cottonarmor_layer", // armorTextureName
                2 // armor type 2 = leggings
        ), "cottonArmorLeggings"); // name key for en_US.lang file
        GameRegistry.registerItem(cottonArmorBoots = new ItemCottonArmor(
                "cottonArmorBoots", // unlocalizedName
                "cotton_armor_boots", // itemTextureName
                ARMOR, // armor material
                "cottonarmor_layer", // armorTextureName
                3 // armor type 3 = boots
        ), "cottonArmorBoots"); // name key for en_US.lang file
    }


    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    	
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
                new Object[]{"0XX", "XXX", "XXX",
                        Character.valueOf('0'), new ItemStack(cotton, 1),});


        GameRegistry.addRecipe(new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                new Object[]{"012", "345", "XXX",
                        Character.valueOf('0'), new ItemStack(cotton, 1),
                        Character.valueOf('1'), new ItemStack(cotton, 1),
                        Character.valueOf('2'), new ItemStack(cotton, 1),
                        Character.valueOf('3'), new ItemStack(cotton, 1),
                        Character.valueOf('4'), new ItemStack(cotton, 1),
                        Character.valueOf('5'), new ItemStack(cotton, 1),
                });

        GameRegistry.addRecipe(new ItemStack(ClothingCraftHaliteBlockList.cottonFabricBundle, 1),
                new Object[]{"012", "345", "678",
                        Character.valueOf('0'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                        Character.valueOf('1'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                        Character.valueOf('2'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                        Character.valueOf('3'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                        Character.valueOf('4'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                        Character.valueOf('5'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                        Character.valueOf('6'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                        Character.valueOf('7'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                        Character.valueOf('8'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                });

        // cotton armor recipes
        GameRegistry.addRecipe(new ItemStack(cottonArmorHelmet, 1),
                new Object[]{"012", "3X5", "XXX",
                        Character.valueOf('0'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                        Character.valueOf('1'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                        Character.valueOf('2'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                        Character.valueOf('3'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                        Character.valueOf('5'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                });
        GameRegistry.addRecipe(new ItemStack(cottonArmorChestPlate, 1),
                new Object[]{"0X2", "345", "678",
                        Character.valueOf('0'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                        Character.valueOf('2'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                        Character.valueOf('3'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                        Character.valueOf('4'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                        Character.valueOf('5'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                        Character.valueOf('6'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                        Character.valueOf('7'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                        Character.valueOf('8'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                });
        GameRegistry.addRecipe(new ItemStack(cottonArmorLeggings, 1),
                new Object[]{"012", "3X5", "6X8",
                        Character.valueOf('0'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                        Character.valueOf('1'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                        Character.valueOf('2'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                        Character.valueOf('3'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                        Character.valueOf('5'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                        Character.valueOf('6'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                        Character.valueOf('8'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                });
        GameRegistry.addRecipe(new ItemStack(cottonArmorBoots, 1),
                new Object[]{"0X2", "3X5", "XXX",
                        Character.valueOf('0'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                        Character.valueOf('2'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                        Character.valueOf('3'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                        Character.valueOf('5'), new ItemStack(ClothingCraftFabricItemList.cottonFabric, 1),
                });

        // place armor pieces into core tab
        cottonArmorHelmet.setCreativeTab(ClothingCraft.tabCore);
        cottonArmorChestPlate.setCreativeTab(ClothingCraft.tabCore);
        cottonArmorLeggings.setCreativeTab(ClothingCraft.tabCore);
        cottonArmorBoots.setCreativeTab(ClothingCraft.tabCore);

        // register recipes for halite, rock salt...
        ClothingCraftHaliteItemList.init();

        // register recipes for cotton fabric, including all other colors
        ClothingCraftFabricItemList.init();

        // register recipes for tools: sewing scissors, measuring tape, ...
        ClothingCraftToolsItemList.init();

        // register recipes for tools: patterns by category (beach, career, casual, costume, formal, sleep)
        ClothingCraftPatternItemList.init();

        // register recipes for accessory items
        ClothingCraftAccessoriesItemList.init();

        // register recipes for wardrobe items
        ClothingCraftWardrobeItemList.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
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
