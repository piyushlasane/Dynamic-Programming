package com.learn.dp;

import java.util.Arrays;

public class Non_Adjacent_Sum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,9,8,7,6,5,9,0,4,3,5,6,1,5,5,2,3,6,9,5,8,2,5,1,5,2,3,6,2,5,3,3,2,6,3,2,6,3,2};
        int[] ndp = new int[arr.length];
        System.out.println(maxBySO(arr, arr.length, ndp));
        System.out.println(maxByTab(arr, arr.length, ndp));
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        System.out.println(maxByMemo(arr, arr.length-1, dp));
        System.out.println(maxByRec(arr, arr.length-1));
    }

    private static int maxByRec(int[] arr, int idx) {
        if (idx == 0) return arr[0];
        if (idx < 0) return 0;
        int pick = arr[idx] + maxByRec(arr, idx - 2);
        int notPick = maxByRec(arr, idx - 1);
        return Math.max(pick, notPick);
    }

    private static int maxByMemo(int[] arr, int idx, int[] dp) {
        if (idx == 0) return arr[idx];
        if (idx < 0) return 0;
        if (dp[idx] != -1) return dp[idx];
        int pick = arr[idx] + maxByMemo(arr, idx - 2, dp);
        int notPick = maxByMemo(arr, idx - 1, dp);
        return dp[idx] = Math.max(pick, notPick);
    }

    private static int maxByTab(int[] arr, int n, int[] dp) {
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            int pick = Integer.MIN_VALUE;
            if (i > 1) {
                pick = arr[i] + dp[i - 2];
            }
                int notPick = dp[i - 1];
                dp[i] = Math.max(pick, notPick);
        }
        return dp[n - 1];
    }

    private static int maxBySO(int[] arr, int n, int[] dp) {
        int prev = arr[0], prev2 = 0;
        for (int i = 1; i < n; i++) {
            int pick = Integer.MIN_VALUE;
            if (i > 1) {
                pick = arr[i] + prev2;
            }
            int notPick = prev;
            int curi = Math.max(pick, notPick);
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }
}
