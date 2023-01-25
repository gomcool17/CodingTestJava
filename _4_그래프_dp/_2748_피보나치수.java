package _4_그래프_dp;

import java.util.Scanner;

public class _2748_피보나치수 {
    public static long[] arr = new long[91];
    public static long[] dp = new long[91];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp[1] = 1;
        for(int i=2;i<=N;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[N]);
    }
}
