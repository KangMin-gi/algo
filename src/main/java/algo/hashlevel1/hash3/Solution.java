package algo.hashlevel1.hash3;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public static void main(String[] args) {
    String[][] clo = new String[][] {{"yellowhat", "1"}, {"bluesunglasses", "1"}, {"green_turban", "1"}};
    System.out.println(solution(clo));
  }

  public static int solution(String[][] clothes) {
    Map<String, Integer> hashMap = new HashMap<>();

    for (String[] cloth : clothes) {
      hashMap.put(cloth[1], hashMap.getOrDefault(cloth[1], 0) + 1);
    }
    int totalSize = 1;
    for (Integer value : hashMap.values()) {
      totalSize *= (value+1);
    }
    return (totalSize)  - 1;
  }

}
