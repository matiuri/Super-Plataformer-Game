package plataformer.input.title;

import plataformer.utils.actors.title.Button;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class TitleListener<T extends Actor & Button> extends ClickListener {
	private T actor;
	private boolean clicked;
	
	public TitleListener(T actor) {
		this.actor = actor;
	}
	
	public TitleListener(int button, T actor) {
		super(button);
		this.actor = actor;
	}
	
	@Override
	public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
		if (button == this.getButton()) {
			clicked = true;
			actor.setPressed(true);
			return true;
		}
		return false;
	}
	
	@Override
	public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
		if (actor.isPressed()) {
			actor.setPressed(false);
			actor.setChecked(true);
		}
		clicked = false;
	}
	
	@Override
	public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
		actor.setPlay(true);
		if (clicked)
			actor.setPressed(true);
	}
	
	@Override
	public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
		actor.setPlay(false);
		if (clicked)
			actor.setPressed(false);
	}
}
