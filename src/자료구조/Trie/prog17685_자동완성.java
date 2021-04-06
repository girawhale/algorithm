package 자료구조.Trie;

public class prog17685_자동완성 {
    Trie root = new Trie();

    public int solution(String[] words) {
        for (String word : words)
            root.insert(word);

        int ans = 0;
        for (String word : words) ans += root.find(word);

        return ans;
    }

    class Trie {
        int cnt;
        Trie[] child;

        public Trie() {
            this.child = new Trie[26];
        }

        public void insert(String str) {
            Trie node = root;

            for (char ch : str.toCharArray()) {
                int idx = ch - 'a';
                if (node.child[idx] == null) node.child[idx] = new Trie();

                node = node.child[idx];
                node.cnt++;
            }
        }

        public int find(String str) {
            Trie node = root;

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (node.child[ch - 'a'].cnt == 1) return i + 1;

                node = node.child[ch - 'a'];
            }
            return str.length();
        }
    }
}
