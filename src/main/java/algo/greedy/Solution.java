package algo.greedy;

import java.util.*;
import java.util.stream.Collectors;
import sort.ArrayUtil;

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int a = solution.solution("B");
    System.out.println("answer = " + a);
  }

  public int solution(String name) {
    int length = name.length();
    int totalCount= 0;
    int nowIndex = 0;
    int[] nameAry = new int[length];
    for (int i = 0 ; i < length ; ++i) {
      nameAry[i] = name.charAt(i) - 'A';
    }

    while (isEnd(nameAry)) {
      Mc now = this.getNow(nameAry, nowIndex);
      totalCount += now.totalMoveCount;
      nameAry[nowIndex] = 'A';

      Mc right = this.getRight(nameAry, nowIndex);
      Mc left = this.getLeft(nameAry, nowIndex);

      Mc update = new Mc();
      if (right.totalMoveCount < left.totalMoveCount) {
        update.totalMoveCount = right.totalMoveCount;
        update.index = right.index;
      } else {
        update.totalMoveCount = left.totalMoveCount;
        update.index = left.index;
      }

      totalCount += update.totalMoveCount;
      nameAry[update.index] = 'A';

    }

    return totalCount;

  }

  public boolean isEnd(int[] nameAry) {
    for (int i : nameAry) {
      if ( i != 'A')
        return false;
    }
    return true;
  }

  public Mc getRight(int[] nameAry, int nowIndex) {
    int maxMoveCnt = nameAry.length / 2;
    Mc mc = new Mc();
    for(int move = 1; move <= maxMoveCnt ; ++move) {
      int index = (nowIndex + move) % nameAry.length;
      if (nameAry[index] == 'A')
        continue;
      mc.totalMoveCount = toA(nameAry[index]) + move;
      mc.index = index;
      return mc;
    }
    return Mc.max();
  }

  public Mc getLeft(int[] nameAry, int nowIndex) {
    int maxMoveCnt = nameAry.length / 2;
    Mc mc = new Mc();
    for(int move = 1; move <= maxMoveCnt ; ++move) {
      int index = (nowIndex + nameAry.length - move) % nameAry.length;
      if (nameAry[index] == 'A')
        continue;
      mc.totalMoveCount = toA(nameAry[index]) + move;
      mc.index = index;
      return mc;
    }
    return Mc.max();
  }

  public Mc getNow(int[] nameAry, int nowIndex) {
    Mc mc = new Mc();
    mc.index = nowIndex;
    mc.totalMoveCount = toA(nameAry[nowIndex]);
    return mc;
  }

  public int toA(int alpha) {
    return Math.min(alpha - 'A', Math.abs('a' - alpha));
  }

  public static class Mc {
    int totalMoveCount;
    int index;

    public static Mc max() {
      Mc mc = new Mc();
      mc.index = -1;
      mc.totalMoveCount = Integer.MAX_VALUE;
      return mc;
    }
  }


}
