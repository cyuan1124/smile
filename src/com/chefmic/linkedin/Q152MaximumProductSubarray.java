package com.chefmic.linkedin;

/**
 * Created by cyuan on 3/19/17.
 */
public class Q152MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxBefore = nums[0];
        int minBefore = nums[0];
        int maxProduct = nums[0];
        int maxhere, minhere;

        for (int i = 1; i < nums.length; i++) {
            maxhere = Math.max(Math.max(maxBefore * nums[i], minBefore * nums[i]), nums[i]);
            minhere = Math.min(Math.min(maxBefore * nums[i], minBefore * nums[i]), nums[i]);
            maxProduct = Math.max(maxhere, maxProduct);
            maxBefore = maxhere;
            minBefore = minhere;
        }

        return maxProduct;
    }

}
