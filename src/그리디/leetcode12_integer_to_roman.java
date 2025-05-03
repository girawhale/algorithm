package 그리디;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class leetcode12_integer_to_roman {
    public String intToRoman(int num) {
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        StringBuilder sb = new StringBuilder();
        Set<Integer> keyset = map.keySet();

        for (Integer key : keyset) {
            if (num >= key) {
                sb.append(map.get(key).repeat(num / key));
                num = num % key;
            }
        }

        return sb.toString();
    }
}