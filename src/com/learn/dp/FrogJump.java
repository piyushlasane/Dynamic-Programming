package com.learn.dp;

import java.util.Arrays;

public class FrogJump {
    private static int[] arr = {30, 10, 60, 10, 60, 50};
    public static void main(String[] args) {
        System.out.println((minBySO(6)));
        int[] dpn = new int[6];
        System.out.println(minByTab(6, dpn));
        int[] dp = new int[6];
        Arrays.fill(dp, -1);
        System.out.println(minByMemo(5, dp));
        System.out.println(minByRec(5));
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

    private static int minBySO(int n) {
        int prev = 0, prev2 = 0;
        for (int i = 1; i < n; i++) { // 3,  4,  5
            int fs = prev + Math.abs(arr[i] - arr[i-1]); // 20, 20+50, 30+50, 20+50, 30+10
            int ss = Integer.MAX_VALUE;
            if(i>1) ss = prev2 + Math.abs(arr[i] - arr[i-2]); // 0+30, 20+0, 30+0, 20+40
            int curi = Math.min(fs, ss); // 20 , 30,  20, 30, 40
            prev2 = prev; // 20, 30, 20, 30
            prev = curi; // 30, 20, 30, 40
        }
        return prev;
    }
}
