package algo.stack_queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// Location 을 돌린다.

public class SQ2_GA {

  public int solution(int[] priorities, int location) {
    int answer = 0;

    Queue<Integer> que = new LinkedList<>();
    for (int i : priorities) {
      que.add(i);
    }

    Arrays.sort(priorities);
    int size = priorities.length - 1;

    while (!que.isEmpty()) {
      Integer i = que.poll();
      if (i == priorities[size - answer]) {
        answer++;
        location--;
        if (location < 0) {
          break;
        }
      } else {
        que.add(i);
        location--;
        if (location < 0) {
          location = que.size() - 1;
        }
      }
    }

    return answer;
  }
}
