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

import org.junit.Test;

import java.util.EmptyStackException;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class QueueInTwoStacksTest {

    @Test
    public void creation() {

        final QueueInTwoStacks queue = new QueueInTwoStacks();

        final LinkedList<Integer> values = new LinkedList<>();
        values.add(3);
        values.add(2);
        values.add(1);
        values.add(0);

        values.iterator().forEachRemaining(queue::add);

        values.iterator().forEachRemaining(value -> {
            assertThat(queue.peek())
                    .isEqualTo(value);
            assertThat(queue.poll())
                    .isEqualTo(value);
        });
    }

    @Test
    public void empty() {

        final QueueInTwoStacks queue = new QueueInTwoStacks();

        assertThatThrownBy(queue::poll)
                .isInstanceOf(EmptyStackException.class);
        assertThatThrownBy(queue::peek)
                .isInstanceOf(EmptyStackException.class);
    }
}