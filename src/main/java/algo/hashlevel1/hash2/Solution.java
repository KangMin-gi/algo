package algo.hashlevel1.hash2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
// 전화번호 목록

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.solution(new String[]{"123", "1252113214124131", "1252113214124131321"}));
  }

  public boolean solution(String[] phone_book) {
    List<String> collect = Arrays.stream(phone_book).sorted().collect(Collectors.toList());

    for (int i = 0; i < collect.size() - 1; ++i) {
      String strI = collect.get(i);
      String strJ = collect.get(i+1);
      if(strJ.startsWith(strI)) {
         return false;
      }
    }

    return true;
  }

}
