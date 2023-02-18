package _5_유니온파인드;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class _4386_별자리만들기 {
    static int N;
    static int[] P = new int[101];
    static ArrayList<Edge> arr = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        ArrayList<Lo> lo = new ArrayList<>();
        for(int i=1;i<=N;i++) P[i] = i;
        for(int i=0;i<N;i++) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            lo.add(new Lo(x,y));
        }

        for(int i=0;i<N;i++) {
            for(int j=i+1;j<N;j++) {
                int u = i + 1;
                int v = j + 1;
                double W = (lo.get(i).X - lo.get(j).X) * (lo.get(i).X - lo.get(j).X) + (lo.get(i).Y - lo.get(j).Y) * (lo.get(i).Y - lo.get(j).Y);
                double w = Math.sqrt(W);
                arr.add(new Edge(u,v,w));
            }
        }

        Collections.sort(arr, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
               if(Double.compare(o1.W, o2.W) >= 0) return 1;
               else return -1;
            }
        });

        double result = 0;
        for(int i=0;i<arr.size();i++) {
            int u = arr.get(i).U;
            int v = arr.get(i).V;

            if(find(u) != find(v)) {
                union(u,v);
                result += arr.get(i).W;
            }
        }
        System.out.println(String.format("%.2f",result));
    }
    public static int find(int n) {
        if(P[n] == n) return n;
        return P[n] = find(P[n]);
    }

    public static void union(int n1, int n2) {
        if(n1 > n2) {
            int tmp = n1;
            n1 = n2;
            tmp = n1;
        }
        n1 = find(n1);
        n2 = find(n2);

        P[n1] = n2;
    }

    public static class Edge {
        public int U,V;
        public double W;

        public Edge(int u, int v, double w) {
            this.U = u;
            this.V = v;
            this.W = w;
        }
    }

    public static class Lo {
        public double X,Y;
        public Lo(double X, double Y) {
            this.X = X;
            this.Y = Y;
        }
    }
}
