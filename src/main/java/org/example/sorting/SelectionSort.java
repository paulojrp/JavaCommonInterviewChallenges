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
 * Implementation of Selection sort algorithm.
 *
 * @author Paulo Pereira
 */
public class SelectionSort {

    /**
     * Sorts an array of integers by ascending order.
     *
     * @param array Array to be sorted.
     */
    public static void sort(final int[] array) {

        for (int i = 0; i < array.length; i++) {
            int minValue = array[i];
            int indexMin = i;

            for (int y = i + 1; y < array.length; y++) {

                if (array[y] < minValue) {
                    minValue = array[y];
                    indexMin = y;
                }
            }

            array[indexMin] = array[i];
            array[i] = minValue;
        }
    }
}
