package 모르고리즘._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayList<Pair> arr = new ArrayList<>();
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            String second = st.nextToken();
            arr.add(new Pair(first, second));
        }

        Collections.sort(arr);
        for(Pair p : arr) {
            sb.append(p.getFirst()).append(' ').append(p.getSecond()).append('\n');
        }
        System.out.println(sb);
    }

    static class Pair implements Comparable<Pair>{
        int first;
        String second;

        public Pair(int first, String second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return this.first;
        }

        public String getSecond() {
            return this.second;
        }

        @Override
        public int compareTo(Pair o) {
//            if(this.first == o.getFirst()) {
//                if(o.getSecond().compareTo(this.second) == 1) return 1;
//                else if(this.second.compareTo(o.getSecond()) == 0) return 0;
//                else return -1;
//            }

            return this.first - o.getFirst();
        }
    }
}
