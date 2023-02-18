package _5_유니온파인드;

import java.util.Scanner;

public class _1717_집합의표현 {
    static  int N,M;
    static int[] P = new int[1000001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        for(int i=1;i<=N;i++) P[i] = i;
        for(int i=0;i<M;i++) {
            int w,a,b;
            w = sc.nextInt();
            a = sc.nextInt();
            b = sc.nextInt();

            if(w == 0) {
                union(a,b);
            }
            else {
                if(find(a) == find(b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    public static int find(int n)
    {
        if(P[n] == n) return n;
        return P[n] = find(P[n]);
    }

    public static void union(int a, int b)
    {
        a = find(a);
        b = find(b);
        P[a] = b;
    }
}
