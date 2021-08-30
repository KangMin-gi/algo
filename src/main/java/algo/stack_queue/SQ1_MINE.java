package algo.stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SQ1_MINE {

  private final static int MAX_ARY_LEN = 100;

  public static void main(String[] args) {
    int[] progresses = {90, 30, 55};
    int[] speeds = {1, 30, 5};
    System.out.println("-------------");
    int[] sol = sol(progresses, speeds);
    for (int i : sol) {
      System.out.print(i);
      System.out.print(" ");
    }

  }

  public static int[] sol(int[] progressesAry, int[] speedsAry) {
    Deque<Integer> progresses = getDeque(progressesAry);
    Deque<Integer> speeds = getDeque(speedsAry);
    Deque<Integer> deploys = new ArrayDeque<>();
    int day = 0;
    int countByDay = 0;

    while (!progresses.isEmpty()) {
      int progress = progresses.peek();
      int speed = speeds.peek();

      if (progress + (speed * day) >= 100) {
        ++countByDay;
        progresses.remove();
        speeds.remove();
        continue;
      }

      ++day;

      if (countByDay != 0) {
        deploys.add(countByDay);
        countByDay = 0;
      }
    }

    int[] ret = new int[deploys.size()];
    int i = 0;
    for (Integer deploy : deploys) {
      ret[i++] = deploy;
    }
    return ret;
  }

  private static Deque<Integer> getDeque(int[] ary) {
    Deque<Integer> deque = new ArrayDeque<>();
    for (int i : ary) {
      deque.add(i);
    }
    return deque;
  }
}
