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

package org.example.array;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCompressionTest {

    @Test
    public void smallerCompression() {

        final String toCompress = "aabcccccaaa";
        final String expected = "a2b1c5a3";

        assertThat(StringCompression.compress(toCompress))
                .isEqualTo(expected);
    }
    @Test
    public void biggerCompression() {

        final String toCompress = "abcdef";
        final String expected = "abcdef";

        assertThat(StringCompression.compress(toCompress))
                .isEqualTo(expected);
    }
}
