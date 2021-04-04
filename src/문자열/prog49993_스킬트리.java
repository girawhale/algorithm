package 문자열;

public class prog49993_스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int ans = 0;
        char[] skillArr = skill.toCharArray();
        for (String skillTree : skill_trees) {
            int prev = -1;
            boolean ck = true;

            for (char ch : skillArr) {
                int idx = skillTree.indexOf(ch);

                if (idx == -1) prev = 20;
                else if (idx < prev) {
                    ck = false;
                    break;
                } else prev = idx;
            }

            if (ck) ans++;
        }

        return ans;
    }
}
