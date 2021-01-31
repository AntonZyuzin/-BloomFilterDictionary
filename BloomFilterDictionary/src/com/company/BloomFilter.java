package com.company;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;

public class BloomFilter {
    private static int m = 10240;   //длинна байтового массива
    private static int k = 2;        //число хеш-функций

    public void filter(String link) throws NoSuchAlgorithmException {
        Dictionary dict = new Dictionary();
        int[] ha1 = hashArray(link);
        byte[] ba1 = byteArray();
        for (int value : ha1) {
            ba1[value] = 1;
        }
        String[] keys = dict.dictKeys();
        for (String k : keys) {
            int[] ha2 = hashArray(k);
            byte[] ba2 = byteArray();
            for (int value : ha2) {
                ba2[value] = 1;
            }
            if (comparison(ba1, ba2)) {
                dict.add(link, str2byte(link) + " Byte");
                break;
            } else {
                dict.add(link, null);
            }
        }
        System.out.println(dict.map);
    }

    public int[] hashArray(String link) throws NoSuchAlgorithmException {
        ArrayList<HashFunction> _hashFuncs = new ArrayList<>();
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        SHA256 h1 = new SHA256();
        _hashFuncs.add(h1);
        MD5 h2 = new MD5();
        _hashFuncs.add(h2);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String[] strHashArray = new String[k];
        for (int i = 0; i < strHashArray.length; i++) {
            strHashArray[i] = _hashFuncs.get(i).hash(link);
        }
        int[] intHashArray = new int[2];
        for (int i = 0; i < intHashArray.length; i++) {
            intHashArray[i] = str2byte(strHashArray[i]);
        }
        return intHashArray;
    }

    public int str2byte(String str) {
        byte[] byteArray = str.getBytes();
        int sum = 0;
        for (byte num : byteArray) {
            sum += Math.abs(num);
        }
        return sum;
    }

    public byte[] byteArray() {
        byte[] barray1 = new byte[m];
        for (byte i : barray1) {
            i = 0;
        }
        return barray1;
    }

    public static boolean comparison(byte[] ba1, byte[] ba2) {
        return Arrays.equals(ba1, ba2);
    }
}
