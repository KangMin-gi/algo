package algo.hashlevel1.hash1;

import java.util.HashMap;
import java.util.Map;
// 마라톤 참가

public class Solution {

  public static String solution(String[] participant, String[] completion) {
    Map<Integer, String> hashMap = new HashMap<>();
    int partiHash = 0;
    int completionHash = 0;
    for (String s : participant) {
      int hashCode = s.hashCode();
      partiHash += hashCode;
      hashMap.put(hashCode, s);
    }

    for (String s : completion) {
      int hashCode = s.hashCode();
      completionHash += hashCode;
    }

    return hashMap.get(partiHash - completionHash);
  }
}
