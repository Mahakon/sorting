package ru.mail.polis.sort;

import java.util.Comparator;

public class QuickSort1<Key extends Comparable<? super Key>> {
    private Comparator<? super Key> comparator;

    public QuickSort1(){}

    @SuppressWarnings("unchecked")
    public QuickSort1(Comparator<? super Key> comparator) {
        this();
        this.comparator = comparator;
    }

    @SuppressWarnings("unchecked")
    private boolean greater(Key a, Key b) {
        return comparator == null
                ? (a).compareTo(b) > 0
                : comparator.compare(a, b) > 0;
    }

    private void swap(Key[] a, int i, int j) {
        Key x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    private int generateRandomIndex(int arraySize) {
        return (int)Math.floor(Math.random() * arraySize);
    }

    public Key[] sort(Key[] array) {
        quickSort(array, 0, array.length-1);
        return array;
    }

    private void quickSort(Key[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left, r =right;
        Key piv = array[generateRandomIndex(array.length)];
        int numLeftElements = 0;
        int numRightElements = 0;
        while (l <= r) {
            while (greater(array[l], piv)) {
                l++;
                numLeftElements++;
            }

            while (greater(piv, array[r])) {
                r--;
                numRightElements++;
            }

            if (l <= r) {
                swap(array, l++, r--);
            }

        }

        if (numLeftElements >= numRightElements * 8
                || numLeftElements *8  <= numRightElements) {
            insectionSort(array);
            return;
        }
        if (left < r) {
            quickSort(array, left, r);
        }

        if (right > l) {
            quickSort(array, l, right);
        }
    }

    private void insectionSort(Key[] array) {
        for(int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && greater(array[j], array[j-1]); j--) {
                swap(array, j-1, j);
            }
        }
    }
}
