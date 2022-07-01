/*
 * Copyright "2022" Demo
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.example.sorting;

/**
 * Implementation of Quick sort algorithm.
 *
 * @author Paulo Pereira
 */
public class QuickSort {

    /**
     * Sorts an array of integers by ascending order.
     *
     * @param array Array to be sorted.
     */
    public static void sort(final int[] array) {

        sort(array, 0, array.length - 1);
    }

    private static void sort(final int[] array, final int begin, final int end) {

        if (begin >= end) {
            return;
        }

        final int pivot = partition(array, begin, end);
        sort(array, begin, pivot - 1);
        sort(array, pivot + 1, end);
    }

    private static int partition(final int[] array, final int begin, final int end) {

        int pivot = array[end];
        int i = begin;

        for (int j = begin; j < end; j++) {
            if (array[j] < pivot) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, end);

        return i;
    }

    private static void swap(int[] array, int i, int j) {
        final int temp = array[i];
        array[i] = temp;
        array[i] = array[j];
        array[j] = temp;
    }
}
