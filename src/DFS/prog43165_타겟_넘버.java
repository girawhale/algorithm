package DFS;

public class prog43165_타겟_넘버 {
    public int solution(int[] numbers, int target) {
        return dfs(0, numbers, 0, target);
    }

    int dfs(int idx, int[] numbers, int ret, int target) {
        if (idx == numbers.length) {
            return ret == target ? 1 : 0;
        }
        return dfs(idx + 1, numbers, ret + numbers[idx], target) + dfs(idx + 1, numbers, ret - numbers[idx], target);
    }
}
