package com.learn.dp;

import java.util.*;

public class Main {
    public static void main(String[] comm) {
        int[] dp = new int[100];
        Arrays.fill(dp, -1);
        System.out.println(fib(10, dp));
    }
    private static int fib(int n, int[] dp) {
        if (n <= 1) return n;
        if (dp[n] != -1) return dp[n];
        return dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
    }
}