package ru.mail.polis.sort;

import java.util.ArrayList;

import com.sun.deploy.panel.ITreeNode;

import ru.mail.polis.structures.IntKeyObject;

public class CountingSort {
    @SuppressWarnings("unchecked")
    public static IntKeyObject[] sort(IntKeyObject[] array) {
        int max = array[0].getKey(), min;
        min = max;

        for (int i = 1; i < array.length; i++) {
            if (max < array[i].getKey()) {
                max = array[i].getKey();
            }

            if (min > array[i].getKey()) {
                min = array[i].getKey();
            }
        }

        ArrayList<IntKeyObject>[] buf = new ArrayList[max - min + 1];

        for (int  i = 0; i < array.length; i++) {
            if (buf[array[i].getKey() - min] == null) {
                buf[array[i].getKey() - min] = new ArrayList<IntKeyObject>();
            }

            buf[array[i].getKey() - min].add(array[i]);
        }

        int counter = 0;
        for (int i = 0; i < buf.length; i++) {
            for (int j = 0; j < buf[i].size(); j++) {
                array[counter++] = buf[i].get(j);
            }
        }

        return array;

    }

}
