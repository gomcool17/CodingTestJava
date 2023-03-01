package _6_최단거리;

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;

public class _1753_최단경로 {
    static int V,E,start;
    static ArrayList<Pair>[] arr = new ArrayList[20001];
    static int[] dist = new int[20001];
    static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Arrays.fill(dist, INF);
        for(int i=0;i<20001;i++) arr[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        V = parseInt(st.nextToken());
        E = parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        for(int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arr[u].add(new Pair(v,w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] check = new boolean[V + 1];
        pq.add(new Pair(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Pair p = pq.peek();
            pq.poll();

            if(check[p.v]) continue;
            check[p.v] = true;

            for(Pair node : arr[p.v]) {
                int nextV = node.v;
                int cost = node.w;
                if(dist[nextV] > dist[p.v] + cost) {
                    dist[nextV] = dist[p.v] + cost;
                    pq.add(new Pair(nextV, dist[nextV]));
                }
            }
        }

        for(int i=1;i<=V; i++) {
            if(dist[i] == INF) sb.append("INF");
            else sb.append(dist[i]);
            sb.append('\n');
        }


        bw.write(sb.toString());
        bw.close();
        br.close();

    }

    public static class Pair implements Comparable<Pair>{
        public int v;
        public int w;
        public Pair(int first, int second) {
            this.v = first;
            this.w = second;
        }

        @Override
        public int compareTo(Pair o) {
            return w - o.w;
        }
    }
}
