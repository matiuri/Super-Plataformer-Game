package plataformer.utils.textures;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animation {
	private TextureRegion[] animation;
	private int actualPos = 0;
	private float speed, counter = 0;
	private boolean loop;
	
	public Animation(Texture[] tex, float speed, boolean loop) {
		animation = new TextureRegion[tex.length];
		for (int i = 0; i < tex.length; i++) {
			animation[i] = new TextureRegion(tex[i]);
		}
		
		this.speed = speed;
		this.loop = loop;
	}
	
	public Animation(Texture[][] tex, float speed, boolean loop) {
		animation = new TextureRegion[tex.length * tex[0].length];
		int counter = 0;
		for (int i = 0; i < tex.length; i++) {
			for (int j = 0; j < tex[i].length; j++) {
				animation[counter] = new TextureRegion(tex[i][j]);
			}
		}
		
		this.speed = speed;
		this.loop = loop;
	}
	
	public Animation(float speed, boolean loop, Texture... tex) {
		this(tex, speed, loop);
	}
	
	public Animation(TextureRegion[] reg, float speed, boolean loop) {
		animation = new TextureRegion[reg.length];
		for (int i = 0; i < reg.length; i++) {
			animation[i] = reg[i];
		}
		
		this.speed = speed;
		this.loop = loop;
	}
	
	public Animation(TextureRegion[][] reg, float speed, boolean loop) {
		animation = new TextureRegion[reg.length * reg[0].length];
		int counter = 0;
		for (int i = 0; i < reg.length; i++) {
			for (int j = 0; j < reg[i].length; j++) {
				animation[counter] = reg[i][j];
			}
		}
		
		this.speed = speed;
		this.loop = loop;
	}
	
	public Animation(float speed, boolean loop, TextureRegion... reg) {
		this(reg, speed, loop);
	}
	
	public void updateFrame(float delta) {
		counter += delta;
		if (counter >= speed) {
			counter = 0;
			if (actualPos == animation.length - 1 && !loop)
				return;
			if ((++actualPos) == animation.length && loop)
				actualPos = 0;
		}
	}
	
	public TextureRegion getActualFrame() {
		return animation[actualPos];
	}
	
	public TextureRegion GetUpdatedFrame(float delta) {
		updateFrame(delta);
		return getActualFrame();
	}
}
