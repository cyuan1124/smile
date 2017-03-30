package com.chefmic.linkedin;

/**
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 */
public class Q81SearchInRotatedSortedArrayII {

    public boolean search(int[] A, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int lo = 0, hi = A.length - 1;
        int mid = 0;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (A[mid] == target) return true;
            if (A[mid] > A[hi]) {
                if (A[mid] > target && A[lo] <= target) hi = mid;
                else lo = mid + 1;
            } else if (A[mid] < A[hi]) {
                if (A[mid] < target && A[hi] >= target) lo = mid + 1;
                else hi = mid;
            } else {
                hi--;
            }

        }
        return A.length > 0 && A[lo] == target;
    }

}
