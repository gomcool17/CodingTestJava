package _2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int nArr[] = new int[N];
        for(int i=0;i<N;i++) {
            nArr[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        Arrays.sort(nArr);
        for(int i=0;i<M;i++) {
           int m= sc.nextInt();
            if(Arrays.binarySearch(nArr, m) >= 0) System.out.println(1);
            else System.out.println(0);
        }
    }
}
