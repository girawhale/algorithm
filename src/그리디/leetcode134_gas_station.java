package 그리디;

public class leetcode134_gas_station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int idx = 0;
        int sum = 0;
        int remain = 0;

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            sum += diff;
            remain += diff;

            if (remain < 0) {
                idx = i + 1;
                remain = 0;
            }
        }

        return sum < 0 ? -1 : idx;
    }
}