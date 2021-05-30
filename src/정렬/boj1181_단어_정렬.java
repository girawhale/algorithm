package 정렬;

import java.util.*;

public class boj1181_단어_정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        TreeSet<String> set = new TreeSet<>(Comparator.comparingInt(String::length).thenComparing(String::compareTo));

        while (N-- > 0) set.add(sc.next());
        set.forEach(System.out::println);
    }
}
