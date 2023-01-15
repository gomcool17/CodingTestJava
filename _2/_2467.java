package _2;

import java.util.ArrayList;
import java.util.Scanner;

public class _2467 {
    public static int N;
    public static ArrayList<Long> arr = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i=0;i<N;i++) {
            arr.add(sc.nextLong());
        }

        long result = Integer.MAX_VALUE;;
        long f = -1, s = -1;
        int p1 = 0, p2 = N - 1;

        while(p1 < p2) {
            long sum = Math.abs(arr.get(p1) + arr.get(p2));
            if(sum < result) {
                result = Math.abs(arr.get(p1) + arr.get(p2));
                f = arr.get(p1);
                s = arr.get(p2);
            }

            if(sum == 0) break;
            if(arr.get(p1) + arr.get(p2) > 0) p2--;
            else p1++;
        }
        System.out.println(f + " " + s);
    }
}
