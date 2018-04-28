package com.jovan.utils;

import java.util.UUID;

public class UTest {

    public static void main(String[] args) {
        long ct = System.currentTimeMillis();
        String t = String.valueOf(ct);
        System.out.println(t);
        UUID uuid = UUID.randomUUID();
        String u = (uuid.toString()).replace("-","");
        System.out.println(u);
     }
}
