package 자료구조.Trie;

import java.util.Arrays;

public class prog42577_전화번호_목록 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        Trie root = new Trie();
        for (String phone : phone_book) {
            if (!root.insert(phone)) return false;
        }
        return true;
    }

    class Trie {
        Trie[] child = new Trie[10];
        boolean isEnd;

        boolean insert(String str) {
            int idx = 0;

            Trie trie = this;
            while (idx < str.length()) {
                if (trie.isEnd) return false;

                int num = str.charAt(idx++) - '0';
                if (trie.child[num] == null) trie.child[num] = new Trie();
                trie = trie.child[num];
            }

            trie.isEnd = true;
            return true;
        }
    }
}
