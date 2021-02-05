package DP;

import java.util.Arrays;

public class prog72414_광고_삽입 {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = timeToSecond(play_time), advTime = timeToSecond(adv_time);

        int[] playCnt = new int[playTime + 1];
        for (String log : logs) {
            String[] split = log.split("-");
            playCnt[timeToSecond(split[0])]++;
            playCnt[timeToSecond(split[1])]--;
        }

        for (int i = 1; i <= playTime; i++) playCnt[i] += playCnt[i - 1];
        for (int i = 1; i <= playTime; i++) playCnt[i] += playCnt[i - 1];


        int maxTime = playCnt[advTime - 1], maxStartTime = 0;
        for (int i = 0; i < playTime; i++) {
            int tmp = playCnt[i + advTime] - playCnt[i];

            if (tmp > maxTime) {
                maxTime = tmp;
                maxStartTime = i + 1;
            }
        }

        return String.format("%02d:%02d:%02d", maxStartTime / (60 * 60), (maxStartTime / 60) % 60, maxStartTime % 60);
    }

    int timeToSecond(String str) {
        int[] parse = Arrays.stream(str.split(":")).mapToInt(Integer::parseInt).toArray();
        return parse[0] * 60 * 60 + parse[1] * 60 + parse[2];
    }
}