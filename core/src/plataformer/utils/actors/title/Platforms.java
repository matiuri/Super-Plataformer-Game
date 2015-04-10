package plataformer.utils.actors.title;

import static plataformer.screens.TitleScreen.assetLoader;
import plataformer.utils.assets.AssetLoader.Cluster;
import plataformer.utils.textures.Animation;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

public class Platforms extends Actor implements Disposable {
	private Animation animation;
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
		
		animation = new Animation(0.05f, true, assetLoader.get(Texture.class, "Platforms" + (counter++)), assetLoader.get(Texture.class, "Platforms"
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
		animation.updateFrame(delta);
	}
	
	@Override
	public void dispose() {
		assetLoader.remove("Platforms" + (counter++), "Platforms" + (counter++), "Platforms" + (counter++), "Platforms" + (counter++), "Platforms"
				+ (counter++), "Platforms" + (counter++), "Platforms" + (counter++), "Platforms" + (counter++), "Platforms" + (counter++),
				"Platforms" + (counter++), "Platforms" + (counter++), "Platforms" + (counter++), "Platforms" + (counter++),
				"Platforms" + (counter++), "Platforms" + (counter++), "Platforms" + (counter++), "Platforms" + (counter++),
				"Platforms" + (counter++), "Platforms" + (counter++), "Platforms" + (counter++));
	}
}
