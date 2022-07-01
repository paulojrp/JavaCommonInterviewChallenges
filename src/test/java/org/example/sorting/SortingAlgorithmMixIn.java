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

import org.junit.Test;

import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class SortingAlgorithmMixIn {

    abstract Consumer<int[]> sortingFunction();

    @Test
    public void sortRandom() {
        final int[] array = new int[]{1, 3, 5, 7, 9, 2, 4, 6, 8, 0};
        final int[] expected = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        sortingFunction().accept(array);

        assertThat(array)
                .hasSameSizeAs(expected)
                .containsExactly(expected);
    }

    @Test
    public void sortSorted() {
        final int[] array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        final int[] expected = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        sortingFunction().accept(array);

        assertThat(array)
                .hasSameSizeAs(expected)
                .containsExactly(expected);
    }

    @Test
    public void sortReverse() {
        final int[] array = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        final int[] expected = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        sortingFunction().accept(array);

        assertThat(array)
                .hasSameSizeAs(expected)
                .containsExactly(expected);
    }

    @Test
    public void sortRepeated() {
        final int[] array = new int[]{1, 2, 1, 2, 1, 2};
        final int[] expected = new int[]{1, 1, 1, 2, 2, 2};

        sortingFunction().accept(array);

        assertThat(array)
                .hasSameSizeAs(expected)
                .containsExactly(expected);
    }

    @Test
    public void sortOneElement() {
        final int[] array = new int[]{0};
        final int[] expected = new int[]{0};

        sortingFunction().accept(array);

        assertThat(array)
                .hasSameSizeAs(expected)
                .containsExactly(expected);
    }

    @Test
    public void sortZeroElement() {
        final int[] array = new int[]{};
        final int[] expected = new int[]{};

        sortingFunction().accept(array);

        assertThat(array)
                .hasSameSizeAs(expected)
                .containsExactly(expected);
    }
}
