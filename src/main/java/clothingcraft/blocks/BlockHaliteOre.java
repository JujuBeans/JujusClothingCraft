package clothingcraft.blocks;

import clothingcraft.core.ClothingCraft;
import clothingcraft.core.ClothingCraftInfo;
import clothingcraft.items.ClothingCraftHaliteItemList;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

public class BlockHaliteOre extends Block {

    private Item drop;
    private int meta;
    private int least_quantity;
    private int most_quantity;

    public BlockHaliteOre() {
        this("halite_ore", Material.rock, ClothingCraft.tabCore, ClothingCraftHaliteItemList.rockSalt, 2, 2, 4);
    }

    protected BlockHaliteOre(String unlocalizedName, Material mat, CreativeTabs tab, Item drop, int meta, int least_quantity, int most_quantity) {
        super(mat);
        this.drop = drop;
        this.meta = meta;
        this.least_quantity = least_quantity;
        this.most_quantity = most_quantity;
        this.setBlockName(unlocalizedName);
        this.setBlockTextureName(ClothingCraftInfo.MODID + ":" + unlocalizedName);
        this.setCreativeTab(tab);
        this.setStepSound(soundTypeStone);
        this.setHardness(10.0f);
        this.setResistance(20.0f);
        this.setHarvestLevel("pickaxe", 1);
        this.setLightLevel(10.0F);
        this.setLightOpacity(200);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    @Override
    public Item getItemDropped(int meta, Random random, int fortune) {
        return this.drop;
    }

    @Override
    public int damageDropped(int metadata) {
        return this.meta;
    }

    @Override
    public int quantityDropped(int meta, int fortune, Random random) {
        if (this.least_quantity >= this.most_quantity)
            return this.least_quantity;
        return this.least_quantity + random.nextInt(this.most_quantity - this.least_quantity + fortune + 1);
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        //return super.getDrops(world, x, y, z, metadata, fortune);

        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
        drops.add(new ItemStack(ClothingCraftHaliteItemList.rockSalt, world.rand.nextInt(3) + 1));
        return drops;
    }
}