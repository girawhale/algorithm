public class prog62048_멀쩡한_사각형 {
    public long solution(int w, int h) {
        long ans = 0;
        for (int i = 0; i < w; i++)
            ans += Math.floor((double) w / h * i);

        return ans * 2;
    }
}
