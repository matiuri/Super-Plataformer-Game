package plataformer.utils.assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.Disposable;

public class AssetLoader implements Disposable {
	private AssetManager manager;
	private Map map;
	
	public AssetLoader() {
		manager = new AssetManager();
		map = new Map();
	}
	
	public <T> void load(Class<T> CLASS, Cluster... clusters) {
		for (Cluster c : clusters) {
			manager.load(c.getPath(), CLASS);
		}
		manager.finishLoading();
		for (Cluster c : clusters) {
			map.add(c.key, c.path, manager.get(c.path, CLASS));
		}
	}
	
	public <T> T get(Class<T> CLASS, String key) {
		return map.get(CLASS, key);
	}
	
	public void remove(String... keys) {
		for (String s : keys) {
			manager.unload(map.remove(s));
			map.deleteEntry(s);
		}
	}
	
	@Override
	public void dispose() {
		map.clear();
		manager.dispose();
	}
	
	public static class Cluster {
		private String path, key;
		
		public Cluster(String path, String key) {
			this.path = path;
			this.key = key;
		}
		
		public String getPath() {
			return path;
		}
		
		public String getKey() {
			return key;
		}
	}
}
