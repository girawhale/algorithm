package 자료구조.Set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class prog42577_전화번호_목록 {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>(Arrays.asList(phone_book));

        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++)
                if (set.contains(phone.substring(0, i))) return false;
        }

        return true;
    }
}
