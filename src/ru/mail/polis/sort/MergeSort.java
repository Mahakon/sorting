package ru.mail.polis.sort;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort<Key extends Comparable<? super Key>> {
    private Comparator<? super Key> comparator;

    public MergeSort(){}

    @SuppressWarnings("unchecked")
    public MergeSort(Comparator<? super Key> comparator) {
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

    public Key[] sort(Key[] array) {
        mergeSort(array, 0, array.length-1);
        return array;
    }

    private void mergeSort(Key[] a, int left, int right) {

        if (right <= left)
            return;
        int mid = left + (right - left) / 2;
        mergeSort(a, left, mid);
        mergeSort(a, mid + 1, right);

        Key[] buf = Arrays.copyOf(a, a.length);

        for (int k = left; k <= right; k++)
            buf[k] = a[k];

        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {

            if (i > mid) {
                a[k] = buf[j];
                j++;
            } else if (j > right) {
                a[k] = buf[i];
                i++;
            } else if (greater(buf[j], buf[i])) {
                a[k] = buf[j];
                j++;
            } else {
                a[k] = buf[i];
                i++;
            }
        }
    }
}
