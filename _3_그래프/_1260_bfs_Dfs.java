package _3_그래프;

import java.util.*;

public class _1260_bfs_Dfs {
    public static int N,M,start;
    public static ArrayList<Integer>[] g = new ArrayList[10001];
    public static boolean[] visitD = new boolean[1001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<1001;i++) g[i] = new ArrayList<>();

        N = sc.nextInt();
        M = sc.nextInt();
        start = sc.nextInt();
        for(int i=0;i<M;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            g[a].add(b);
            g[b].add(a);
        }

        for(int i=1;i<=N;i++) {
            Collections.sort(g[i]);
        }
        visitD[start] = true;
        dfs(start);
        System.out.println();
        bfs(start);
    }

    public static void dfs(int num) {

        System.out.print(num + " ");

        for(int next : g[num]) {
            if(visitD[next]) continue;
            visitD[next] = true;
            dfs(next);
        }
    }

    public static void bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[1001];
        visit[num] = true;
        q.add(num);

        while(!q.isEmpty()) {
            int now = q.peek();
            q.poll();
            System.out.print(now + " ");

            for(int next : g[now]) {
                if(visit[next]) continue;;
                visit[next] = true;
                q.add(next);
            }
        }

    }
}
