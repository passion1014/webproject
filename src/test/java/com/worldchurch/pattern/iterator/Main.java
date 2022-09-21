package com.worldchurch.pattern.iterator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();

        map.put(1, "AAA");
        map.put(2, "BBB");
        map.put(3, "CCC");
        map.put(4, "DDD");
        map.put(5, "EEE");

        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            System.out.println(map.get(it.next()));
        }

    }
}
