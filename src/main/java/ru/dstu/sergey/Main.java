package ru.dstu.sergey;


import ru.dstu.sergey.sorts.SortLab;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");
        int[] data = new int[] {3, -2, 10, 2, 1, 30, 24, 12, 20, -32};
        SortLab.insertion(data);
        System.out.println(Arrays.toString(data));
    }
}