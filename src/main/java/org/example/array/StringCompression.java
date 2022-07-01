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

/**
 * Compress a string if the compressed result is smaller than the original one, otherwise it returns the original
 * string.
 *
 * @author Paulo Pereira
 */
public class StringCompression {

    public static String compress(final String string) {

        final StringBuilder stringBuilder = new StringBuilder();
        final char[] chars = string.toCharArray();
        char currentChar = chars[0];
        int currentCount = 1;
        int newStringSize = 0;

        for (int i = 1; i < chars.length; i++) {

            final char c = chars[i];
            if (c != currentChar) {
                stringBuilder.append(currentChar);
                stringBuilder.append(currentCount);
                newStringSize += 1 + countOfNumbers(currentCount);
                currentChar = c;
                currentCount = 1;
            } else {
                currentCount++;
            }
        }
        stringBuilder.append(currentChar);
        stringBuilder.append(currentCount);
        newStringSize += 1 + countOfNumbers(currentCount);

        if(newStringSize >= string.length()) {
            return string;
        }
        return stringBuilder.toString();
    }

    private static int countOfNumbers(final int num) {
        int count = 0;
        int temp = num;
        while (temp > 0) {
            temp /= 10;
            count++;
        }
        return count;
    }
}
