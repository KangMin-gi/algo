package algo.full;

import java.util.Arrays;

public class Full_1 {
  public int[] solution(int[] answers) {
    final int[][] seed = {
        {1,2,3,4,5},
        {2,1,2,3,2,4,2,5},
        {3,3,1,1,2,2,4,4,5,5}
    };

    int[] answerCount = {0 ,0 ,0};

    for (int i = 0 ; i < answers.length ; ++i) {
      int answer = answers[i];
      for (int j = 0 ; j < 3 ; ++j) {
        if (answer == seed[j][i % seed[j].length])
          answerCount[j]++;
      }
    }

    int max = -1;
    for (int cnt : answerCount) {
      if (cnt > max)
        max = cnt;
    }

    int[] ret = {};

    for (int i = 0 ; i < answerCount.length; ++i) {
      if (answerCount[i] == max) {
        ret = Arrays.copyOf(ret, ret.length + 1);
        ret[ret.length - 1] = i + 1;
      }
    }

    return ret;

  }
}
