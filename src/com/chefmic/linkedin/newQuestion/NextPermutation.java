package com.chefmic.linkedin.newQuestion;

public class NextPermutation {
    public void nextPermutation(int[] num) {
        if (num == null || num.length <= 1) {
            return;
        }
        int edge = -1;
        for (int i = num.length - 2; i >= 0; i--) {
            if (num[i] < num[i + 1]) {
                edge = i;
                break;
            }
        }
        if (edge > -1) {
            for (int i = num.length - 1; i > edge; i--) {
                if (num[i] > num[edge]) {
                    swap(num, i, edge);
                    break;
                }
            }
        }

        int i = edge + 1;
        int j = num.length - 1;
        while (i < j) {
            swap(num, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] num, int a, int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }
}
