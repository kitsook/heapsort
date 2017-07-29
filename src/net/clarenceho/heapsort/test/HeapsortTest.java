/*
MIT License

Copyright (c) 2017 clarence ho

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package net.clarenceho.heapsort.test;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import net.clarenceho.heapsort.Heapsort;


public class HeapsortTest {

    @Test
    public void testEmptyList01() {
        List<Integer> list = Arrays.asList(new Integer[]{ });
        Heapsort.sort(list);
        assertArrayEquals(new Integer[] {}, list.toArray());
    }

    @Test
    public void testSingleElementList01() {
        List<Integer> list = Arrays.asList(new Integer[]{ 1 });
        Heapsort.sort(list);
        assertArrayEquals(new Integer[] { 1 }, list.toArray());
    }

    @Test
    public void testIntegerList01() {
        List<Integer> list = Arrays.asList(new Integer[]{ 2, 3 });
        Heapsort.sort(list);
        assertArrayEquals(new Integer[] { 2, 3 }, list.toArray());
    }

    @Test
    public void testIntegerList02() {
        List<Integer> list = Arrays.asList(new Integer[]{ 2, 3, 1 });
        Heapsort.sort(list);
        assertArrayEquals(new Integer[] { 1, 2, 3 }, list.toArray());
    }

    @Test
    public void testIntegerList03() {
        List<Integer> list = Arrays.asList(new Integer[]{ 1, 2, 3 });
        Heapsort.sort(list);
        assertArrayEquals(new Integer[] { 1, 2, 3 }, list.toArray());
    }

    @Test
    public void testIntegerList04() {
        List<Integer> list = Arrays.asList(
                new Integer[]{ 5, 3, 9, 1, 7, 8, 0 });
        Heapsort.sort(list);
        assertArrayEquals(new Integer[] { 0, 1, 3, 5, 7, 8, 9 },
                list.toArray());
    }

    @Test
    public void testIntegerList05() {
        List<Integer> list = Arrays.asList(
                new Integer[]{ 2, 5, 8, 0, 1, 6, 4, 3, 9, 7 });
        Heapsort.sort(list);
        assertArrayEquals(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                list.toArray());
    }

    @Test
    public void testIntegerList06() {
        List<Integer> list = Arrays.asList(
                new Integer[]{ 5, 3, 5, 9, 0, 1, 2, 2 });
        Heapsort.sort(list);
        assertArrayEquals(new Integer[] { 0, 1, 2, 2, 3, 5, 5, 9 },
                list.toArray());
    }

    @Test
    public void testCharacterList01() {
        List<Character> list = Arrays.asList(
                new Character[]{ 'H', 'E', 'A', 'P' });
        Heapsort.sort(list);
        assertArrayEquals(new Character[] { 'A', 'E', 'H', 'P' },
                list.toArray());
    }

    @Test
    public void compareSort01() {
        List<Integer> list = new ArrayList<>();
        Random rand = new Random();
        int range = 10000;
        for (int i = 0; i < 1000; i++) {
            list.add(rand.nextInt(range));
        }
        
        List<Integer> listCollectionsSort = new ArrayList<>(list);
        List<Integer> listHeapsort = new ArrayList<>(list);
        
        Collections.sort(listCollectionsSort);
        Heapsort.sort(listHeapsort);
        assertArrayEquals(listCollectionsSort.toArray(),
                listHeapsort.toArray());
    }

    @Test
    public void comparePerformance01() {
        List<Integer> list = new ArrayList<>();
        Random rand = new Random();
        int range = 10000;
        for (int i = 0; i < 1000; i++) {
            list.add(rand.nextInt(range));
        }

        long start;
        long timeCollectionsSort, timeHeapsort;
        int repeat = 10000;

        start = System.currentTimeMillis();
        for (int i = 0; i < repeat; i++) {
            List<Integer> listCollectionsSort = new ArrayList<>(list);
            Collections.sort(listCollectionsSort);
        }
        timeCollectionsSort = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        for (int i = 0; i < repeat; i++) {
            List<Integer> listHeapsort = new ArrayList<>(list);
            Heapsort.sort(listHeapsort);
        }
        timeHeapsort = System.currentTimeMillis() - start;

        System.out.println(
                "Collections.sort time: " + timeCollectionsSort + "ms");
        System.out.println("Heapsort.sort time: " + timeHeapsort + "ms");
     
    }

    @Test
    public void compareSortedPerformance01() {
        List<Integer> list = new ArrayList<>();
        Random rand = new Random();
        int range = 10000;
        for (int i = 0; i < 1000; i++) {
            list.add(rand.nextInt(range));
        }
        Collections.sort(list);

        long start;
        long timeCollectionsSort, timeHeapsort;
        int repeat = 10000;

        start = System.currentTimeMillis();
        for (int i = 0; i < repeat; i++) {
            List<Integer> listCollectionsSort = new ArrayList<>(list);
            Collections.sort(listCollectionsSort);
        }
        timeCollectionsSort = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        for (int i = 0; i < repeat; i++) {
            List<Integer> listHeapsort = new ArrayList<>(list);
            Heapsort.sort(listHeapsort);
        }
        timeHeapsort = System.currentTimeMillis() - start;

        System.out.println(
                "Collections.sort time of sorted: " + timeCollectionsSort + "ms");
        System.out.println("Heapsort.sort time of sorted: " + timeHeapsort + "ms");     
    }

    @Test
    public void compareSortedPerformance02() {
        List<Integer> list = new ArrayList<>();
        Random rand = new Random();
        int range = 10000;
        for (int i = 0; i < 1000; i++) {
            list.add(rand.nextInt(range));
        }
        Collections.sort(list, Collections.reverseOrder());

        long start;
        long timeCollectionsSort, timeHeapsort;
        int repeat = 10000;

        start = System.currentTimeMillis();
        for (int i = 0; i < repeat; i++) {
            List<Integer> listCollectionsSort = new ArrayList<>(list);
            Collections.sort(listCollectionsSort);
        }
        timeCollectionsSort = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        for (int i = 0; i < repeat; i++) {
            List<Integer> listHeapsort = new ArrayList<>(list);
            Heapsort.sort(listHeapsort);
        }
        timeHeapsort = System.currentTimeMillis() - start;

        System.out.println(
                "Collections.sort time of reversely sorted: " + timeCollectionsSort + "ms");
        System.out.println("Heapsort.sort time of reversely sorted: " + timeHeapsort + "ms");
     
    }
}
