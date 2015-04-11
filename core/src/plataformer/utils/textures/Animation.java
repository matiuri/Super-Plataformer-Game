package plataformer.utils.textures;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Clase que define una animación de {@link TextureRegion}
 * 
 * @author Matías
 *
 */
public class Animation {
	
	// Variable Privada TextureRegion: Animación
	private TextureRegion[] animation;
	// Variable Privada int: Posición actual
	private int actualPos = 0;
	// Variable Privada float: Velocidad, Contador
	private float speed, counter = 0;
	// Variable Privada boolean: Repetición
	private boolean loop;
	
	/**
	 * Crea una {@link Animation}
	 * 
	 * @param tex
	 *            Array unidimensional de {@link Texture}
	 * @param speed
	 *            Velocidad de animación como float
	 * @param loop
	 *            Si se debe repetir o no como boolean
	 */
	public Animation(Texture[] tex, float speed, boolean loop) {
		animation = new TextureRegion[tex.length];
		for (int i = 0; i < tex.length; i++) {
			animation[i] = new TextureRegion(tex[i]);
		}
		
		this.speed = speed;
		this.loop = loop;
	}
	
	/**
	 * Crea una {@link Animation}
	 * 
	 * @param tex
	 *            Array bidimensional de {@link Texture}
	 * @param speed
	 *            Velocidad de animación como float
	 * @param loop
	 *            Si se debe repetir o no como boolean
	 */
	public Animation(Texture[][] tex, float speed, boolean loop) {
		animation = new TextureRegion[tex.length * tex[0].length];
		int counter = 0;
		for (int i = 0; i < tex.length; i++) {
			for (int j = 0; j < tex[i].length; j++) {
				animation[counter] = new TextureRegion(tex[i][j]);
			}
		}
		
		this.speed = speed;
		this.loop = loop;
	}
	
	/**
	 * Crea una {@link Animation}
	 * 
	 * @param speed
	 *            Velocidad de animación como float
	 * @param loop
	 *            Si se debe repetir o no como boolean
	 * @param tex
	 *            Cantidad indeterminada de {@link Texture}, separadas por coma
	 */
	public Animation(float speed, boolean loop, Texture... tex) {
		this(tex, speed, loop);
	}
	
	/**
	 * Crea una {@link Animation}
	 * 
	 * @param reg
	 *            Array unidimensional de {@link TextureRegion}
	 * @param speed
	 *            Velocidad de animación como float
	 * @param loop
	 *            Si se debe repetir o no como boolean
	 */
	public Animation(TextureRegion[] reg, float speed, boolean loop) {
		animation = new TextureRegion[reg.length];
		for (int i = 0; i < reg.length; i++) {
			animation[i] = reg[i];
		}
		
		this.speed = speed;
		this.loop = loop;
	}
	
	/**
	 * Crea una {@link Animation}
	 * 
	 * @param reg
	 *            Array bidimensional de {@link TextureRegion}
	 * @param speed
	 *            Velocidad de animación como float
	 * @param loop
	 *            Si se debe repetir o no como boolean
	 */
	public Animation(TextureRegion[][] reg, float speed, boolean loop) {
		animation = new TextureRegion[reg.length * reg[0].length];
		int counter = 0;
		for (int i = 0; i < reg.length; i++) {
			for (int j = 0; j < reg[i].length; j++) {
				animation[counter] = reg[i][j];
			}
		}
		
		this.speed = speed;
		this.loop = loop;
	}
	
	/**
	 * Crea una {@link Animation}
	 * 
	 * @param speed
	 *            Velocidad de animación como float
	 * @param loop
	 *            Si se debe repetir o no como boolean
	 * @param reg
	 *            Cantidad indeterminada de {@link TextureRegion}, separadas por coma
	 */
	public Animation(float speed, boolean loop, TextureRegion... reg) {
		this(reg, speed, loop);
	}
	
	/**
	 * Determina la velocidad de la {@link Animation}
	 * 
	 * @param speed
	 *            Nueva velocidad
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	/**
	 * Actualiza el cuadro de la animación
	 * 
	 * @param delta
	 *            El tiempo desde el último fotograma
	 */
	public void updateFrame(float delta) {
		counter += delta;
		if (counter >= speed) {
			counter = 0;
			if (actualPos == animation.length - 1 && !loop)
				return;
			if ((++actualPos) == animation.length && loop)
				actualPos = 0;
		}
	}
	
	/**
	 * @return El fotograma actual como {@link TextureRegion}
	 */
	public TextureRegion getActualFrame() {
		return animation[actualPos];
	}
	
	/**
	 * Actualiza el fotograma y lo obtiene
	 * 
	 * @param delta
	 *            El tiempo desde el último fotograma
	 * @return El fotograma actualizado
	 */
	public TextureRegion GetUpdatedFrame(float delta) {
		updateFrame(delta);
		return getActualFrame();
	}
}
