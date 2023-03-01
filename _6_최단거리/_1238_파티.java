package _6_최단거리;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1238_파티 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int INF = 987654321;

        int[][] arr = new int[1001][1001];
        for(int i=1;i<=N;i++) Arrays.fill(arr[i], INF);
        arr[X][X] = -1;

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        for(int k=1;k<=N;k++) {
            for(int i=1;i<=N;i++) {
                for(int j=1;j<=N;j++) {
                    if(i==j) arr[i][j] = 0;
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        int result = 0;
        for(int i=1;i<=N;i++) {

            result = Math.max(result, arr[i][X] + arr[X][i]);
        }

        sb.append(result).append('\n');
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
