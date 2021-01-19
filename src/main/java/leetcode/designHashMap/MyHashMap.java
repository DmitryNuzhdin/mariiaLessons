package leetcode.designHashMap;

import java.util.Arrays;

class MyHashMap {
    int[] quasiHashMap;
    /** Initialize your data structure here. */
    public MyHashMap() {
        this.quasiHashMap = new int[1000001];
        Arrays.fill(this.quasiHashMap, -1);
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        this.quasiHashMap[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return this.quasiHashMap[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        this.quasiHashMap[key] = -1;
    }
}

