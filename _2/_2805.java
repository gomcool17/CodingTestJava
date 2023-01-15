package _2;

import java.util.ArrayList;
import java.util.Scanner;

public class _2805 {
    public static int N;
    public static int M;
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        for(int i=0;i<N;i++) {
            arr.add(sc.nextInt());
        }

        long start = 0L, end = 1000000000L;

        long result = 0;
        for(int i=0;i<40;i++) {
            long mid = (start + end) / 2;
            long len = f(mid);

            if(len >= M) {
                result = mid;
                start = mid;
            }
            else end = mid;
        }
        System.out.println(result);
    }

    public static long f(long h) {
        long sum = 0;
        for(int i=0;i<arr.size();i++) {
            if(arr.get(i) >= h) {
                sum += (arr.get(i) - h);
            }
        }

        return sum;
    }
}
