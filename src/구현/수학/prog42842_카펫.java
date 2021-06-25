package 구현.수학;

public class prog42842_카펫 {
    public int[] solution(int brown, int yellow) {
        for (int height = 1; height < yellow; height++) {
            if (yellow % height != 0) break;

            if (((height + 2) * (yellow % height)) * 2 == brown)
                return new int[]{(yellow % height) + 2, height + 2};
        }
        return null;
    }
}
