package 모르고리즘._1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class _9012 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        for(int i=0;i<N;i++) {
            String s = in.next();
            Stack<Character> st = new Stack<>();
            boolean f = true;
            for(int j=0;j<s.length();j++) {

                if(s.charAt(j) == '(') {
                    st.push('(');
                }
                else {
                    if(st.empty()) {
                        System.out.println("NO");
                        f = false;
                        break;
                    }
                    st.pop();
                }
            }
            if(!st.empty()) {
                System.out.println("NO");
                continue;
            }
            if(f) {
                System.out.println("YES");
            }
        }

    }
}
