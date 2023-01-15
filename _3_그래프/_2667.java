package _3_그래프;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _2667 {
    public static boolean visit[][] = new boolean[25][25];
    public static char arr[][] = new char[25][25];
    public static int dy[] = {1,-1,0,0};
    public static int dx[] = {0,0,-1,1};
    public static int N;
    public static ArrayList<Integer> ans = new ArrayList<>();
    public static int ans2 = 0;
    public static int re = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i=0;i<N;i++) {
            String str =  sc.next();
            for(int j=0;j<N;j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for(int i=0;i<N;i++) {
            for (int j = 0; j < N; j++) {
                if(visit[i][j]) continue;
                if(arr[i][j] == '0') continue;
                ans2++;
                dfs(i,j);
                re++;
                ans.add(ans2);
                ans2 = 0;
            }
        }
        System.out.println(re);
        Collections.sort(ans);
        for(int n : ans) System.out.println(n);
    }

    public static void dfs(int y, int x) {
        visit[y][x] = true;

        for(int i=0;i<4;i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny >=0 && nx >= 0 && ny < N && nx < N && !visit[ny][nx] && arr[ny][nx] == '1') {
                ans2++;
                dfs(y+dy[i], x+dx[i]);
            }
        }
    }
}
