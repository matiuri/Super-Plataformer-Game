package plataformer.screens;

import plataformer.Plataformer;

import com.badlogic.gdx.Screen;

public abstract class ScreenAdapter implements Screen {
	protected Plataformer game;
	
	public ScreenAdapter(Plataformer game) {
		this.game = game;
	}
	
	@Override
	public abstract void show();
	
	@Override
	public abstract void render(float delta);
	
	@Override
	public abstract void resize(int width, int height);
	
	@Override
	public abstract void hide();
	
	@Override
	public void pause() {
		// Implementable
	}
	
	@Override
	public void resume() {
		// Implementable
	}
	
	@Override
	public void dispose() {
		// Implementable
	}
}
