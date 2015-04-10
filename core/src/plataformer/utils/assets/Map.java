package plataformer.utils.assets;

import java.util.ArrayList;

import com.badlogic.gdx.utils.Disposable;

public class Map {
	private ArrayList<MapEntry> entry;
	
	public Map() {
		entry = new ArrayList<>();
	}
	
	public void add(String key, String path, Object o) {
		for (MapEntry m : entry) {
			if (key.equals(m.key))
				throw new IllegalStateException("The key " + key + " already exists");
		}
		entry.add(new MapEntry(key, path, o));
	}
	
	public <T> T get(Class<T> CLASS, String key) {
		for (MapEntry m : entry) {
			if (key.equals(m.key)) {
				try {
					T obj;
					obj = CLASS.cast(m.o);
					return obj;
				} catch (ClassCastException e) {
					throw new IllegalStateException("The field " + key + " couldn't be gotten", e);
				}
			}
		}
		throw new IllegalStateException("The key " + key + " doesn't exist");
	}
	
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
	
	public void clear() {
		entry.clear();
	}
	
	private class MapEntry {
		private String key;
		private String path;
		private Object o;
		
		private MapEntry(String key, String path, Object o) {
			this.key = key;
			this.path = path;
			this.o = o;
		}
	}
}
