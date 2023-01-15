package _2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _2230 {
    public static int N,M;
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for(int i=0;i<N;i++) {
            arr.add(sc.nextInt());
        }
        Collections.sort(arr);

        long result = 2000000000L;
        for(int i=0;i<N;i++) {
            int n = lowerBound(i, N-1, arr.get(i) + M);
            if(arr.get(n) - arr.get(i) >= M)
                result = Math.min(result, arr.get(n) - arr.get(i));
        }

        System.out.println(result);
    }

    public static int upperBound(int front, int rear, int key) {
        int mid;
        while(front<rear) {
            mid = (front + rear) / 2;
            if(arr.get(mid) <= key) front = mid + 1;
            else rear = mid;
        }
        return rear;
    }

    public static int lowerBound(int front, int rear, int key) {
        int mid;
        while(front<rear) {
            mid = (front + rear) / 2;
            if(arr.get(mid) < key) front = mid + 1;
            else rear = mid;
        }
        return rear;
    }
}
