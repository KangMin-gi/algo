package algo.stack_queue;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class SQ4_MINE {

  public int[] solution(int[] prices) {
    int[] answer = new int[prices.length];
    Queue<Integer> priceList = new ArrayDeque<>();

    for (int price : prices) {
      priceList.add(price);
    }

    int i = 0;

    while (!priceList.isEmpty()) {
      int nowPrice = priceList.poll();

      Iterator<Integer> iterator = priceList.iterator();
      int count = 0;
      while (iterator.hasNext()) {
        int price = iterator.next();
        count++;
        if (nowPrice > price) {
          break;
        }
      }
      answer[i++] = count;
    }

    return answer;
  }

}
