package _6_최단거리;

import java.io.*;
import java.util.StringTokenizer;

public class _11403_경로찾기 {
    public static int n;
    public static int INF = 987654321;
    public static int[][] arr = new int[101][101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int i=0;i<101;i++) for(int j=0;j<101;j++) arr[i][j] = INF;
        n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) {
                int a = Integer.parseInt(st.nextToken());
                if(a == 1) arr[i][j] = 1;
            }
        }

        for(int k=0;k<n;k++) {
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    //if(i == j) continue;
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(arr[i][j] == INF) System.out.print(0 + " ");
                else System.out.print(1 + " ");
            }
            System.out.println();
        }


    }
}
