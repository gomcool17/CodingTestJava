package 모르고리즘._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayList<Pair> arr = new ArrayList<>();
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            arr.add(new Pair(first, second));
        }

        Collections.sort(arr);

        for(int i=0;i<N;i++) {
            System.out.println(arr.get(i).getFirst() + " " + arr.get(i).getSecond());
        }
    }

    static class Pair implements Comparable<Pair> {
        private int first;
        private int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.first == o.getFirst())
                return this.second - o.getSecond();
            return this.first - o.getFirst();
        }
    }
}
