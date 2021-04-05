package 구현.GCD;

public class prog12953_N개의_최소공배수 {
    public int solution(int[] arr) {
        int n = arr[0];
        for (int a : arr)
            n *= a / gcd(n, a);

        return n;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
