package no146;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
    /*
     * 另一种方法继承linkedhashmap类
     */
    HashMap<Integer, Integer> m;
    LinkedList<Integer> lru;
    int capacity;
    int size;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        m = new HashMap<Integer, Integer>();
        lru = new LinkedList<Integer>();
    }

    public int get(int key) {
        if(m.containsKey(key)) {
          //移动到lru顶端
            lru.remove(lru.indexOf(key));
            lru.addFirst(key);
            return m.get(key);
        }else {return -1;}
    }

    public void put(int key, int value) {
        //key相同时不增加size
        if(m.containsKey(key)||size<capacity) {
            if (m.containsKey(key)){
                lru.remove(lru.indexOf(key));
                lru.addFirst(key);
                m.put(key,value);
            }else {
                m.put(key, value);
                lru.addFirst(key);
                size++;
            }
        }else if(size==capacity){
            int temp = lru.removeLast();
            m.remove(temp);
            m.put(key, value);
            lru.addFirst(key);
        }
    }
}
