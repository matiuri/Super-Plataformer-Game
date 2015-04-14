package plataformer.input.title;

import plataformer.utils.actors.title.Button;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class TitleListener extends ClickListener {
	private Button actor;
	private boolean clicked;
	
	public TitleListener(Button actor) {
		this.actor = actor;
	}
	
	public TitleListener(int button, Button actor) {
		super(button);
		this.actor = actor;
	}
	
	// TODO: revisar que las sentencias sean correctas
	
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
