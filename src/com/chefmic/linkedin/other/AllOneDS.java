package com.chefmic.linkedin.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by cyuan on 4/18/17.
 * A data structure supporting insert, delete,
 * search and random delete in constant time
 * <p>
 * Followup: Allow duplicates
 * Use a list for all indexes
 */
public class AllOneDS<T> {

    ArrayList<T> arr;   // A resizable array

    // A hash where keys are array elements and vlaues are
    // indexes in arr[]
    HashMap<T, Integer> hash;

    // Constructor (creates arr[] and hash)
    public AllOneDS() {
        arr = new ArrayList<>();
        hash = new HashMap<>();
    }

    // A Theta(1) function to add an element to MyDS
    // data structure
    void add(T x) {
        // If ekement is already present, then noting to do
        if (hash.get(x) != null)
            return;

        // Else put element at the end of arr[]
        int s = arr.size();
        arr.add(x);

        // And put in hash also
        hash.put(x, s);
    }

    // A Theta(1) function to remove an element from MyDS
    // data structure
    void remove(T x) {
        // Check if element is present
        Integer index = hash.get(x);
        if (index == null)
            return;

        // If present, then remove element from hash
        hash.remove(x);

        // Swap element with last element so that remove from
        // arr[] can be done in O(1) time
        int size = arr.size();
        T last = arr.get(size - 1);
        Collections.swap(arr, index, size - 1);

        // Remove last element (This is O(1))
        arr.remove(size - 1);

        // Update hash table for new index of last element
        hash.put(last, index);
    }

    // Returns a random element from MyDS
    T getRandom() {
        // Find a random index from 0 to size - 1
        Random rand = new Random();  // Choose a different seed
        int index = rand.nextInt(arr.size());

        // Return element at randomly picked index
        return arr.get(index);
    }

    // Returns index of element if element is present, otherwise null
    Integer search(T x) {
        return hash.get(x);
    }
}
