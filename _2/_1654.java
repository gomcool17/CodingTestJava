package _2;

import java.util.ArrayList;
import java.util.Scanner;

public class _1654 {
    public static int K,N;
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        N = sc.nextInt();

        for(int i=0;i<K;i++) {
            arr.add(sc.nextInt());
        }

        long start = 0L, end = 10000000000L;

        long mid = -1;
        for(int i=0;i<40;i++) {
            mid = (start + end) / 2;
            long len = f(mid);
            if(len >= N) {
                start = mid;
            }
            else end = mid;
        }
        System.out.println(start);
    }

    public static long f(long mid)
    {
        long sum = 0;
        for(int i=0;i<K;i++) {
            sum += arr.get(i) / mid;
        }
        return sum;
    }
}



