package _6_최단거리;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14940_쉬운최단거리 {
    private static int n,m, ey, ex;
    private static int[][] arr = new int[1001][1001];
    private static int[][] re = new  int[1001][1001];
    private static boolean[][] visit = new boolean[1001][1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    ey = i;
                    ex = j;
                }
            }
        }

        bfs(ey, ex);

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(re[i][j] == 0 && arr[i][j] == 1) sb.append("-1 ");
                else sb.append(re[i][j]).append(' ');
            }
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static public void bfs(int y, int x) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(y, x));
        int[] dy = {-1,1,0,0};
        int[] dx = {0,0,-1,1};

        while(!q.isEmpty()) {
            Pair p = q.peek();
            q.poll();

            for(int i=0;i<4;i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if(ny >= 0 && nx >= 0 && ny < n && nx < m && !visit[ny][nx] && arr[ny][nx] == 1) {
                    visit[ny][nx] = true;
                    q.offer(new Pair(ny,nx));
                    re[ny][nx] = re[p.y][p.x] + 1;
                }
            }
        }
    }

    static public class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
