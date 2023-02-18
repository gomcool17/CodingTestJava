package _4_그래프_dp;

import java.util.Scanner;

public class _14501_퇴사 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] T= new int[1001];
        int[] P = new int[1001];
        int[] dp = new int[1001];

        for(int i=0;i<N;i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        for(int i=0;i<N;i++) {
            if(i + T[i] >= N) {
                dp[N-1] = Math.max(dp[i], dp[N-1]);
                continue;
            }
            dp[i + T[i]] = Math.max(dp[i] + P[i], dp[i+T[i]]);
            dp[i+1] = Math.max(dp[i], dp[i+1]);
        }
        System.out.println(dp[N-1]);
    }
}
