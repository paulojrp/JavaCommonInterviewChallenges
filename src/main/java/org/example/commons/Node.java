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

package org.example.commons;

/**
 * Wrappers for a given value. This wrapper represents a (graph) node.
 *
 * @param <E> Class of the value that this node holds.
 * @author Paulo Pereira
 */
public class Node<E> {

    /**
     * The value that this node will hold.
     */
    private final E value;

    /**
     * Constructor.
     *
     * @param value The value that this node will hold.
     */
    public Node(final E value) {
        this.value = value;
    }

    /**
     * Retrieves the value that this node holds.
     *
     * @return Value that this node holds.
     */
    public E getValue() {
        return this.value;
    }

    /**
     * Converts this object to a string.
     *
     * @return String that represents an instance of this object.
     */
    @Override
    public String toString() {
        return this.value.toString();
    }
}
