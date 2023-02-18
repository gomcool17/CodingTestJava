package _5_유니온파인드;

import java.util.Scanner;

public class _1976_여행가자 {
    static int N,M;
    static int[] P = new int[201];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        for(int i=1;i<=N;i++) P[i] = i;

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                int n = sc.nextInt();
                if(n==1) union(i,j);
            }
        }

        int start = sc.nextInt();
        boolean can = true;
        for(int i=1;i<M;i++) {
            int end = sc.nextInt();
            if(find(start) != find(end)) {
                can = false;
                break;
            }
            start = end;
        }

        if(can) System.out.println("YES");
        else System.out.println("NO");
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
        P[n1] = n2;
    }
}
