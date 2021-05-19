package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class dbb1527_정렬된_배열에서_특정_수의_개수_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int cnt = upperBound(arr, M, 0, N) - lowerBound(arr, M, 0, N);

        System.out.println(cnt == 0 ? -1 : cnt);
    }

    public static int upperBound(int[] arr, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;

            if (arr[mid] <= target) start = mid + 1;
            else end = mid;
        }

        System.out.println(end);
        return end;
    }


    public static int lowerBound(int[] arr, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;

            if (arr[mid] < target) start = mid + 1;
            else end = mid;
        }

        System.out.println(end);
        return end;
    }
}
