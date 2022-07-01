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

package org.example.graph;

import java.util.function.Function;

import com.google.common.base.Preconditions;
import org.example.commons.LinkedNode;


/**
 * Implementation of Floyd's algorithm to detect if a single graph (linked list) contains a cycle. Besides, it is
 * also able to detect the first node of the cycle without using extra memory.
 *
 * @author Paulo Pereira
 */
public class DetectCycleInList {

    /**
     * Finds and retrieve the first node of a cycle.
     *
     * @param root Reference to the root node.
     * @param <E>  Class of the value that the nodes can hold.
     * @return The first node of cycle if there is a cycle, null otherwise.
     */
    public static <E> LinkedNode<E> detectFirstNodeInCycle(final LinkedNode<E> root) {

        final LinkedNode<E> collisionNode = getCollisionNode(root);

        if (collisionNode == null) {
            return null;
        }

        // required to ensure that the collision node and root node are not the same
        if (detectCollision(collisionNode, root)) {
            return root;
        }
        return getCollisionNode(root, collisionNode, DetectCycleInList::walkSlow, DetectCycleInList::walkSlow);
    }

    /**
     * Finds if the graph contains a cycle.
     *
     * @param root Reference to the root node.
     * @param <E>  Class of the value that the nodes can hold.
     * @return True if there's a cycle, false otherwise.
     */
    public static <E> boolean detectedCycled(final LinkedNode<E> root) {

        return getCollisionNode(root) != null;
    }

    private static <E> LinkedNode<E> getCollisionNode(final LinkedNode<E> root) {

        return getCollisionNode(root, root, DetectCycleInList::walkSlow, DetectCycleInList::walkFast);
    }

    private static <E> LinkedNode<E> getCollisionNode(final LinkedNode<E> firstNode,
                                                      final LinkedNode<E> secondNode,
                                                      final WalkFunction<E> walkFirstNode,
                                                      final WalkFunction<E> walkSecondNode) {

        Preconditions.checkNotNull(firstNode, "first node cannot be null");
        Preconditions.checkNotNull(secondNode, "second node cannot be null");

        LinkedNode<E> firstPointer = firstNode;
        LinkedNode<E> secondPointer = secondNode;

        while(firstPointer != null && secondPointer != null) {

            firstPointer = walkFirstNode.apply(firstPointer);
            secondPointer = walkSecondNode.apply(secondPointer);

            if (detectCollision(firstPointer, secondPointer)) {
                return firstPointer;
            }
        }
        return null;
    }

    private static <E> LinkedNode<E> walkSlow(final LinkedNode<E> slowPointer) {
        return slowPointer.next();
    }

    private static <E> LinkedNode<E> walkFast(final LinkedNode<E> fastPointer) {
        final LinkedNode<E> nextPointer = fastPointer.next();
        return nextPointer == null ? null : nextPointer.next();
    }

    private static <E> boolean detectCollision(final LinkedNode<E> slowPointer, final LinkedNode<E> fastPointer) {
        return slowPointer == fastPointer;
    }

    private interface WalkFunction<E> extends Function<LinkedNode<E>, LinkedNode<E>> {}
}
