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

import java.util.Stack;

/**
 * Simple implementation of queue that uses two stacks to implement the behaviour of a queue.
 *
 * @author Paulo Pereira
 */
public class QueueInTwoStacks {

    private final Stack<Integer> oldElements;
    private final Stack<Integer> newElements;

    QueueInTwoStacks() {
        oldElements = new Stack<>();
        newElements = new Stack<>();
    }

    public boolean add(final int integer) {
        return newElements.add(integer);
    }

    public int poll() {

        commitNewElements();
        return oldElements.pop();
    }

    public int peek() {

        commitNewElements();
        return oldElements.peek();
    }

    private void commitNewElements() {

        while(!newElements.isEmpty()) {
            oldElements.push(newElements.pop());
        }
    }
}
