package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class boj21276_계보_복원가_호석 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] name = br.readLine().split(" ");
        Arrays.sort(name);

        Map<String, Integer> nameMap = new HashMap<>();
        IntStream.range(0, N).forEach(i -> nameMap.put(name[i], i));

        List<String>[] children = new ArrayList[N];
        List<Integer>[] adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
            children[i] = new ArrayList<>();
        }

        int[] inDegree = new int[N];
        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            String[] info = br.readLine().split(" ");
            int info1 = nameMap.get(info[0]), info2 = nameMap.get(info[1]);

            adj[info2].add(info1);
            inDegree[info1]++;
        }


        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++)
            if (inDegree[i] == 0) queue.add(i);

        System.out.println(queue.size());
        queue.forEach(n -> System.out.print(name[n] + " "));
        System.out.println();

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int a : adj[cur]) {
                if (--inDegree[a] == 0) {
                    queue.add(a);
                    children[cur].add(name[a]);
                }
            }
        }

        IntStream.range(0, N).forEach(i -> {
            System.out.print(name[i] + " " + children[i].size());
            children[i].stream().sorted().forEach(child -> System.out.print(" " + child));
            System.out.println();
        });
    }
}
