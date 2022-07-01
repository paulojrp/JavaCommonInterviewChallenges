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

import org.example.commons.LinkedNode;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DetectCycleInListTest {

    private static LinkedNode<String> rootNode;
    private static LinkedNode<String> firstNodeOfCycle;

    @BeforeClass
    public static void beforeClass() {
        createGraphWithCycle();
    }

    @Test
    public void detectCycleInGraphWithCycle() {
        final boolean detectedCycle = DetectCycleInList.detectedCycled(rootNode);
        assertThat(detectedCycle)
                .isTrue();
    }

    @Test
    public void firstNodeOfGraphWithCycle() {
        final LinkedNode<String> node = DetectCycleInList.detectFirstNodeInCycle(rootNode);
        assertThat(node)
                .isEqualTo(firstNodeOfCycle);
    }

    @Test
    public void detectCycleInGraphWithoutCycle() {
        final LinkedNode<String> rootNode = createGraphWithoutCycle();

        final boolean detectedCycle = DetectCycleInList.detectedCycled(rootNode);
        assertThat(detectedCycle)
                .isFalse();
    }

    @Test
    public void firstNodeOfGraphWithoutCycle() {
        final LinkedNode<String> rootNode = createGraphWithoutCycle();

        final LinkedNode<String> node = DetectCycleInList.detectFirstNodeInCycle(rootNode);
        assertThat(node)
                .isNull();
    }

    @Test
    public void detectCycleInGraphWithOnlyOneNodeAndCycle() {
        final LinkedNode<String> rootNode = createGraphWithOnlyOneNodeAndCycle();

        final boolean detectedCycle = DetectCycleInList.detectedCycled(rootNode);
        assertThat(detectedCycle)
                .isTrue();
    }

    @Test
    public void firstNodeOfGraphWithOnlyOneNodeAndCycle() {
        final LinkedNode<String> rootNode = createGraphWithOnlyOneNodeAndCycle();

        final LinkedNode<String> node = DetectCycleInList.detectFirstNodeInCycle(rootNode);
        assertThat(node)
                .isEqualTo(rootNode);
    }

    @Test
    public void detectCycleInInvalidGraph() {

        assertThatThrownBy(() -> DetectCycleInList.detectedCycled(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void firstNodeOfInvalidGraph() {

        assertThatThrownBy(() -> DetectCycleInList.detectFirstNodeInCycle(null))
                .isInstanceOf(NullPointerException.class);
    }

    private static void createGraphWithCycle() {

        final LinkedNode<String> a = new LinkedNode<>("A");
        final LinkedNode<String> b = new LinkedNode<>("B");
        final LinkedNode<String> c = new LinkedNode<>("C");
        final LinkedNode<String> d = new LinkedNode<>("D");
        final LinkedNode<String> e = new LinkedNode<>("E");

        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        e.setNext(c);

        rootNode = a;
        firstNodeOfCycle = c;
    }

    private static LinkedNode<String> createGraphWithoutCycle() {

        final LinkedNode<String> a = new LinkedNode<>("A");
        final LinkedNode<String> b = new LinkedNode<>("B");
        final LinkedNode<String> c = new LinkedNode<>("C");

        a.setNext(b);
        b.setNext(c);

        return a;
    }

    private static LinkedNode<String> createGraphWithOnlyOneNodeAndCycle() {

        final LinkedNode<String> a = new LinkedNode<>("A");
        a.setNext(a);

        return a;
    }
}
