package algo.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class Heap1 {
  public int solution(int[] scoville, int K) {
    int answer = 0;
    Queue<Integer> list = new PriorityQueue<>();
    for (int i : scoville) {
      list.add(i);
    }
    if(list.peek() >= K) {
      return answer;
    }
    while(list.size() > 1) {
      int low1 = list.poll();
      int low2 = list.poll();
      int mixV = low1 + (low2 * 2);
      list.add(mixV);

      answer++;
      if(list.peek() >= K)
        return answer;
    }
    return -1;
  }
}
