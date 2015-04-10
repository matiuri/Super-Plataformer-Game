package plataformer.screens;

import plataformer.Plataformer;
import plataformer.utils.actors.title.Logo;
import plataformer.utils.actors.title.Platforms;
import plataformer.utils.assets.AssetLoader;

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
	}
}
