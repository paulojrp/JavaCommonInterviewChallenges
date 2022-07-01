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

package org.example.graph.search;

import org.example.commons.BinaryNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.function.Consumer;

public class BreadthFirstSearch {

    public static <E> void findNode(final BinaryNode<E> root, final Consumer<BinaryNode<E>> visitFunction) {

        final LinkedList<BinaryNode<E>> queueOfNextNodes = new LinkedList<>();
        final Set<BinaryNode<E>> setOfVisitedNodes = new HashSet<>();

        queueOfNextNodes.add(root);

        while (!queueOfNextNodes.isEmpty()) {

            final BinaryNode<E> currentNode = queueOfNextNodes.pop();

            if (currentNode == null || setOfVisitedNodes.contains(currentNode)) {
                break;
            }
            setOfVisitedNodes.add(currentNode);
            visitFunction.accept(currentNode);

            queueOfNextNodes.add(currentNode.getLeft());
            queueOfNextNodes.add(currentNode.getRight());
        }
    }
}
