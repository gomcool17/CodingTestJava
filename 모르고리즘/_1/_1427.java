package 모르고리즘._1;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _1427 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String s = scanner.nextLine();
        s = Stream.of(s.split(""))
                .sorted()
                .collect(Collectors.joining());
        for(int i=s.length()-1;i>= 0; i--) {
            sb.append(s.charAt(i));
        }
        System.out.println(sb);
    }
}
