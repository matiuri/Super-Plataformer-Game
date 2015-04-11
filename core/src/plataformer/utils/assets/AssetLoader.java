package plataformer.utils.assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.Disposable;

/**
 * Clase que carga los recursos externos
 * 
 * @author Matías
 *
 */
public class AssetLoader implements Disposable {
	
	// Variable Privada AssetManager: Gestor de recursos
	private AssetManager manager;
	// Variable Privada Map: Mapa de recursos
	private Map map;
	
	/**
	 * Crea un {@link AssetLoader}
	 */
	public AssetLoader() {
		manager = new AssetManager();
		map = new Map();
	}
	
	/**
	 * Carga uno o varios recursos en memoria
	 * 
	 * @param CLASS
	 *            {@link Class} a la que pertenece/n el/los recurso/s
	 * @param clusters
	 *            Una cantidad indefinida de {@link Cluster}
	 */
	public <T> void load(Class<T> CLASS, Cluster... clusters) {
		for (Cluster c : clusters) {
			manager.load(c.getPath(), CLASS);
		}
		manager.finishLoading();
		for (Cluster c : clusters) {
			map.add(c.key, c.path, manager.get(c.path, CLASS));
		}
	}
	
	/**
	 * Recupera un recurso
	 * 
	 * @param CLASS
	 *            {@link Class} a la que pertenece el recurso
	 * @param key
	 *            Llave del recurso como String
	 * @return El recurso como variable del tipo de la {@link Class} parámetro.
	 */
	public <T> T get(Class<T> CLASS, String key) {
		return map.get(CLASS, key);
	}
	
	/**
	 * Elimina uno o varios recursos
	 * 
	 * @param keys
	 *            Cantidad indefinida de llaves de recurso como String
	 */
	public void remove(String... keys) {
		for (String s : keys) {
			manager.unload(map.remove(s));
			map.deleteEntry(s);
		}
	}
	
	/**
	 * Vacía por completo el {@link AssetLoader}
	 */
	public void clear() {
		map.clear();
		manager.clear();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.badlogic.gdx.utils.Disposable#dispose()
	 */
	@Override
	public void dispose() {
		map.clear();
		manager.dispose();
	}
	
	/**
	 * Clase estática que representa la ruta de un recurso y su llave
	 * 
	 * @author Matías
	 *
	 */
	public static class Cluster {
		
		// Variable Privada String: Ruta, Llave
		private String path, key;
		
		/**
		 * Crea un {@link Cluster}
		 * 
		 * @param path
		 *            La ruta del recurso como String
		 * @param key
		 *            La llave del recurso como String
		 */
		public Cluster(String path, String key) {
			this.path = path;
			this.key = key;
		}
		
		/**
		 * @return La ruta del recurso
		 */
		public String getPath() {
			return path;
		}
		
		/**
		 * @return La llave del recurso
		 */
		public String getKey() {
			return key;
		}
	}
}
