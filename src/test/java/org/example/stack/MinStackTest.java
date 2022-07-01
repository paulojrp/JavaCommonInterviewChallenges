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

package org.example.stack;

import org.example.graph.DetectCycleInList;
import org.junit.Test;

import java.util.EmptyStackException;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MinStackTest {

    @Test
    public void creation() {

        final MinStack minStack = new MinStack();

        final LinkedList<Integer> values = new LinkedList<>();
        values.add(3);
        values.add(2);
        values.add(1);
        values.add(0);

        values.iterator().forEachRemaining(minStack::push);

        values.descendingIterator().forEachRemaining(value -> {
            assertThat(minStack.min())
                    .isEqualTo(value);
            assertThat(minStack.pop())
                    .isEqualTo(value);
        });
    }

    @Test
    public void reverse() {

        final MinStack minStack = new MinStack();

        final LinkedList<Integer> values = new LinkedList<>();
        final int globalMin = 0;
        values.add(globalMin);
        values.add(1);
        values.add(2);
        values.add(3);

        values.iterator().forEachRemaining(minStack::push);

        values.descendingIterator().forEachRemaining(value -> {
            assertThat(minStack.min())
                    .isEqualTo(globalMin);
            assertThat(minStack.pop())
                    .isEqualTo(value);
        });
    }

    @Test
    public void empty() {

        final MinStack minStack = new MinStack();

        assertThatThrownBy(minStack::min)
                .isInstanceOf(EmptyStackException.class);
        assertThatThrownBy(minStack::peek)
                .isInstanceOf(EmptyStackException.class);
        assertThatThrownBy(minStack::pop)
                .isInstanceOf(EmptyStackException.class);
    }
}
