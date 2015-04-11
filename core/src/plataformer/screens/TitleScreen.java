package plataformer.screens;

import plataformer.Plataformer;
import plataformer.input.title.TitleListener;
import plataformer.utils.actors.title.Logo;
import plataformer.utils.actors.title.Platforms;
import plataformer.utils.assets.AssetLoader;
import plataformer.utils.assets.AssetLoader.Cluster;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class TitleScreen extends ScreenAdapter {
	private Stage stage;
	private Logo logo;
	private Platforms plat;
	private Music base, top;
	
	public static AssetLoader assetLoader = new AssetLoader();
	
	public TitleScreen(Plataformer game) {
		super(game);
	}
	
	@Override
	public void show() {
		stage = new Stage(new ScreenViewport());
		logo = new Logo();
		logo.setPosition(stage.getViewport().getWorldWidth() / 2 - logo.getWidth() / 2, stage.getViewport().getWorldHeight() / 2 - logo.getHeight()
				/ 2);
		stage.addActor(logo);
		
		plat = new Platforms();
		plat.setPosition(50, stage.getViewport().getWorldHeight() - plat.getHeight() - 50);
		stage.addActor(plat);
		
		plat.addListener(new TitleListener<Platforms>(plat));
		Gdx.input.setInputProcessor(stage);
		
		assetLoader.load(Music.class, new Cluster("Title/Music/LoopBase.ogg", "Base"), new Cluster("Title/Music/LoopTop.ogg", "Top"));
		base = assetLoader.get(Music.class, "Base");
		base.setLooping(true);
		base.setVolume(0.5f);
		base.play();
		
		top = assetLoader.get(Music.class, "Top");
		top.setLooping(true);
		top.setVolume(0.1f);
		top.play();
	}
	
	@Override
	public void render(float delta) {
		Plataformer.clearScreen(Color.ORANGE);
		stage.act(delta);
		stage.draw();
	}
	
	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height);
	}
	
	@Override
	public void hide() {
		Array<Actor> actors = new Array<>();
		actors = stage.getActors();
		for (Actor a : actors) {
			if (a instanceof Disposable)
				((Disposable) a).dispose();
		}
		base.stop();
		top.stop();
		assetLoader.remove("Base", "Top");
		stage.dispose();
	}
}
