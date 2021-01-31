package com.company;

import java.util.HashMap;

public class Dictionary {
    public static final HashMap<String, String> map = new HashMap<>();

    public String[] dictKeys() {
        String[] keys = map.keySet().toArray(new String[0]);
        for (int i = 0; i < keys.length; i++) {
            keys[i] = keys[i].toLowerCase();
        }
        return keys;
    }

    public static void add(String link, String cache) {
        map.put(link, cache);
    }


}
