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
package net.clarenceho.heapsort;

import java.util.List;


/**
 * Heapsort implementation.  The logic is basically the same as the one
 * described in wikipedia (https://en.wikipedia.org/wiki/Heapsort)
 * 
 */
public class Heapsort {

    private Heapsort() { }
    
    /**
     * Sorts the specified list into ascending order using Heapsort.
     * 
     * @param list the list to be sorted
     */
    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        heapify(list);
        
        int currSize = list.size();
        while (currSize > 0) {
            swap(list, 0, currSize - 1);
            currSize--;
            siftDown(list, 0, currSize - 1);
        }
    }
    
    /**
     * Builds the heap
     * 
     * @param list the list to be sorted
     */
    private static <T extends Comparable<? super T>>
            void heapify(List<T> list) {
        
        int node = parent(list.size() - 1); // start from last parent
        while (node >= 0) {
            siftDown(list, node, list.size() - 1);
            node -= 1;
        }
    }
    
    /**
     * Repairs the heap by moving down the node with smaller value down the heap
     * 
     * @param list the list to be sorted
     * @param node the starting node
     * @param last the index of the last node
     */
    private static <T extends Comparable<? super T>>
            void siftDown(List<T> list, int node, int last) {

        while (left(node) <= last) {    // the node has at least one child
            int left = left(node);
            int right = right(node);
            int nodeToSwap = node;
            
            // compare children with current node. swap biggest as parent
            if (left <= last && list.get(left).compareTo(list.get(node)) > 0) {
                nodeToSwap = left;
            }
            if (right <= last &&
                    list.get(right).compareTo(list.get(nodeToSwap)) > 0) {
                nodeToSwap = right;
            }
            if (nodeToSwap != node) {
                swap(list, node, nodeToSwap);
            } else {
                break;
            }
            // performed swap. repair the heap starting from the swapped child
            node = nodeToSwap;
        }
    }

    private static <T extends Comparable<? super T>>
            void swap(List<T> list, int n1, int n2) {
        
        T temp = list.get(n1);
        list.set(n1, list.get(n2));
        list.set(n2, temp);
    }
    
    private static int parent(int node) {
        return ((node+1) / 2) - 1;
    }
    
    private static int left(int node) {
        return ((node+1) * 2) - 1;
    }
    
    private static int right(int node) {
        return (node+1) * 2;
    }
}
