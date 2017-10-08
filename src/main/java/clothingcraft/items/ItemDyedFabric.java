package clothingcraft.items;

import clothingcraft.core.ClothingCraft;
import clothingcraft.core.ClothingCraftInfo;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemDyedFabric extends Item {

    public ItemDyedFabric(String unlocalizedName) {
        super();
        setMaxDamage(0);
        setMaxStackSize(64);
        setUnlocalizedName("fabric_" + unlocalizedName);
        setTextureName(ClothingCraftInfo.MODID + ":fabric_" + unlocalizedName);
        setCreativeTab(ClothingCraft.tabMaterials);
    }

    public int getItemEnchantability() {
        return 0;
    }

    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
        return 0;
    }

    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {
        return 1.0F;
    }

}