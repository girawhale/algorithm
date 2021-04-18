package 자료구조.Trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj5052_전화번호_목록 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Trie root = new Trie();

            String[] phones = new String[n];
            for (int i = 0; i < n; i++)
                phones[i] = br.readLine();

            boolean check = false;
            Arrays.sort(phones);
            for (String phone : phones) {
                if (!root.insert(phone)) {
                    check = true;
                    break;
                }
            }
            System.out.println(check ? "NO" : "YES");
        }
    }

    static class Trie {
        Trie[] child;
        boolean isEnd;

        public Trie() {
            this.child = new Trie[10];
        }

        public boolean insert(String phone) {
            Trie node = this;

            for (int i = 0; i < phone.length(); i++) {
                int idx = phone.charAt(i) - '0';
                if (node.child[idx] == null)
                    node.child[idx] = new Trie();
                node = node.child[idx];

                if (node.isEnd) return false;
            }

            return node.isEnd = true;
        }
    }
}
