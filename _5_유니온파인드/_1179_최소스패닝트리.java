package _5_유니온파인드;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class _1179_최소스패닝트리 {
    static  int V,E;
    static int[] P = new int[10001];
    static ArrayList<Edge> arr = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        for(int i=1;i<=V;i++) P[i] = i;

        for(int i=0;i<E;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            arr.add(new Edge(a,b,c));
        }

        Collections.sort(arr, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.C - o2.C;
            }
        });

        int result = 0;
        for(int i=0;i<E;i++) {
            int u = arr.get(i).A;
            int v = arr.get(i).B;
            if(find(u) != find(v))
            {
                union(u,v);
                result += arr.get(i).C;
            }
        }

        System.out.println(result);
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
        public int A,B,C;
        public Edge(int A, int B, int C) {
            this.A = A;
            this.B = B;
            this.C = C;
        }
    }
}
