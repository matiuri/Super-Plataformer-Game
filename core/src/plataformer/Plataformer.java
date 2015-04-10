package plataformer;

import plataformer.screens.ScreenAdapter;
import plataformer.screens.TitleScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Plataformer extends Game {
	public static final String TITLE = "Super Plataformer Game", VERSION = "Alpha 0.0", VENDOR = "Matías Steinberg";
	public static final int FPS_F = 0, FPS_B = -1;
	public static int width, height;
	public static final boolean RESIZABLE = true, FULLSCREEN = true, VSYNC = true, DEBUG = false;
	
	public ScreenAdapter title;
	
	@Override
	public void create() {
		title = new TitleScreen(this);
		setScreen(title);
	}
	
	@Override
	public void render() {
		super.render();
		if (Gdx.input.isKeyJustPressed(Keys.ESCAPE))
			setScreen(title);
	}
	
	public static void clearScreen() {
		Gdx.graphics.getGL20().glClearColor(0, 0, 0, 1);
		Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	
	public static void clearScreen(float r, float g, float b, float a) {
		Gdx.graphics.getGL20().glClearColor(r, g, b, a);
		Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	
	public static void clearScreen(Color color) {
		Gdx.graphics.getGL20().glClearColor(color.r, color.g, color.b, 1);
		Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	
	public static void setDefaultColor(Batch batch) {
		batch.setColor(1, 1, 1, 1);
	}
}
