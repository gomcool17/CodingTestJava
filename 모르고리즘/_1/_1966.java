package 모르고리즘._1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1966 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        while(T != 0) {
            T--;
            int N = in.nextInt();
            int M = in.nextInt();
            int arr[] = new int[10];
            Queue<Pair> q = new LinkedList<>();

            for(int i=0;i<N;i++) {
                int n = in.nextInt();
                q.add(new Pair(n, i));
                arr[n]++;
            }

            int result = 0;

            for(int i=9;i>=1;i--) {
                while (arr[i] != 0) {
                    int f = q.peek().getFirst();
                    int s = q.peek().getSecond();
                    q.poll();
                    if(f != i) {
                        q.add(new Pair(f,s));
                    }
                    else {
                        arr[i]--;
                        result++;
                        if(s == M) {
                            System.out.println(result);
                            break;
                        }
                    }

                }
            }
        }

    }

    static  class Pair {
        private int first;
        private int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public  int getSecond() {
            return second;
        }
    }
}
