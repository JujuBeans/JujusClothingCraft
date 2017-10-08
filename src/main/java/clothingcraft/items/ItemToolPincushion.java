package clothingcraft.items;

import clothingcraft.client.ClientProxy;
import clothingcraft.core.ClothingCraftInfo;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemToolPincushion extends Item {
    protected float efficiencyOnProperMaterial;
    // harvest level
    int harvest = 1;
    private Block[] blocksEffectiveAgainst = new Block[]{

    };

    protected ItemToolPincushion() {
        efficiencyOnProperMaterial = 6;
        setMaxDamage(100);
        setMaxStackSize(1);
        setUnlocalizedName("tools_pincushion");
        setTextureName(ClothingCraftInfo.MODID + ":tools_pincushion");
        setCreativeTab(ClientProxy.tabTools);
    }

    /**
     * Returns the strength of the stack against a given block. 1.0F base,
     * (Quality+1)*2 if correct blocktype, 1.5F if sword
     */
    public float func_150893_a(ItemStack par1ItemStack, Block par2Block) {
        for (int i = 0; i < blocksEffectiveAgainst.length; i++) {
            if (blocksEffectiveAgainst[i] == par2Block) {
                return efficiencyOnProperMaterial;
            }
        }

        return 0.0F;
    }

    /**
     * Current implementations of this method in child classes do not use the
     * entry argument beside ev. They just raise the damage on the stack.
     */
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLiving,
                             EntityLivingBase par3EntityLiving) {
        par1ItemStack.damageItem(2, par3EntityLiving);
        return true;
    }

    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, Block par3, int par4, int par5, int par6,
                                    EntityLivingBase par7EntityLiving) {
        par1ItemStack.damageItem(1, par7EntityLiving);
        return true;
    }

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D() {
        return true;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based
     * on material.
     */
    public int getItemEnchantability() {
        return 2;
    }
}