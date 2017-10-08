/**
 *
 */
package clothingcraft.items;

import clothingcraft.core.ClothingCraftInfo;
import clothingcraft.core.CommonProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * armor made of cotton
 *
 * @author JujuAwesomeBeans
 * @author NinjaSoldier40
 * @since 02/07/2017 07:06 PM (-07:00 GMT)
 */
public class ItemCottonArmor extends ItemArmor {
    private String textureName;
    private String itemTextureName;

    public ItemCottonArmor(String unlocalizedName, String itemTextureName, ArmorMaterial material, String armorTextureName, int type) {
        super(material, 0, type);
        this.textureName = armorTextureName;
        this.itemTextureName = itemTextureName;
        this.setUnlocalizedName(unlocalizedName);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return ClothingCraftInfo.MODID + ":textures/models/armor/" + this.textureName + "_" + (this.armorType == 2 ? "2" : "1") + ".png";
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if (player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem() == CommonProxy.cottonArmorBoots) {
            player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 40));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(String.format("%s%s", ClothingCraftInfo.MODID + ":", this.itemTextureName));
    }
}

