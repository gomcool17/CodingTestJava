package _4_그래프_dp;

import java.util.Scanner;

public class _2579_계단오르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[301];
        int[] dp = new int[301];
        for(int i=0;i<N;i++) arr[i] = sc.nextInt();
        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        dp[2] = Math.max(arr[0] + arr[2], arr[1]+arr[2]);

        for(int i=3;i<N;i++) {
            dp[i] = Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]);
        }
        System.out.println(dp[N-1]);
    }
}
