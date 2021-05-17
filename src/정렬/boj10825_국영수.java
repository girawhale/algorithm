package 정렬;

import java.util.*;
import java.util.stream.IntStream;

public class boj10825_국영수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        IntStream.range(0, N)
                .mapToObj(i -> new Student(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()))
                .sorted(Comparator.<Student, Integer>comparing(s -> s.kor, Comparator.reverseOrder())
                        .thenComparing(s -> s.eng)
                        .thenComparing(s -> s.math, Comparator.reverseOrder())
                        .thenComparing(s -> s.name)
                )
                .forEach(s -> System.out.println(s.name));
    }

    static class Student {
        String name;
        int kor, eng, math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
    }
}
