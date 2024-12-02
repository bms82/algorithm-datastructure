package bms.datastructure;

public class CustomHashMap<K, V> {

    private static final int SIZE = 10;

    private static class HashEntry<K, V> {
        K key;
        V value;

        HashEntry<K,V> next;

        HashEntry(K k, V v) {
            this.key = k;
            this.value = v;
            this.next = null;
        }
    }

    private final HashEntry[] entries = new HashEntry[SIZE];

    public void put(K key, V value) {

        int hash = getHash(key);

        final HashEntry hashEntry = new HashEntry(key, value);

        if (entries[hash] == null) {
            entries[hash] = hashEntry;
        } else {
            HashEntry currentEntry = entries[hash];
            while (currentEntry.next != null) {
                currentEntry = currentEntry.next;
            }
            currentEntry.next = hashEntry;
        }
    }

    public V get(K key) {
        int hash = getHash(key);
        if (entries[hash] == null) {
            return null;
        } else {
            HashEntry currentEntry = entries[hash];
            while (currentEntry.next != null) {
                if (currentEntry.key == key)
                    return (V) currentEntry.value;
                currentEntry = currentEntry.next;
            }
            return null;
        }
    }

    private int getHash(K key) {
        return Math.abs(key.hashCode() % SIZE);
    }

}
