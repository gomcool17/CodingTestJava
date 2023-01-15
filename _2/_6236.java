package _2;

import java.util.ArrayList;
import java.util.Scanner;

public class _6236 {
    public static int N,M;
    public static ArrayList<Long> arr = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for(int i=0;i<N;i++) {
            arr.add(sc.nextLong());
        }

        long start = 0L, end = 1000000000L;
        for(int i=0;i<40;i++) {
            long mid = (start + end) / 2;
            System.out.println(mid);
            int re = f(mid);

            if(re == -1 || re > M) start = mid;
            else end = mid;
        }
        System.out.println(end);
    }

    public static int f(long mid) {
        int cnt = 1;
        long money = mid;

        for(int i=0;i<N;i++) {
            if(arr.get(i) > mid) return -1;
            if(N - i == M - cnt) {
                cnt++;
                continue;
            }

            if(arr.get(i) <= money) {
                money -= arr.get(i);
            }
            else {
                money = mid;
                money -= arr.get(i);
                cnt++;
            }
        }

        return cnt;
    }
}
