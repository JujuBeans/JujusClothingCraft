/**
 * 
 */
package clothingcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

/**
 * 
 * @author JujuAwesomeBeans
 * @author NinjaSoldier40
 * @since 02/07/2017 05:25 AM
 */
public class BlockCottonBale extends Block {

	public IIcon[] icons = new IIcon[6];
	
	public BlockCottonBale(Material material) {
		super(material);
	}
	
	@Override
    public void registerBlockIcons(IIconRegister reg) {
        for (int i = 0; i < 6; i ++) {
            int imgNum = 1;
        	if (i == 0 || i == 1) { 
        		// only 2 of the sides will show without bale bands.
        		imgNum = 2; 
        	}
        	this.icons[i] = reg.registerIcon(this.textureName + "_" + imgNum);
        }
    }
    
    @Override
    public IIcon getIcon(int side, int meta) {
        return this.icons[side];
    }

}
