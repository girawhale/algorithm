package 다시보기.DFS;

import java.util.*;

public class prog43164_여행경로 {
    List<String> route;

    public String[] solution(String[][] tickets) {
        route = new ArrayList<>();

        Arrays.sort(tickets, Comparator.comparing(t -> t[0]));
        dfs("ICN", tickets, new boolean[tickets.length]);

        System.out.println(route);
        return route.toArray(String[]::new);
    }

    boolean dfs(String cur, String[][] tickets, boolean[] visit) {
        route.add(cur);
        if (route.size() == tickets.length) {
            return true;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(cur) && !visit[i]) {
                visit[i] = true;
                if (dfs(tickets[i][1], tickets, visit)) return true;
                visit[i] = false;
            }
        }

        route.remove(route.size() - 1);
        return false;
    }
}
