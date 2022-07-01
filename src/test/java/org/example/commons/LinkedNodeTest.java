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

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedNodeTest {

    @Test
    public void validCreation() {

        final LinkedNode<String> instance = new LinkedNode<>("A");

        assertThat(instance.getValue())
                .isEqualTo(instance.toString());
        assertThat(instance.next())
                .isNull();

        instance.setNext(instance);

        assertThat(instance.next())
                .isEqualTo(instance);
    }
}
