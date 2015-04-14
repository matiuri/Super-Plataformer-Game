package plataformer.utils.actors.title;

import static plataformer.screens.TitleScreen.assetLoader;
import plataformer.utils.assets.AssetLoader.Cluster;
import plataformer.utils.textures.Animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

public class Platforms extends Actor implements Disposable, Button {
	private Animation animation;
	private boolean play = false, pressed = false, checked = false;
	private int counter = 0;
	
	public Platforms() {
		assetLoader.load(Texture.class, new Cluster("Title/Platforms/Platforms" + counter + ".png", "Platforms" + (counter++)), new Cluster(
				"Title/Platforms/Platforms" + counter + ".png", "Platforms" + (counter++)), new Cluster("Title/Platforms/Platforms" + counter
				+ ".png", "Platforms" + (counter++)), new Cluster("Title/Platforms/Platforms" + counter + ".png", "Platforms" + (counter++)),
				new Cluster("Title/Platforms/Platforms" + counter + ".png", "Platforms" + (counter++)), new Cluster("Title/Platforms/Platforms"
						+ counter + ".png", "Platforms" + (counter++)), new Cluster("Title/Platforms/Platforms" + counter + ".png", "Platforms"
						+ (counter++)), new Cluster("Title/Platforms/Platforms" + counter + ".png", "Platforms" + (counter++)), new Cluster(
						"Title/Platforms/Platforms" + counter + ".png", "Platforms" + (counter++)), new Cluster("Title/Platforms/Platforms" + counter
						+ ".png", "Platforms" + (counter++)), new Cluster("Title/Platforms/Platforms" + counter + ".png", "Platforms" + (counter++)),
				new Cluster("Title/Platforms/Platforms" + counter + ".png", "Platforms" + (counter++)), new Cluster("Title/Platforms/Platforms"
						+ counter + ".png", "Platforms" + (counter++)), new Cluster("Title/Platforms/Platforms" + counter + ".png", "Platforms"
						+ (counter++)), new Cluster("Title/Platforms/Platforms" + counter + ".png", "Platforms" + (counter++)), new Cluster(
						"Title/Platforms/Platforms" + counter + ".png", "Platforms" + (counter++)), new Cluster("Title/Platforms/Platforms" + counter
						+ ".png", "Platforms" + (counter++)), new Cluster("Title/Platforms/Platforms" + counter + ".png", "Platforms" + (counter++)),
				new Cluster("Title/Platforms/Platforms" + counter + ".png", "Platforms" + (counter++)), new Cluster("Title/Platforms/Platforms"
						+ counter + ".png", "Platforms" + (counter++)));
		counter = 0;
		
		animation = new Animation(0.02f, true, assetLoader.get(Texture.class, "Platforms" + (counter++)), assetLoader.get(Texture.class, "Platforms"
				+ (counter++)), assetLoader.get(Texture.class, "Platforms" + (counter++)), assetLoader.get(Texture.class, "Platforms" + (counter++)),
				assetLoader.get(Texture.class, "Platforms" + (counter++)), assetLoader.get(Texture.class, "Platforms" + (counter++)),
				assetLoader.get(Texture.class, "Platforms" + (counter++)), assetLoader.get(Texture.class, "Platforms" + (counter++)),
				assetLoader.get(Texture.class, "Platforms" + (counter++)), assetLoader.get(Texture.class, "Platforms" + (counter++)),
				assetLoader.get(Texture.class, "Platforms" + (counter++)), assetLoader.get(Texture.class, "Platforms" + (counter++)),
				assetLoader.get(Texture.class, "Platforms" + (counter++)), assetLoader.get(Texture.class, "Platforms" + (counter++)),
				assetLoader.get(Texture.class, "Platforms" + (counter++)), assetLoader.get(Texture.class, "Platforms" + (counter++)),
				assetLoader.get(Texture.class, "Platforms" + (counter++)), assetLoader.get(Texture.class, "Platforms" + (counter++)),
				assetLoader.get(Texture.class, "Platforms" + (counter++)), assetLoader.get(Texture.class, "Platforms" + (counter--)),
				assetLoader.get(Texture.class, "Platforms" + (counter--)), assetLoader.get(Texture.class, "Platforms" + (counter--)),
				assetLoader.get(Texture.class, "Platforms" + (counter--)), assetLoader.get(Texture.class, "Platforms" + (counter--)),
				assetLoader.get(Texture.class, "Platforms" + (counter--)), assetLoader.get(Texture.class, "Platforms" + (counter--)),
				assetLoader.get(Texture.class, "Platforms" + (counter--)), assetLoader.get(Texture.class, "Platforms" + (counter--)),
				assetLoader.get(Texture.class, "Platforms" + (counter--)), assetLoader.get(Texture.class, "Platforms" + (counter--)),
				assetLoader.get(Texture.class, "Platforms" + (counter--)), assetLoader.get(Texture.class, "Platforms" + (counter--)),
				assetLoader.get(Texture.class, "Platforms" + (counter--)), assetLoader.get(Texture.class, "Platforms" + (counter--)),
				assetLoader.get(Texture.class, "Platforms" + (counter--)), assetLoader.get(Texture.class, "Platforms" + (counter--)),
				assetLoader.get(Texture.class, "Platforms" + (counter--)), assetLoader.get(Texture.class, "Platforms" + (counter--)));
		counter = 0;
		
		setSize(animation.getActualFrame().getRegionWidth(), animation.getActualFrame().getRegionHeight());
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(animation.getActualFrame(), getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(),
				getRotation());
	}
	
	@Override
	public void act(float delta) {
		if (pressed) {
			animation.setSpeed(0.002f);
		} else {
			animation.setSpeed(0.02f);
		}
		if (play)
			animation.updateFrame(delta);
		// TODO: change this WRONG action
		if (checked) {
			System.out.println("Exit");
			Gdx.app.exit();
		}
	}
	
	@Override
	public void dispose() {
		assetLoader.remove("Platforms" + (counter++), "Platforms" + (counter++), "Platforms" + (counter++), "Platforms" + (counter++), "Platforms"
				+ (counter++), "Platforms" + (counter++), "Platforms" + (counter++), "Platforms" + (counter++), "Platforms" + (counter++),
				"Platforms" + (counter++), "Platforms" + (counter++), "Platforms" + (counter++), "Platforms" + (counter++),
				"Platforms" + (counter++), "Platforms" + (counter++), "Platforms" + (counter++), "Platforms" + (counter++),
				"Platforms" + (counter++), "Platforms" + (counter++), "Platforms" + (counter++));
	}
	
	@Override
	public boolean isPressed() {
		return pressed;
	}
	
	@Override
	public void setPressed(boolean pressed) {
		this.pressed = pressed;
	}
	
	@Override
	public boolean shouldPlay() {
		return play;
	}
	
	@Override
	public void setPlay(boolean play) {
		this.play = play;
	}
	
	@Override
	public boolean isChecked() {
		return checked;
	}
	
	@Override
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
