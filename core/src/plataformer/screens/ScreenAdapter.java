package plataformer.screens;

import plataformer.Plataformer;

import com.badlogic.gdx.Screen;

/**
 * Clase abstracta que define una pantalla base
 * 
 * @author Matías
 *
 */
public abstract class ScreenAdapter implements Screen {
	
	// Variable Protegida Plataformer: Juego
	protected Plataformer game;
	
	/**
	 * Crea una {@link ScreenAdapter}
	 * 
	 * @param game
	 *            {@link Plataformer}
	 */
	public ScreenAdapter(Plataformer game) {
		this.game = game;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#show()
	 */
	@Override
	public abstract void show();
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#render(float)
	 */
	@Override
	public abstract void render(float delta);
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#resize(int, int)
	 */
	@Override
	public abstract void resize(int width, int height);
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#hide()
	 */
	@Override
	public abstract void hide();
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#pause()
	 */
	@Override
	public void pause() {
		// Implementable
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#resume()
	 */
	@Override
	public void resume() {
		// Implementable
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Screen#dispose()
	 */
	@Override
	public void dispose() {
		// Implementable
	}
}
