package 투포인터;

public class leetcode88_merge_sorted_array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;

        int point1 = m - 1;
        int point2 = n - 1;

        for (int i = len - 1; i >= 0; i--) {
            if (point2 < 0 || (point1 >= 0 && nums1[point1] > nums2[point2])) {
                nums1[i] = nums1[point1--];
            } else {
                nums1[i] = nums2[point2--];
            }
        }
    }
}
