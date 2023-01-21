package _3_그래프;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1012_유기농배추 {
    public static int M,N;
    public static int[][] arr = new int[51][51];
    public static boolean[][] visit = new boolean[51][51];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T > 0) {
            T--;
            for(int i=0;i<N;i++) {
                Arrays.fill(arr[i], 0);
                Arrays.fill(visit[i], false);
            }
            M = sc.nextInt();
            N = sc.nextInt();
            int K = sc.nextInt();

            for(int i = 0;i<K;i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                arr[b][a] = 1;
            }

            int result = 0;
            for(int i=0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    if(arr[i][j] == 1 && !visit[i][j]) {
                        bfs(i,j);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }
    public static void bfs(int y, int x) {
        Queue<Integer> qy = new LinkedList<>();
        Queue<Integer> qx = new LinkedList<>();

        int dy[] = {0,0,1,-1};
        int dx[] = {1,-1,0,0};

        qy.add(y);
        qx.add(x);

        while(!qy.isEmpty()) {
            int ny = qy.peek();
            int nx = qx.peek();
            qy.poll();
            qx.poll();

            for(int i=0;i<4;i++) {
                int nextY = ny + dy[i];
                int nextX = nx + dx[i];
                if(nextX >= 0 && nextY >= 0 && nextX < M && nextY < N && arr[nextY][nextX] == 1 && !visit[nextY][nextX]) {
                    visit[nextY][nextX] = true;
                    qy.add(nextY);
                    qx.add(nextX);
                }
            }
        }
    }
}
