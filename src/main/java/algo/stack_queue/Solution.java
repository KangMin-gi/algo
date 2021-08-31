package algo.stack_queue;

import algo.stack_queue.outputUtil.ArrayUtils;

import java.util.*;

/**
 * 문제 제출용 클래스
 */

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] prices = {1, 2, 3, 2, 3};
    int[] solution1 = solution.solution(prices);
    ArrayUtils.print(solution1);
  }

  public int[] solution(int[] prices) {
    int[] answer = new int[prices.length];
    List<Integer> priceList = new ArrayList<>();

    for (int price : prices) {
      priceList.add(price);
    }


    for(int i = 0 ; i < priceList.size(); ++i) {
      int nowPrice = priceList.get(i);
      Iterator<Integer> iterator = priceList.subList(i, priceList.size()).iterator();
      int count = 0;
      int j = 0;
      while (iterator.hasNext()) {
        if (j++ == 0) {
          int price = iterator.next();
          continue;
        }
        int price = iterator.next();
        count++;
        if (nowPrice > price) {
          break;
        }
      }
      System.out.println();
      answer[i] = count;
    }

    return answer;
  }

}
