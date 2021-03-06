package plataformer;

import plataformer.screens.ScreenAdapter;
import plataformer.screens.TitleScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;

/**
 * Clase principal
 * <p>
 * Coordina el comportamiento general del juego.
 * 
 * @author Matías
 *
 */
public class Plataformer extends Game {
	
	// Constante Estática String: Título, Versión, Autor
	public static final String TITLE = "Super Plataformer Game", VERSION = "Alpha 0.0", VENDOR = "Matías Steinberg";
	// Constante Estática int: FPS ventana activa, FPS ventana inactiva
	public static final int FPS_F = 0, FPS_B = -1;
	// Variable Estática int: Ancho, Alto
	public static int width, height;
	// Constante Estática boolean: Redimensionable, Pantalla completa, Sincronización vertical
	public static final boolean RESIZABLE = true, FULLSCREEN = true, VSYNC = true;
	
	// Variable Pantallas: Título
	public ScreenAdapter title;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.ApplicationListener#create()
	 */
	@Override
	public void create() {
		title = new TitleScreen(this);
		setScreen(title);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Game#render()
	 */
	@Override
	public void render() {
		super.render();
		if (Gdx.input.isKeyJustPressed(Keys.ESCAPE))
			setScreen(title);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.Game#dispose()
	 */
	@Override
	public void dispose() {
		title.dispose();
	}
	
	/**
	 * Limpia la pantalla con color negro.
	 */
	public static void clearScreen() {
		Gdx.graphics.getGL20().glClearColor(0, 0, 0, 1);
		Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	
	/**
	 * Limpia la pantalla con el color especificado
	 * 
	 * @param r
	 *            rojos
	 * @param g
	 *            verdes
	 * @param b
	 *            azules
	 * @param a
	 *            transparencia
	 */
	public static void clearScreen(float r, float g, float b, float a) {
		Gdx.graphics.getGL20().glClearColor(r, g, b, a);
		Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	
	/**
	 * * Limpia la pantalla con el color especificado
	 * 
	 * @param color
	 *            {@link Color}
	 */
	public static void clearScreen(Color color) {
		Gdx.graphics.getGL20().glClearColor(color.r, color.g, color.b, 1);
		Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	
	/**
	 * Devuelve el color de un {@link Batch} a blanco
	 * 
	 * @param batch
	 *            {@link Batch}
	 */
	public static void setDefaultColor(Batch batch) {
		batch.setColor(1, 1, 1, 1);
	}
}
