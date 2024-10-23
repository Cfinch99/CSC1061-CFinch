package edu.frcc.csc1061jfa24.MyHashMap;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> implements Map<K, V> {

	private static final int INITIAL_NUM_BUCKETS = 4;
	 	
	private int size = 0;
	private double LOAD_FACTOR_THRESHOLD = 0.5;
	private LinkedList<Entry<K,V>>[] buckets;
	
	protected static class Entry<K,V> implements Map.Entry<K,V> {
		K key;
		V value;
		
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public K getKey() {
			return key;
		}
		
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V value) {
			V oldValue = this.value;
			this.value = value;
			return oldValue;
		}
	}

	public MyHashMap() {
		buckets = new LinkedList[INITIAL_NUM_BUCKETS];
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean containsKey(Object key) {
		if(get(key) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		for (LinkedList<Entry<K,V>> bucket: buckets) {
			if (bucket != null) {
				for(Entry<K,V> entry: bucket) {
					if (entry.value.equals(value)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public V get(Object key) {
		int bucketIndex = Math.abs(key.hashCode()) % buckets.length;
		LinkedList<Entry<K,V>> bucket = buckets[bucketIndex];
		if (bucket == null) {
			return null;
		}
		for (Entry<K,V> entry: bucket) {
			if (entry.key.equals(key)) {
				return entry.value;
			}
		}
		return null;
	}

	@Override
	public V put(K key, V value) {
		int hashCode = key.hashCode();
		int bucketIndex = Math.abs(hashCode) % buckets.length;
		LinkedList<Entry<K,V>> bucket = buckets[bucketIndex];
		
		// Check if bucket has linked list
		if (bucket != null) {
		// Try and find the key
			for (Entry<K,V> entry: bucket) {
				if (entry.key.equals(key)) {
					V oldValue = entry.value;
					entry.value = value;
					return oldValue;
				}
			}
		}
		
		// Assignment: Check if load factor threshold exceeded, rehash the map
		
		
		// Check if bucket has linked list
		if (bucket == null) {
			buckets[bucketIndex] = new LinkedList<>();
		}
		
		buckets[bucketIndex].add(new Entry<K,V>(key, value));
		size++;
 		return null;
	}

	@Override
	public V remove(Object key) {
		int bucketIndex = Math.abs(key.hashCode()) % buckets.length;
		LinkedList<Entry<K,V>> bucket = buckets[bucketIndex];
		if (bucket != null) {
			// Try and find the key
			for (Entry<K,V> entry: bucket) {
				if (entry.key.equals(key)) {
					V oldValue = entry.value;
					bucket.remove(entry);
					size--;
					return oldValue;
				}
			}			
		}
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		Set<? extends Map.Entry<? extends K, ? extends V>> entries = m.entrySet();
		for(Map.Entry<? extends K, ? extends V> entry: entries) {
			put(entry.getKey(), entry.getValue());
		}	
	}

	@Override
	public void clear() {
		size = 0;
		for (LinkedList<Entry<K,V>> bucket: buckets) {
			bucket = null;
			
			// Alternative
//			if (bucket != null) {
//				bucket.clear();
//			}
		}
		
	}

	@Override
	public Set<K> keySet() {
		Set<K> set = new HashSet<K>();
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] != null) {
				for (Entry<K,V> entry: buckets[i]) {
					set.add(entry.key);
				}
			}
		}
		return set;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		Set<Entry<K,V>> set = new HashSet<>();
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] != null) {
				for (Entry<K,V> entry: buckets[i]) {
					set.add(entry);
				}
			}
		}		
		return null;
	}
}
