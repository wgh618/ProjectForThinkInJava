package com.will.collection;

import java.util.*;

/**
 * ClassName:SimpleHashMap
 * Description:简单的散列Map
 * @Author Will Wu
 * @Email willwu618@gmail.com
 * @Date 2017-12-22
 */
public class SimpleHashMap<K,V> extends AbstractMap<K,V> {

    static final int SIZE = 997;

    LinkedList<Node<K,V>>[] buckets = new LinkedList[SIZE];

    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;

        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        LinkedList<Node<K,V>> bucket = buckets[index];
        Node<K,V> pair = new Node<K, V>(key,value);
        boolean found = false;
        ListIterator<Node<K, V>> listIterator = bucket.listIterator();
        while (listIterator.hasNext()) {
            Node<K,V> iPair = listIterator.next();
            if (iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                listIterator.set(iPair);
                found = true;
                break;
            }
        }
        if (!found) {
            buckets[index].add(pair);
        }
        return oldValue;
    }

    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;

        if (buckets[index] == null) {
            return null;
        }

        for (Node<K,V> pair : buckets[index]) {
            return pair.getValue();
        }
        return null;
     }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K,V>> entrySet = new HashSet<>();
        for (LinkedList<Node<K, V>> bucket : buckets) {
            if (bucket == null) {
                continue;
            }
            for (Node<K,V> pair : bucket) {
                entrySet.add(pair);
            }
        }
        return entrySet;
    }

    static class Node<K,V> implements Map.Entry<K,V> {
        final K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final int hashCode() {
            return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (!(o instanceof Node)) {
                return false;
            }
            Node node = (Node) o;
            return (key == null ? node.getKey() == null : key.equals(node.getKey())) &&
                    (value == null ? node.getValue() == null : value.equals(node.getValue()));
        }
    }

    public static void main(String[] args) {
        SimpleHashMap<String,String> map = new SimpleHashMap<>();
        map.put("a","1");
        map.put("b","2");
        map.put("c","3");
        map.put("d","4");
        map.put("e","5");
        map.put("f","6");
        System.out.println(map);
        System.out.println(map.get("d"));
        System.out.println(map.entrySet());
    }
}
