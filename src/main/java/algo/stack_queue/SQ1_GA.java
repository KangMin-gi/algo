package algo.stack_queue;

import java.util.Arrays;

public class SQ1_GA {

  private final static int MAX_ARY_LEN = 100;

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
