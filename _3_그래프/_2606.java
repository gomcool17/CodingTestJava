package _3_그래프;

import java.util.ArrayList;
import java.util.Scanner;

public class _2606 {
    public static int N,M;
    public static ArrayList<Integer>[] arr = new ArrayList[1001];
    public static boolean visit[] = new boolean[1001];
    public static int re = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<1001;i++) arr[i] = new ArrayList<>();
        N = sc.nextInt();
        M = sc.nextInt();
        for(int i=0;i<M;i++) {
            int u,v;
            u = sc.nextInt();
            v = sc.nextInt();
            arr[u].add(v);
            arr[v].add(u);
        }
        visit[1] = true;
        dfs(1);
        System.out.println(re);

    }

    public static void dfs(int u) {
        for(int num : arr[u]) {
            if(visit[num]) continue;
            else {
                visit[num] = true;
                re++;
                dfs(num);
            }
        }
    }
}
