package leetcode.lru.cache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class LRUCacheWithLinkedHashMapJava implements LRUCacheI {

    private final Map<Integer, Integer> nodes;

    public LRUCacheWithLinkedHashMapJava(int capacity) {
        this.nodes = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    @Override
    public int get(int key) {
        return Objects.requireNonNullElse(this.nodes.get(key), -1);
    }

    @Override
    public void put(int key, int value) {
        this.nodes.put(key, value);
    }

}
