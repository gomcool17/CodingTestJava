package _6_최단거리;

import java.io.*;
import java.util.StringTokenizer;

public class _2458_키순서 {
    public static int N,M;
    public static int INF = 987654321;
    public static int[][] arr = new int[501][501];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb =  new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                if(i==j) {
                    arr[i][j] = 1;
                    continue;
                }
                arr[i][j] = INF;
            }
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
        }

        for(int k=1;k<=N;k++) {
            for(int i=1;i<=N;i++) {
                for(int j=1;j<=N;j++) {
                    if(i==j) continue;
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        int re = 0;
        boolean f = true;
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                if(arr[i][j] != INF || arr[j][i] != INF) continue;
                else f = false;
            }
            if(f) re++;
            f = true;
        }

        sb.append(re).append('\n');
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
