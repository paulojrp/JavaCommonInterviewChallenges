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

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Implementation of stack that can also returns the min value of the values stored in that stack.
 *
 * @author Paulo Pereira
 */
public class MinStack extends Stack<Integer> {

    private final Stack<Integer> minStack;

    public MinStack() {
        this.minStack = new Stack<>();
    }

    @Override
    public Integer push(final Integer item) {

        if (this.minStack.isEmpty() || this.minStack.peek() >= item) {
            this.minStack.push(item);
        }
        return super.push(item);
    }

    @Override
    public Integer pop() {

        final Integer pop = super.pop();
        if (this.minStack.peek().equals(pop)) {
            this.minStack.pop();
        }

        return pop;
    }

    public Integer min() {
        return this.minStack.peek();
    }
}
