package com.chefmic.linkedin;

import java.util.Iterator;

/**
 * Created by cyuan on 3/21/17.
 */
public class Q284PeekingIterator {

    class PeekingIterator implements Iterator<Integer> {

        private Integer cache;
        private Iterator<Integer> iterator;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            cache = iterator.hasNext() ? iterator.next() : null;
            this.iterator = iterator;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return cache;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            Integer next = cache;
            cache = iterator.hasNext() ? iterator.next() : null;
            return next;
        }

        @Override
        public boolean hasNext() {
            return cache != null;
        }
    }


}
