package _3_그래프;

import java.util.Arrays;
import java.util.Scanner;

public class _4963 {
    public static boolean visit[][] = new boolean[51][51];
    public static int arr[][] = new int[51][51];
    public static int dy[] = {1,-1,0,0,1,1,-1,-1};
    public static int dx[] = {0,0,-1,1,1,-1,-1,1};
    public static int w;
    public static int h;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            w = sc.nextInt();
            h = sc.nextInt();
            if(w==0 && h==0) break;
            int re = 0;
            for(int i=0;i<h;i++) {
                Arrays.fill(visit[i],false);
            }

            for(int i=0;i<h;i++) {
                Arrays.fill(arr[i], 0);
            }

            for(int i=0;i<h;i++) {
                for(int j=0;j<w;j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            for(int i=0;i<h;i++) {
                for(int j=0;j<w;j++) {
                    if(visit[i][j]) continue;
                    if(arr[i][j] == 0) continue;
                    dfs(i,j);
                    re++;
                }
            }

            System.out.println(re);
        }
    }

    public static void dfs(int y, int x) {
        visit[y][x] = true;

        for(int i=0;i<8;i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny >=0 && nx >= 0 && ny < h && nx < w && !visit[ny][nx] && arr[ny][nx] == 1) {
                dfs(y+dy[i], x+dx[i]);
            }
        }
    }
}
