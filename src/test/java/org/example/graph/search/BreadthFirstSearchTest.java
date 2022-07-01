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
import org.example.commons.LinkedNode;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class BreadthFirstSearchTest {

    @Test
    public void withoutCycle() {

        final BinaryNode<String> root = createGraphWithoutCycle();

        final StringBuilder stringBuilder = new StringBuilder();

        BreadthFirstSearch.findNode(root, node -> stringBuilder.append(node.getValue()));

        assertThat(stringBuilder.toString())
                .isEqualTo("ABCDEFG");
    }

    private BinaryNode<String> createGraphWithoutCycle() {

        final BinaryNode<String> a = new BinaryNode<>("A");
        final BinaryNode<String> b = new BinaryNode<>("B");
        final BinaryNode<String> c = new BinaryNode<>("C");
        final BinaryNode<String> d = new BinaryNode<>("D");
        final BinaryNode<String> e = new BinaryNode<>("E");
        final BinaryNode<String> f = new BinaryNode<>("F");
        final BinaryNode<String> g = new BinaryNode<>("G");

        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setLeft(f);
        c.setRight(g);

        return a;
    }
}
