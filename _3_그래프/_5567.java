package _3_그래프;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _5567 {
    public static int N, M;
    public static ArrayList<Integer> arr[] = new ArrayList[501];
    public static boolean visit[] = new boolean[501];
    public static int re;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<501;i++) {
            arr[i] = new ArrayList<>();
        }

        N = sc.nextInt();
        M = sc.nextInt();
        for(int i=0;i<M;i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            arr[u].add(v);
            arr[v].add(u);
        }
        visit[1] = true;
        for(int num : arr[1]) {
            dfs(num, 1);
        }
        System.out.println(re);
    }

    public static void dfs(int num, int cnt) {
        if(!visit[num]) re++;
        visit[num] = true;
        if(cnt == 2) {
            return;
        }
        for(int n : arr[num]) {
            if(visit[n]) continue;
            //re++;
            dfs(n, cnt+1);
        }
    }
}
