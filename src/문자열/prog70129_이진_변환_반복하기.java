package 문자열;

public class prog70129_이진_변환_반복하기 {
    public int[] solution(String s) {
        int cnt = 0, zero = 0;

        while (!s.equals("1")) {
            int sZero = (int) s.chars().filter(c -> c == '0').count();
            s = Integer.toBinaryString(s.length() - sZero);

            zero += sZero;
            cnt++;
        }

        return new int[]{cnt, zero};
    }
}
