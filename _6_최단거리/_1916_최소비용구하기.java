package _6_최단거리;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1916_최소비용구하기 {
    public static int N,M;
    public static int[] dist = new int[1001];
    public static int INF = 987654321;
    public static ArrayList<Node>[] nodes = new ArrayList[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int i=0;i<1001;i++) nodes[i] = new ArrayList<>();
        Arrays.fill(dist, INF);

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            nodes[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start);

        System.out.println(dist[end]);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[N + 1];

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.peek();
            pq.poll();
            if(check[node.EndNum]) continue;
            check[node.EndNum] = true;

           for(Node next : nodes[node.EndNum]) {
               if(dist[next.EndNum] > dist[node.EndNum] + next.Cost) {
                   dist[next.EndNum] = dist[node.EndNum] + next.Cost;
                   pq.add(new Node(next.EndNum, dist[next.EndNum]));
               }
           }
        }
    }
    static public class Node implements Comparable<Node>{
        int EndNum;
        int Cost;

        public Node(int endNum, int cost) {
            this.EndNum = endNum;
            this.Cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.Cost - o.Cost;
        }
    }
}
