package com.learn.dp;

import java.util.Arrays;

public class FrogJump {
    private static int[] arr = {30, 10, 60, 10, 60, 50};
    public static void main(String[] args) {
        int[] dp = new int[6];
        Arrays.fill(dp, -1);
        System.out.println(minByMemo(5, dp));
        System.out.println(minByRec(5));
        int[] dpn = new int[6];
        System.out.println(minByTab(6, dpn));
    }

    private static int minByRec(int i) {
        if (i == 0) return 0;
        int l = minByRec(i-1) + Math.abs(arr[i] - arr[i-1]);
        int r = Integer.MAX_VALUE;
        if (i > 1) r = minByRec(i-2) + Math.abs(arr[i] - arr[i-2]);
        return Math.min(l, r);
    }

    private static int minByMemo(int i, int[] dp) {
        if(dp[i] != -1) return dp[i];
        if (i == 0) return 0;
        int l = minByMemo(i-1, dp) + Math.abs(arr[i] - arr[i-1]);
        int r = Integer.MAX_VALUE;
        if (i > 1) r = minByMemo(i-2, dp) + Math.abs(arr[i] - arr[i-2]);
        return dp[i] = Math.min(l, r);
    }

    private static int minByTab(int n, int[] dp) {
        for (int i = 1; i < n; i++) {
            int fs = dp[i-1] + Math.abs(arr[i] - arr[i - 1]);
            int ss = Integer.MAX_VALUE;
            if (i>1) ss = dp[i-2] + Math.abs(arr[i] - arr[i - 2]);
            dp[i] = Math.min(fs, ss);
        }
        return dp[n-1];
    }
}
