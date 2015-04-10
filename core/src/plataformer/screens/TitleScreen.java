package plataformer.screens;

import plataformer.Plataformer;
import plataformer.utils.actors.Logo;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class TitleScreen extends ScreenAdapter {
	private Stage stage;
	private Logo logo;
	
	public TitleScreen(Plataformer game) {
		super(game);
	}
	
	@Override
	public void show() {
		stage = new Stage(new ScreenViewport());
		logo = new Logo();
		logo.setPosition(500, 500);
		stage.addActor(logo);
	}
	
	@Override
	public void render(float delta) {
		Plataformer.clearScreen(Color.WHITE);
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
