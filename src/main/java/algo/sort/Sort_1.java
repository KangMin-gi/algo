package algo.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sort_1 {


  public int[] solution(int[] array, int[][] commands) {
    int[] answer = new int[commands.length];

    List<Integer> list = new ArrayList<>();
    for (int i : array) {
      list.add(i);
    }

    for(int i = 0 ; i < commands.length; ++i) {
      int startIdx = commands[i][0] - 1;
      int endIdx = commands[i][1] ;
      if (startIdx == endIdx - 1) {
        answer[i] = list.get(startIdx);
        continue;
      }
      answer[i] = list.subList(startIdx, endIdx)
          .stream()
          .sorted()
          .collect(Collectors.toList())
          .get(commands[i][2] - 1);
    }

    return answer;
  }
}
