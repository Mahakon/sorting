package ru.mail.polis.sort;

import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import ru.mail.polis.structures.IntKeyObject;
import ru.mail.polis.structures.IntKeyStringValueObject;
import ru.mail.polis.structures.SimpleInteger;

public class SortUtils {

    private static final Random r = ThreadLocalRandom.current();

    public static void swap(int[] a, int i, int j) {
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    public static void mySwap(Integer[] a, int i, int j) {
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    public static void countingSortSwap(IntKeyObject[] a, int i, int j) {
        IntKeyObject x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    public static int[] generateArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = a.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            SortUtils.swap(a, i, j);
        }
        return a;
    }

    public static Integer[] myGenerateArray(int n) {
        Integer[] a = new Integer[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = a.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            SortUtils.mySwap(a, i, j);
        }
        return a;
    }

    public static IntKeyObject[] countingSortGenerateArray(int n) {
        IntKeyObject[] a = new IntKeyObject[n];
        for (int i = 0; i < a.length; i++) {
            IntKeyStringValueObject cur = new IntKeyStringValueObject(i, "maha" + i);
            a[i] = cur;
        }
        for (int i = a.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            SortUtils.countingSortSwap(a, i, j);
        }
        return a;
    }

    public static SimpleInteger[] LSDGeneratedArray(int n) {
        SimpleInteger[] a = new SimpleInteger[n];
        for (int i = 0; i < a.length; i++) {
            SimpleInteger cur = new SimpleInteger(1000 + (int)Math.floor(Math.random() * 4000));
            a[i] = cur;
        }
        return a;
    }

    public static boolean isArraySorted(int[] a) {
        boolean isSorted = true;
        for (int i = 0; i < a.length - 1 && isSorted; i++) {
            isSorted = a[i] <= a[i + 1];
        }
        return isSorted;
    }

    public static <T extends Comparable<? super T>> boolean isArraySorted(T[] array) {
        boolean isSorted = true;
        for (int i = 0; i < array.length - 1 && isSorted; i++) {
            isSorted = array[i].compareTo(array[i + 1]) <= 0;
        }
        return isSorted;
    }

    public static <T> boolean isArraySorted(T[] array, Comparator<T> comparator) {
        boolean isSorted = true;
        for (int i = 0; i < array.length - 1 && isSorted; i++) {
            isSorted = comparator.compare(array[i], array[i + 1]) <= 0;
        }
        return isSorted;
    }
}
