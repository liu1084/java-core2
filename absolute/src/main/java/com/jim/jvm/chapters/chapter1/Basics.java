package com.jim.jvm.chapters.chapter1;

public class Basics {
    public int compare(int n1, int n2) {
        if (n1 > n2) return 1;
        return -1;
    }


    public int [] sortArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return array;
    }
}
