package com.learn.dp;

import java.util.Arrays;

public class FibRecusion {
    public static void main(String[] args) {
        System.out.println(getNthFibonacci(10));
        int[] dp = new int[11];
        Arrays.fill(dp, -1);
        System.out.println(getNthFibByMemo(10, dp));
        dp[0] = 0; dp[1] = 1;
        System.out.println(getNthFibByTab(10, dp));
    }

    private static int getNthFibonacci(int n) {
        if (n <= 1) return n;
        return getNthFibonacci(n - 1) + getNthFibonacci(n - 2);
    }

    private static int getNthFibByMemo(int n, int[] dp) {
        if (n <= 1) return n;
        if (dp[n] != -1) return dp[n];
        return getNthFibByMemo(n - 1, dp) + getNthFibByMemo(n - 2, dp);
    }

    private static int getNthFibByTab(int n, int[] dp) {
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

 // 0 1 1 2 3 5 8 13 21