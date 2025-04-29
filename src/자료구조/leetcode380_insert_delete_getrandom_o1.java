package 자료구조;

import java.util.*;

public class leetcode380_insert_delete_getrandom_o1 {
    class RandomizedSet {
        Map<Integer, Integer> map;
        List<Integer> list;
        int size;
        Random rand;

        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            rand = new Random();
            size = 0;
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            map.put(val, size++);
            list.add(val);

            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }

            Integer index = map.get(val);
            Integer lastVal = list.get(size);

            map.put(lastVal, index);
            list.set(index, lastVal);

            map.remove(val);
            list.remove(--size);
            return true;
        }

        public int getRandom() {
            return list.get(rand.nextInt(size));
        }
    }

}
