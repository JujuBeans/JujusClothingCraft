package clothingcraft.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

import java.util.Random;

/**
 * @author JujuAwesomeBeans
 * @author NinjaSoldier40
 * @since 02/11/2017 10:53 AM
 */
public abstract class RecipeBlockCrops extends BlockCrops implements IGrowable {
    protected int maxGrowthStage = 7;

    @SideOnly(Side.CLIENT)
    protected IIcon[] iIcon;

    public RecipeBlockCrops(int maxGrowthStage) {
        this.maxGrowthStage = maxGrowthStage;
        // Basic block setup
        setTickRandomly(true);
        float f = 0.5F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
        setHardness(0.0F);
        setStepSound(soundTypeGrass);
        disableStats();
    }

    /**
     * @see clothingcraft.blocks.RecipeBlockCrops#canPlaceBlockOn(net.minecraft.block.Block)
     * is the block on farmland?
     */
    @Override
    protected boolean canPlaceBlockOn(Block parBlock) {
        return parBlock == Blocks.farmland;
    }

    public void incrementGrowStage(World parWorld, Random parRand, int parX, int parY, int parZ) {
        int growStage = parWorld.getBlockMetadata(parX, parY, parZ) + MathHelper.getRandomIntegerInRange(parRand, 2, 5);

        if (growStage > maxGrowthStage) {
            growStage = maxGrowthStage;
        }

        parWorld.setBlockMetadataWithNotify(parX, parY, parZ, growStage, 2);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    @Override
    public int quantityDropped(int parMetadata, int parFortune, Random parRand) {
        return (parMetadata / 2);
    }

    @Override
    protected Item func_149866_i() {
        return getItemDropSeeds();
    }

    public abstract Item getItemDropSeeds();

    @Override
    protected Item func_149865_P() {
        return getItemDropProduce();
    }

    public abstract Item getItemDropProduce();

    @Override
    public Item getItemDropped(int parMetadata, Random parRand, int parFortune) {
        // DEBUG
        System.out.println("BlockCottonWildPlant getItemDropped()");
        //return ClothingCraft.cotton;
        int randInt = parRand.nextInt(4);
        Item result = null;
        if (parMetadata == maxGrowthStage) {
            // plant fully grown, could be seed or produce
            if (randInt > 2) {
                result = getItemDropSeeds();
            } else {
                result = getItemDropProduce();
            }
        } else {
            result = getItemDropSeeds();
        }
        return result;
    }

    /**
     * The type of render function that is called for this block
     */
    @Override
    public int getRenderType() {
        return 1; // Cross like flowers
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
        return EnumPlantType.Crop;
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int parSide, int parGrowthStage) {
        if (parGrowthStage < 0 || parGrowthStage > maxGrowthStage) {
            parGrowthStage = maxGrowthStage;
        }
        return iIcon[parGrowthStage];
    }

	/*
     * implement the IGrowable interface methods
	 */

    /**
     * @see net.minecraft.block.IGrowable#func_149851_a(net.minecraft.world.World,
     * int, int, int, boolean)
     */
    @Override
    // checks if finished growing (a grow stage of 8 is final stage)
    public boolean func_149851_a(World parWorld, int parX, int parY, int parZ, boolean p_149851_5_) {
        return parWorld.getBlockMetadata(parX, parY, parZ) != maxGrowthStage;
    }

    /**
     * @see net.minecraft.block.IGrowable#func_149852_a(net.minecraft.world.World,
     * java.util.Random, int, int, int)
     */
    @Override
    public boolean func_149852_a(World p_149852_1_, Random parRand, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
        return true;
    }

    /**
     * @see net.minecraft.block.IGrowable#func_149853_b(net.minecraft.world.World,
     * java.util.Random, int, int, int)
     */
    @Override
    public void func_149853_b(World parWorld, Random parRand, int parX, int parY, int parZ) {
        incrementGrowStage(parWorld, parRand, parX, parY, parZ);
    }
}