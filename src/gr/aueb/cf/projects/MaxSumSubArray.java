package gr.aueb.cf.projects;

import java.util.Arrays;

public class MaxSumSubArray {
    private static int globalMaximum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -57, 4};
        int[] result = maxSubArray(arr);

        System.out.println(Arrays.toString(result));
    }

    public static int[] maxSubArray(int[] arr) {
        int localMax = arr[0];
        int tempStart = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > localMax + arr[i]) {
                localMax = arr[i];
                tempStart = i;
            } else {
                localMax += arr[i];
            }
            if (localMax > globalMaximum) {
                globalMaximum = localMax;
                start = tempStart;
                end = i;
            }
        }
        return Arrays.copyOfRange(arr, start, end + 1);
    }
}
