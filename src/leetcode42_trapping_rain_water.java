public class leetcode42_trapping_rain_water {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int ret = 0;

        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }

        int right = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int rain = Math.min(left[i], right) - height[i];
            if (rain > 0) ret += rain;

            right = Math.max(right, height[i]);
        }
        return ret;
    }
}
