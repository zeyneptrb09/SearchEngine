import java.util.Iterator;

public interface DictionaryInterface<K,V,L> {
	public V addprobe(K key, V value,L array);
	public V remove(K key);
	public V getValue(K key);
	public boolean contains(K key);
	public Iterator<K> getKeyIterator();
	public Iterator<V> getValueIterator();
	public Iterator<L> getArrayIterator();
	public boolean isEmpty();
	public int getSize();
	public void clear();
}
