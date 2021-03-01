package disjoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class prog64063_호텔_방_배정 {
    Map<Long, Long> map;

    public long[] solution(long k, long[] room_number) {
        map = new HashMap<>();
        List<Long> ans = new ArrayList<>();

        for (long num : room_number)
            ans.add(find(num));

        return ans.stream().mapToLong(l -> l).toArray();
    }

    long find(long n) {
        long room = n;
        if (map.containsKey(room))
            room = find(map.get(room));

        map.put(n, room + 1);
        return room;
    }
}
