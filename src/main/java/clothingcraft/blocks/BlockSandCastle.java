package clothingcraft.blocks;

import clothingcraft.client.ClientProxy;
import clothingcraft.core.ClothingCraftInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockSandCastle extends Block {

    boolean red = false;

    protected BlockSandCastle() {
        super(Material.ground);
        this.setBlockName("sandcastle");
        this.setBlockTextureName(ClothingCraftInfo.MODID + ":sandcastle");
        this.setStepSound(Block.soundTypeSand);
        this.setCreativeTab(ClientProxy.tabAccessories);
        this.setHarvestLevel("shovel", 0);
        this.setBlockBounds(
                0.30000000000000004F,
                0.0F,
                0.30000000000000004F,
                0.7000000000000001F,
                0.7000000000000001F,
                0.7F
        );

    }

    public int isProvidingStrongPower(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
        return red ? 1 : 0;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k) {
        return null;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public int getRenderType() {
        return 1;
    }

    @Override
    public int tickRate(World world) {
        return 10;
    }

    public int quantityDropped(Random par1Random) {
        return 1;
    }

}