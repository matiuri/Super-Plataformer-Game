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
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class TitleScreen extends ScreenAdapter {
	private Stage stage;
	private Logo logo;
	private Platforms plat;
	private Music base, top;
	private Label info;
	private BitmapFont font;
	
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
		
		font = new BitmapFont();
		info = new Label("Nothing", new LabelStyle(font, Color.BLUE));
		info.setX(150);
		stage.addActor(info);
		
		plat.addListener(new TitleListener(plat));
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
		
		String loaded = "\\Loaded: ";
		for (int i = 0; i < assetLoader.getAllKeys().length; i++) {
			loaded += assetLoader.getAllKeys()[i] + "\\";
		}
		info.setText("Super Plataformer Game: Debug Info Tool\\\\FPS: " + Integer.toString(Gdx.graphics.getFramesPerSecond()) + "\\" + loaded);
		info.setWidth(info.getTextBounds().width);
		if (info.getRight() > (stage.getViewport().getWorldWidth() - 150)) {
			info.setX(info.getX() - 1f);
		} else if (info.getRight() > 0) {
			info.setX(info.getX() - 10);
		} else {
			info.setX(150);
		}
		
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
		font.dispose();
		assetLoader.remove("Base", "Top");
		stage.dispose();
	}
}
