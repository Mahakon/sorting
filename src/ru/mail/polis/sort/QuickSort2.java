package ru.mail.polis.sort;

import java.util.Arrays;
import java.util.Comparator;

public class QuickSort2<Key extends Comparable<? super Key>> {
    private Comparator<? super Key> comparator;

    public QuickSort2(){}

    @SuppressWarnings("unchecked")
    public QuickSort2(Comparator<? super Key> comparator) {
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
        while (l <= r) {
            while (greater(array[l], piv)) {
                l++;
            }

            while (greater(piv, array[r])) {
                r--;
            }

            if (l <= r) {
                swap(array, l++, r--);
            }

        }

        if (left < r) {
            quickSort(array, left, r);
        }

        if (right > l) {
            quickSort(array, l, right);
        }
    }

}
