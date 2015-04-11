package plataformer.utils.assets;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.utils.Disposable;

/**
 * Clase que almacena el mapa de Ruta, Llave y Objeto de ese objeto.
 * <p>
 * Relacionada con {@link AssetLoader}
 * 
 * @author Matías
 *
 */
public class Map {
	
	// Variable Privada ArrayList<MapEntry>: Entradas en el mapa
	private ArrayList<MapEntry> entry;
	
	/**
	 * Crea un mapa
	 */
	public Map() {
		entry = new ArrayList<>();
	}
	
	/**
	 * Añade un {@link Object}
	 * 
	 * @param key
	 *            Llave del objeto como String
	 * @param path
	 *            Ruta del objeto como String
	 * @param o
	 *            El objeto como Object
	 */
	public void add(String key, String path, Object o) {
		for (MapEntry m : entry) {
			if (key.equals(m.key))
				throw new IllegalStateException("The key " + key + " already exists");
		}
		entry.add(new MapEntry(key, path, o));
	}
	
	/**
	 * Obtiene un objeto
	 * 
	 * @param CLASS
	 *            {@link Class} de la cual es instancia ese objeto
	 * @param key
	 *            Llave del objeto como String
	 * @return El Objeto como variable del tipo de la {@link Class} parámetro
	 */
	public <T> T get(Class<T> CLASS, String key) {
		for (MapEntry m : entry) {
			if (key.equals(m.key)) {
				try {
					T obj = CLASS.cast(m.o);
					return obj;
				} catch (ClassCastException e) {
					throw new IllegalStateException("The field " + key + " couldn't be gotten", e);
				}
			}
		}
		throw new IllegalStateException("The key " + key + " doesn't exist");
	}
	
	/**
	 * Devuelve la ruta del objeto a eliminar
	 * 
	 * @param key
	 *            Llave del objeto como String
	 * @return La ruta del objeto como String
	 */
	public String remove(String key) {
		for (MapEntry m : entry) {
			if (key.equals(m.key)) {
				if (m.o instanceof Disposable) {
					((Disposable) m.o).dispose();
				}
				return m.path;
			}
		}
		throw new IllegalStateException("The key " + key + " doesn't exist");
	}
	
	/**
	 * Elimina un objeto del mapa de objetos
	 * 
	 * @param key
	 *            La llave del objeto
	 */
	public void deleteEntry(String key) {
		Iterator<MapEntry> iter = entry.iterator();
		while (iter.hasNext()) {
			MapEntry temp = iter.next();
			if (temp.key.equals(key)) {
				iter.remove();
				return;
			}
		}
	}
	
	/**
	 * Elimina TODOS los objetos almacenados en el mapa
	 */
	public void clear() {
		entry.clear();
	}
	
	/**
	 * Clase privada que representa una entrada en el {@link Map}
	 * 
	 * @author Matías
	 *
	 */
	private class MapEntry {
		
		// Variable Privada String: Llave
		private String key;
		// Variable Privada String: Ruta
		private String path;
		// Variable Privada Object: Objeto
		private Object o;
		
		/**
		 * Crea una entrada de mapa
		 * 
		 * @param key
		 *            La llave del objeto como String
		 * @param path
		 *            La ruta del objeto como String
		 * @param o
		 *            El Objeto como Object
		 */
		private MapEntry(String key, String path, Object o) {
			this.key = key;
			this.path = path;
			this.o = o;
		}
	}
}
