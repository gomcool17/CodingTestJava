package _3_๊ทธ๋ํ;

import java.util.ArrayList;
import java.util.Scanner;

public class _11724 {
    public static int N,M;
    public static ArrayList<Integer>[] arr;
    public static boolean visit[] = new boolean[1001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new ArrayList[1001];
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

        int result = 0;
        for(int i=1;i<=N;i++)
        {
            if(!visit[i]) {
                result++;
                dfs(i);
            }
        }
        System.out.println(result);
    }

    public static void dfs(int u) {
        for(int num : arr[u]) {
            if(visit[num]) continue;
            else {
                visit[num] = true;
                dfs(num);
            }
        }
    }
}
