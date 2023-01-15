package 모르고리즘._1;

import java.util.Arrays;
import java.util.Scanner;

public class _2750 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int arr[] = new int[N];
        for(int i=0;i<N;i++) {
            arr[i]  = scanner.nextInt();
        }
        Arrays.sort(arr);
        for(int i=0;i<N;i++) {
            System.out.println(arr[i]);
        }
    }
}
