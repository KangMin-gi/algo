package algo.sort;

import java.util.ArrayList;
import java.util.List;

public class Sort_3 {

  public int solution(int[] citations) {

    List<Integer> list = new ArrayList<>();
    for (int citation : citations) {
      list.add(citation);
    }

    list.sort(Integer::compareTo);
    int answer = -1;
    for (int i = 0; i <= 1000; ++i) {
      int finalI = i;
      int count = (int) list.stream().filter(v -> v >= finalI).count();
      if ( i > count)
        break;
      answer = i;
    }

    return answer;
  }

  public int solution2(int[] citations) {
    List<Integer> list = new ArrayList<>();
    for (int citation : citations) {
      list.add(citation);
    }

    list.sort(Integer::compare);

    int finalAnswer= 0;
    int size = list.size();
    for (int i = size - 1; i >= 0 ; --i) {
      int val = list.get(i);
      int answer =  Math.min(val, size - i);
      if (finalAnswer < answer) {
        finalAnswer = answer;
      } else {
        break;
      }
    }
    return finalAnswer;
  }
}
