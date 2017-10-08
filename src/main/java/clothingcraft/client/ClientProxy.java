package clothingcraft.client;

import clothingcraft.core.CommonProxy;
import clothingcraft.gui.CreativeTabsClothingCraft;
import clothingcraft.items.ClothingCraftAccessoriesItemList;
import clothingcraft.items.ClothingCraftFabricItemList;
import clothingcraft.items.ClothingCraftToolsItemList;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ClientProxy extends CommonProxy {
    public static CreativeTabs tabCore = new CreativeTabsClothingCraft("tabClothingCraftCore") {
        public Item getTabIconItem() {
            return cotton;
        }
    };
    public static CreativeTabs tabMaterials = new CreativeTabsClothingCraft("tabClothingCraftMaterials") {
        public Item getTabIconItem() {
            return ClothingCraftFabricItemList.cottonFabric;
        }
    };
    public static CreativeTabs tabTools = new CreativeTabsClothingCraft("tabClothingCraftTools") {
        public Item getTabIconItem() {
            return ClothingCraftToolsItemList.sewingScissors;
        }
    };
    public static CreativeTabs tabAccessories = new CreativeTabsClothingCraft("tabClothingCraftAccessories") {
        public Item getTabIconItem() {
            return ClothingCraftAccessoriesItemList.purse;
        }
    };
    public static CreativeTabs tabWardrobe = new CreativeTabsClothingCraft("tabClothingCraftWardrobe") {
        public Item getTabIconItem() {
            return ClothingCraftToolsItemList.needleAndThread;
        }
    };

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);

        // place armor pieces into core tab
        cottonArmorHelmet.setCreativeTab(ClientProxy.tabCore);
        cottonArmorChestPlate.setCreativeTab(ClientProxy.tabCore);
        cottonArmorLeggings.setCreativeTab(ClientProxy.tabCore);
        cottonArmorBoots.setCreativeTab(ClientProxy.tabCore);
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }
}
