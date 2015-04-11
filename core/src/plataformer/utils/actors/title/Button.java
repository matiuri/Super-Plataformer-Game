package plataformer.utils.actors.title;

public interface Button {
	boolean isPressed();
	
	void setPressed(boolean pressed);
	
	boolean shouldPlay();
	
	void setPlay(boolean play);
	
	boolean isChecked();
	
	void setChecked(boolean checked);
}
