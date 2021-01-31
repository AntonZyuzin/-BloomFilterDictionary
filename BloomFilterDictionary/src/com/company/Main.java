package com.company;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        BloomFilter bf = new BloomFilter();
        System.out.println("История посещения");
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Dictionary.map.put("youtube", "200 Byte");
        Dictionary.map.put("wikipedia", null);
        Dictionary.map.put("yandex", null);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println(Dictionary.map);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите запрос:");
        String link = scanner.nextLine();
        bf.filter(link.toLowerCase());

    }
}
