package _2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _2512 {
    public static int N, M;
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int sum = 0;
        for(int i=0;i<N;i++) {
            arr.add(sc.nextInt());
            sum += arr.get(i);
        }
        Collections.sort(arr, (a1, a2) -> {
            if(a1 < a2) return 1;
            else return -1;
        });
        M = sc.nextInt();

        long start = 0L, end = 10000000000L;

        for (int i = 0; i < 40; i++) {
            long mid = (start + end) / 2;

            if (M < f(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if(sum <= M) System.out.println(arr.get(0));
        else System.out.println(start);
    }

    public static long f(long mid) {
        long sum = 0;

        for(int i=0;i<N;i++) {
            if (mid < arr.get(i))
                sum += mid;
            else
                sum += arr.get(i);
        }

        return sum;
    }
}
