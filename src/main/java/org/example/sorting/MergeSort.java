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
 * Implementation of Merge sort algorithm.
 *
 * @author Paulo Pereira
 */
public class MergeSort {

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

        final int mid = begin + (end - begin) / 2;

        sort(array, begin, mid);
        sort(array, mid + 1, end);
        merge(array, begin, mid, end);
    }

    private static void merge(final int[] array, final int begin, final int mid, final int end) {

        final int subArrayOne = mid - begin + 1;
        final int subArrayTwo = end - mid;

        final int[] firstArray = new int[subArrayOne];
        final int[] secondArray = new int[subArrayTwo];

        System.arraycopy(array, begin, firstArray, 0, subArrayOne);
        System.arraycopy(array, mid + 1, secondArray, 0, subArrayTwo);

        int indexOfFirst = 0;
        int indexOfSecond = 0;
        int indexOfMerged = begin;

        while (indexOfFirst < subArrayOne && indexOfSecond < subArrayTwo) {
            if (firstArray[indexOfFirst] <= secondArray[indexOfSecond]) {
                array[indexOfMerged++] = firstArray[indexOfFirst++];
            } else {
                array[indexOfMerged++] = secondArray[indexOfSecond++];
            }
        }

        while (indexOfFirst < subArrayOne) {
            array[indexOfMerged++] = firstArray[indexOfFirst++];
        }
        while (indexOfSecond < subArrayTwo) {
            array[indexOfMerged++] = secondArray[indexOfSecond++];
        }
    }
}
