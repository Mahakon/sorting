package ru.mail.polis.sort;

import java.util.ArrayList;

import ru.mail.polis.structures.Numerical;

public class LSD {
    public static Numerical[] sort(Numerical[] array) {
        Numerical max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max.compareTo(array[i])==-1) {
                max = array[i];
            }
        }

        for (int i = 0; i < max.getDigitCount(); i++) {
            countingSort(array, i);
        }

        return array;
    }

    private static Numerical[] countingSort(Numerical[] array, int index) {
        ArrayList<Numerical>[] digitArray = new ArrayList[10];

        for (int i = 0; i < array.length; i++) {
            if (digitArray[array[i].getDigit(index)] == null) {
                digitArray[array[i].getDigit(index)] = new ArrayList<Numerical>();
            }

            digitArray[array[i].getDigit(index)].add(array[i]);
        }

        int counter = 0;
        for (int i = 0; i < digitArray.length; i++) {
            for (int j = 0; digitArray[i] != null && j < digitArray[i].size(); j++) {
                array[counter++] = digitArray[i].get(j);
            }
        }
        return array;
    }

}
