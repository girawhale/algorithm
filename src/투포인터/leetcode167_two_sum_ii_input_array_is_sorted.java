package 투포인터;

public class leetcode167_two_sum_ii_input_array_is_sorted {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;

        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                break;
            }

            if (sum < target) {
                i++;
            } else {
                j--;
            }
        }

        return new int[]{i , j};
    }
}