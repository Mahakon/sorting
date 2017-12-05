package ru.mail.polis.sort;

import java.util.Comparator;

public class HeapSort<Key extends Comparable<? super Key>> {
    private Comparator<? super Key> comparator;

    public HeapSort(){}

    @SuppressWarnings("unchecked")
    public HeapSort(Comparator<? super Key> comparator) {
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
        heapSort(array);
        return array;
    }

    private void heapSort(Key[] array) {
        buildMaxHeap(array);
        int size = array.length - 1;
        for (int i = 1; i < array.length; i++) {
            swap(array, 0, size);
            size--;
            siftDown(array, 0, size);
        }
    }

    /*@SuppressWarnings("unchecked")
    private void shiftUp() {
        int position = size-1;
        while (greater(position, (position-1) / 2) && position != 0) {
            Key a = elementData[position];
            elementData[position] = elementData[(position - 1) / 2];
            elementData[(position - 1) / 2] = a;
            position = (position - 1) / 2;
        }
    }*/

    @SuppressWarnings("unchecked")
    private void siftDown(Key[] array, int position, int size) {
        int leftChild;
        int rightChild;
        int smallestChild;
        while (true) {
            leftChild = position * 2 + 1;
            rightChild = position * 2 + 2;
            smallestChild = position;

            if (leftChild < size && greater(array[leftChild], array[smallestChild])) {
                smallestChild = leftChild;
            }

            if (rightChild < size && greater(array[rightChild], array[smallestChild])) {
                smallestChild = rightChild;
            }

            if (smallestChild == position) {
                break;
            }

            Key a = array[position];
            array[position] = array[smallestChild];
            array[smallestChild] = a;
            position = smallestChild;

        }
    }

        private void buildMaxHeap(Key[] array) {
            for (int i = array.length / 2 - 1; i >= 0; i--) {
                siftDown(array, i, array.length);
            }
        }



}
