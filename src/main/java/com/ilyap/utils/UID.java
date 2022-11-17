package com.ilyap.utils;

public class UID {
    private static int nextId;

    public static int getNextId() {
        return nextId++;
    }

    public static void reset() {
        nextId = 0;
    }
}
