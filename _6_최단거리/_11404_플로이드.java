package _6_최단거리;

import java.util.Scanner;

public class _11404_플로이드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int INF = 987654321;
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[101][101];

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) arr[i][j] = INF;
        }

        for(int i=0;i<m;i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            arr[u][v] = Math.min(arr[u][v], w);
        }

        for(int k=1;k<=n;k++) {
            for(int i=1;i<=n;i++) {
                for(int j=1;j<=n;j++) {
                    if(i==j) continue;
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(arr[i][j] == INF) System.out.print(0 + " ");
                else System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
