package ru.mail.polis;

import java.util.Arrays;

import ru.mail.polis.sort.BubbleSort;
import ru.mail.polis.sort.CountingSort;
import ru.mail.polis.sort.HeapSort;
import ru.mail.polis.sort.MergeSort;
import ru.mail.polis.sort.QuickSort1;
import ru.mail.polis.sort.QuickSort2;
import ru.mail.polis.structures.IntKeyObject;
import ru.mail.polis.structures.IntKeyStringValueObject;

public class Main {
    public static void main(String[] args) {
        Integer[] a = {0, 4, 5, 1, 6};
        new HeapSort<Integer>(((Integer x, Integer y)
                -> x <= y ? x.equals(y) ? 0 : 1 : -1)).
                sort(a);

        //BubbleSort.sort(a);

        System.out.println(Arrays.toString(a));

        IntKeyStringValueObject a1 = new IntKeyStringValueObject(1, "maha1");
        IntKeyStringValueObject a2 = new IntKeyStringValueObject(2, "maha2");
        IntKeyStringValueObject a3 = new IntKeyStringValueObject(3, "maha3");
        IntKeyObject[] array = {a2, a1, a3};
        CountingSort.sort(array);
        System.out.println(Arrays.toString(array));

    }
}
