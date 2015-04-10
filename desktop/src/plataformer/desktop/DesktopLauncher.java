package plataformer.desktop;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import plataformer.Plataformer;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main(String[] arg) {
		init();
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = Plataformer.TITLE + " " + Plataformer.VERSION;
		config.width = Plataformer.width;
		config.height = Plataformer.height;
		config.resizable = Plataformer.RESIZABLE;
		config.fullscreen = Plataformer.FULLSCREEN;
		config.vSyncEnabled = Plataformer.VSYNC;
		config.foregroundFPS = Plataformer.FPS_F;
		config.backgroundFPS = Plataformer.FPS_B;
		new LwjglApplication(new Plataformer(), config);
	}
	
	private static void init() {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		try {
			Plataformer.width = gd.getDisplayMode().getWidth();
			Plataformer.height = gd.getDisplayMode().getHeight();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
