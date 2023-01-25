package _4_그래프_dp;

import java.util.Scanner;

public class _11050_이항계수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        long[][] dp = new long[1001][1001];

        dp[1][0] = 1;
        dp[1][1] = 1;

        for(int i=2; i <= N;i++) {
            for(int j=0;j<=i;j++) {
                if(j == 0 || j == i) dp[i][j] = 1;
                else dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        System.out.println(dp[N][K]);
    }
}
