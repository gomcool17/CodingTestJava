package 모르고리즘._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _2751 {
    public static void main(String[] args) throws IOException {
       // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<N;i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(arr);
        for(int v : arr) {
            sb.append(v).append('\n');
        }
        System.out.println(sb);
    }
}
