package clothingcraft.items;

import clothingcraft.client.ClientProxy;
import clothingcraft.core.ClothingCraftInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

/**
 * @author JujuAwesomeBeans
 * @author NinjaSoldier40
 * @since 02/12/2017 08:58 PM (-07:00 GMT)
 */
public class ItemWardrobeArmor extends ItemArmor {

    public static final int HEAD = 0;
    public static final int BODY = 1;
    public static final int LEGS = 2;
    public static final int FEET = 3;

    private String textureName;
    private String itemTextureName;

    /**
     * Convenience method that calls more complex on with simpler arguments set.
     *
     * @param unlocalizedName
     * @param material
     * @param renderIndex
     * @param armorType
     */
    public ItemWardrobeArmor(String unlocalizedName, ArmorMaterial material, int renderIndex, int armorType) {
        this(unlocalizedName, unlocalizedName, unlocalizedName, material, renderIndex, armorType);
    }

    /**
     * @param unlocalizedName
     * @param itemTextureName
     * @param armorTextureName
     * @param material
     * @param renderIndex      0 = cloth, 1 = chain, 2 = iron, 3 = diamond, 4 = gold, [new ItemArmor.ArmorMaterial]
     * @param armorType
     */
    public ItemWardrobeArmor(
            String unlocalizedName, String itemTextureName, String armorTextureName,
            ArmorMaterial material, int renderIndex, int armorType
    ) {
        super(material, renderIndex, armorType);
        this.textureName = armorTextureName;
        this.itemTextureName = itemTextureName;
        this.setUnlocalizedName("wardrobe_" + unlocalizedName + getTextureSuffix(armorType));
        this.setCreativeTab(ClientProxy.tabWardrobe);
    }

    public static String getTextureSuffix(int armorType) {
        switch (armorType) {
            case HEAD:
                return "_helm";
            case BODY:
                return "_body";
            case LEGS:
                return "_pants";
            case FEET:
                return "_shoes";
            default:
                return "";
        }
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return ClothingCraftInfo.MODID + ":textures/models/wardrobe/" + this.textureName + "_layer_" + (this.armorType == 2 ? "2" : "1") + ".png";
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(String.format("%s%s", ClothingCraftInfo.MODID + ":wardrobe_", this.itemTextureName + getTextureSuffix(armorType)));
    }

}
