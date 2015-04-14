package plataformer.utils.actors.title;

import static plataformer.screens.TitleScreen.assetLoader;
import plataformer.utils.assets.AssetLoader.Cluster;
import plataformer.utils.textures.Animation;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

public class Logo extends Actor implements Disposable {
	private Animation animation;
	
	public Logo() {
		assetLoader.load(Texture.class, new Cluster("Title/Logo/Logo0.png", "Logo0"), new Cluster("Title/Logo/Logo1.png", "Logo1"), new Cluster(
				"Title/Logo/Logo2.png", "Logo2"), new Cluster("Title/Logo/Logo3.png", "Logo3"), new Cluster("Title/Logo/Logo4.png", "Logo4"));
		
		animation = new Animation(0.05f, true, assetLoader.get(Texture.class, "Logo0"), assetLoader.get(Texture.class, "Logo1"), assetLoader.get(
				Texture.class, "Logo2"), assetLoader.get(Texture.class, "Logo3"), assetLoader.get(Texture.class, "Logo4"), assetLoader.get(
				Texture.class, "Logo3"), assetLoader.get(Texture.class, "Logo2"), assetLoader.get(Texture.class, "Logo1"));
		
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
		assetLoader.remove("Logo0", "Logo1", "Logo2", "Logo3", "Logo4");
	}
}
