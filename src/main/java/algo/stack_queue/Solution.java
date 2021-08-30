package algo.stack_queue;

import java.util.Arrays;

public class Solution {

  private final static int MAX_ARY_LEN = 100;

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] p = {100, 1, 1};
    int[] s = {1, 30 ,5};
    int[] solution1 = solution.solution(p, s);
    for (int i : solution1) {
      System.out.print(i);
      System.out.print(" ");
    }
  }

    public int[] solution ( int[] progresses, int[] speeds){
      int[] deploys = new int[MAX_ARY_LEN + 3];
      int day = -1;

      for (int i = 0; i < progresses.length; ++i) {
        int dailyProgress = progresses[i] + (speeds[i] * day);
        if (dailyProgress >= 100) {
          deploys[day]++;
        } else {
          day++;
          --i;
        }
      }
      return Arrays.stream(deploys).filter(value -> value != 0).toArray();

    }
  }
