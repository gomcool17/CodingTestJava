package _3_그래프;

import java.util.*;

public class _1389_케빈베이컨 {
    public static int N,M;
    public static ArrayList<Integer>[] g = new ArrayList[101];
    public static boolean[] visit = new boolean[101];
    public static int[][] kevin = new int[101][101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        for(int i=0;i<101;i++) g[i] = new ArrayList<>();

        for(int i=0;i<M;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            g[a].add(b);
            g[b].add(a);
        }
        int result = 1010101010;
        int num = 0;
        for(int i=1;i<=N;i++) {
            int n = bfs(i);
            if(result > n) {
                result = n;
                num = i;
            }
        }
        System.out.println(num);
    }

    public static int bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        int[] cnt = new int[101];
        boolean[] visit = new boolean[101];
        Arrays.fill(cnt, 0);
        Arrays.fill(visit, false);
        int result = 0;

        q.add(num);
        visit[num] = true;
        while(!q.isEmpty()) {
            int now = q.peek();
            q.poll();

            for(int next : g[now]) {
                if(visit[next]) continue;
                visit[next] = true;

                cnt[next] = cnt[now] + 1;
                result += cnt[next];
                q.add(next);
            }
        }
        return result;
    }
}
