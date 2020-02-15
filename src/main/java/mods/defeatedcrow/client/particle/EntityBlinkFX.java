package mods.defeatedcrow.client.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EntityBlinkFX extends EntityFX {

	public EntityBlinkFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12) {
		super(par1World, par2, par4, par6);
		this.motionX = par8;
		this.motionY = par10;
		this.motionZ = par12;
		this.noClip = false;
	}

	@Override
	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;

		this.moveEntity(this.motionX, this.motionY, this.motionZ);

		if (this.particleScale > 0.05F) {
			this.particleScale = this.particleScale - 0.05F;
		} else {
			this.setDead();
		}

		this.motionX *= 0.90D;
		this.motionY *= 0.90D;
		this.motionZ *= 0.90D;
	}

	@Override
	public int getFXLayer() {
		return 2;
	}

}
