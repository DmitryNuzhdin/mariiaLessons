package leetcode.designHashMap;

public class OneMoreHashMap {
    MapElement[] quasiHashMap;
    final int rowSizeOfMap = 10000;

    public OneMoreHashMap() {
        this.quasiHashMap = new MapElement[rowSizeOfMap];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = this.getIndex(key);
        if (quasiHashMap[index] == null) {
            quasiHashMap[index] = new MapElement(key,value);
        } else {
            MapElement currentElement = quasiHashMap[index];
            while (currentElement.nextElem != null && currentElement.key != key) {
                currentElement = currentElement.nextElem;
            }
            if (currentElement.key != key) {
                currentElement.nextElem = new MapElement(key,value);
            } else {
                currentElement.value = value;
            }
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = this.getIndex(key);
        if (quasiHashMap[index] == null) {
            return -1;
        } else {
            MapElement currentElement = quasiHashMap[index];
            int searchResult = -1;
            while (currentElement != null && currentElement.key != key) {
                currentElement = currentElement.nextElem;
            }
            if (currentElement != null && currentElement.key == key) {
                searchResult = currentElement.value;
            }
            return searchResult;
        }
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = this.getIndex(key);
        MapElement currentElement = quasiHashMap[index];
        MapElement previousElement = null;
        while (currentElement != null) {
            if (currentElement.key != key) {
                previousElement = currentElement;
                currentElement = currentElement.nextElem;
            } else {
                if (previousElement != null) {
                    previousElement.nextElem = currentElement.nextElem;
                } else {
                    quasiHashMap[index] = currentElement.nextElem;
                }
                break;
            }
        }
    }

    public int getIndex(int key) {
        return key % rowSizeOfMap;
    }

    public class MapElement {
        int key;
        int value;
        MapElement nextElem;
        public MapElement(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
