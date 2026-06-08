package com.learn.dp;

import java.util.Arrays;

public class FrogJump_II {
    private static final int[] arr = {356465, 1654654, 60, 10, 60, 50, 200, 400, 600, 30};
    private static final int k = 3;
    public static void main(String[] args) {
        int[] dpn = new int[10];
        System.out.println(minByTab(10, dpn));
        int[] dp = new int[11];
        Arrays.fill(dp, -1);
        System.out.println(minByMemo(9, dp));
        System.out.println(minByRec(9));
    }

    private static int minByRec(int idx) {
        if (idx == 0) return 0;
        int minJ = Integer.MAX_VALUE;
        for (int i = 1; i <= k ; i++) {
            if (idx >= i) {
                int curJ = minByRec(idx - i) + Math.abs(arr[idx] - arr[idx - i]);
                minJ = Math.min(minJ, curJ);
            }
        }
        return minJ;
    }

    private static int minByMemo(int idx, int[] dp) {
        if (idx == 0) return 0;
        if(dp[idx] != -1) return dp[idx];
        int minJ = Integer.MAX_VALUE;
        for (int i = 1; i <= k ; i++) {
            if (idx >= i) {
                int curJ = minByMemo(idx - i, dp) + Math.abs(arr[idx] - arr[idx - i]);
                minJ = Math.min(minJ, curJ);
            }
        }
        return dp[idx] = minJ;
    }

    private static int minByTab(int n, int[] dp) {
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int minJ = Integer.MAX_VALUE;
            for (int j = 1; j <= k ; j++) {
                if (i >= j) {
                    int curJ = dp[i - j] + Math.abs(arr[i] - arr[i - j]);
                    minJ = Math.min(minJ, curJ);
                }
            }
            dp[i] = minJ;
        }
        return dp[n-1];
    }
}
