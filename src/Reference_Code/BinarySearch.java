package Reference_Code;

public class BinarySearch {
    public int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] <= target) start = mid + 1;
            else end = mid - 1;
        }

        return end;
    }


    public int upperBound(int[] arr, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;

            if (arr[mid] <= target) start = mid + 1;
            else end = mid;
        }

        return end;
    }


    public int lowerBound(int[] arr, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;

            if (arr[mid] < target) start = mid + 1;
            else end = mid;
        }

        return end;
    }

}
