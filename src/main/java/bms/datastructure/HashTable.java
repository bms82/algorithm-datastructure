package bms.datastructure;

public class HashTable {

    class MyHashSet<V> {

        private static class HashEntry<V> {
            V v;

            HashEntry next;

            HashEntry(V v) {
                this.v = v;
                this.next = null;
            }

        }

        private static final int SIZE = 10;
        private final HashEntry[] entries = new HashEntry[SIZE];


        public void add(int key) {
            int hash = getHash(key);
            HashEntry anotherEntry = new HashEntry(key);
            if (entries[hash] == null) {
                entries[hash] = anotherEntry;
            } else {
                HashEntry currentEntry = entries[hash];
                while (currentEntry != null) {
                    currentEntry = currentEntry.next;
                }
                currentEntry.next = anotherEntry;
            }
        }

        public void remove(int key) {
            int hash = getHash(key);
            if (entries[hash] == null) {
                return;
            } else {
                HashEntry currentEntry = entries[hash];
                while (currentEntry != null) {
                    if (currentEntry.next != null && (int) currentEntry.next.v == key) {
                        currentEntry.next = currentEntry.next.next;
                        break;
                    }
                    currentEntry = currentEntry.next;
                }
            }
        }

        public boolean contains(int key) {
            int hash = getHash(key);
            if (entries[hash] == null) {
                return false;
            }

            HashEntry currentEntry = entries[hash];
            while (currentEntry != null) {
                if ((int) currentEntry.v == key)
                    return true;
                currentEntry = currentEntry.next;
            }
            return false;
        }

        public int getHash(int key) {
            return SIZE % key;
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

}
