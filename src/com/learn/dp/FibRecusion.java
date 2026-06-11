package com.learn.dp;

import java.util.Arrays;

public class FibRecusion {
    public static void main(String[] args) {
        int n = 43;
        long[] dp = new long[n + 1];
        dp[0] = 0; dp[1] = 1;
        System.out.println(getNthBySO(n));
        System.out.println(getNthFibByTab(n, dp));
        Arrays.fill(dp, -1);
        System.out.println(getNthFibByMemo(n, dp));
        System.out.println(getNthFibonacci(n));
    }

    private static long getNthFibonacci(int n) {
        if (n <= 1) return n;
        return getNthFibonacci(n - 1) + getNthFibonacci(n - 2);
    }

    private static long getNthFibByMemo(int n, long[] dp) {
        if (n <= 1) return n;
        if (dp[n] != -1) return dp[n];
        return getNthFibByMemo(n - 1, dp) + getNthFibByMemo(n - 2, dp);
    }

    private static long getNthFibByTab(int n, long[] dp) {
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    private static long getNthBySO(int n) {
        long first = 0, second = 1;
        for (int i = 0; i < n; i++) {
            long third = first + second;
            first = second;
            second = third;
        }
        return first;
    }

}

 // 0 1 1 2 3 5 8 13 21