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
 * Implementation of Bubble sort algorithm.
 *
 * @author Paulo Pereira
 */
public class BubbleSort {

    /**
     * Sorts an array of integers by ascending order.
     *
     * @param array Array to be sorted.
     */
    public static void sort(final int[] array) {

        boolean swapped;

        do {
            swapped = false;

            for (int i = 0; i < array.length - 1; i++) {

                if (array[i] > array[i + 1]) {
                    final int temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                    swapped = true;
                }
            }

        } while (swapped);
    }
}
