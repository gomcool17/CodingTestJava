package _5_유니온파인드;

import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class _1647_도시분할계획 {
    static  int N,M;
    static int[] P = new int[1000001];
    static ArrayList<Edge> arr = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        for(int i=1;i<=N;i++) P[i] = i;

        for(int i=0;i<M;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            arr.add(new Edge(a,b,c));
        }

        Collections.sort(arr, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.W - o2.W;
            }
        });

        int result = 0;
        int m = 0;
        for(int i=0;i<M;i++) {
            int u = arr.get(i).U;
            int v = arr.get(i).V;
            System.out.println(u + " " + v + " " + arr.get(i).W);
            if(find(arr.get(i).U) != find(arr.get(i).V)) {
                union(u,v);
                result += arr.get(i).W;
                m = arr.get(i).W;
                System.out.println("good");
            }
        }
        System.out.println(result - m);
    }

    public static int find(int n)
    {
        if(P[n] == n) return n;
        return P[n] = find(P[n]);
    }

    public static void union(int n1, int n2)
    {
        n1 = find(n1);
        n2 = find(n2);

        P[n1] = P[n2];
    }

    public static class Edge {
        public int U,V,W;
        public Edge(int A, int B, int C) {
            this.U = A;
            this.V = B;
            this.W = C;
        }
    }
}
