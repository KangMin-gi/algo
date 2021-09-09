package algo.greedy;

import java.util.*;
import java.util.stream.Collectors;
import sort.ArrayUtil;

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int n = 3;
    int[] ary1 = {3};
    int[] ary2 = {1,0,3,0,0,0,0};
    int jaz = solution.solution("012");
    System.out.println("jaz = " + jaz);

    List<Integer> tl = new ArrayList<>();
    tl.add(0);
    tl.add(1);
    tl.add(2);

    int right = solution.getRight(ary2, 0);
    System.out.println("right = " + right);

    // [0, 1, 2, 3, 4]
  }

  public int solution(String name) {
    int totalCount = 0;
    int[] moveAry = new int[name.length()];
    for (int i = 0 ; i < name.length(); ++i) {
      int now = 'A';
      int next = name.charAt(i);
      if (next == now) {
        continue;
      }
      int alphaCnt = Math.min(Math.abs(now - next), Math.abs(now + 26 - next));
      moveAry[i] = alphaCnt;
    }

    return 0;
  }

  public int getRight(int[] moveAry, int startIdx) {
    int totalCount = 0 ;
    int remainZeroCount = 0;
    for ( int i = startIdx; i < moveAry.length; ++i) {
      if (moveAry[i] != 0) {
        totalCount += moveAry[i];
        remainZeroCount = 0;
      } else {
        remainZeroCount++;
      }
      totalCount++;
    }
    System.out.println("totalCount = " + totalCount);
    remainZeroCount++; //맨 마지막 처리
    return totalCount - remainZeroCount;
  }


}
