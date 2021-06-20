package 구현;

public class prog12985_예상_대진표 {
    public int solution(int n, int a, int b) {
        int ans = 1;

        while (a != b) {
            ans++;
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }
        return ans;
    }
}
