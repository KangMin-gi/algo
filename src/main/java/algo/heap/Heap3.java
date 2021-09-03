package algo.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Heap3 {

  public int[] solution(String[] operations) {
    int[] answer = {0, 0};
    Queue<Integer> minQ = new PriorityQueue<>();
    Queue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());

    for (String command : operations) {
      Operation operation = Operation.get(command);
      if (Operation.INSERT == operation) {
        Integer insertNumber = insertNumber(command);
        maxQ.add(insertNumber);
        minQ.add(insertNumber);
      } else if (minQ.isEmpty()) {
        continue;
      } else if (Operation.DELETE_MAX == operation) {
        Integer remove = maxQ.remove();
        minQ.remove(remove);
      } else if (Operation.DELETE_LOW == operation) {
        Integer remove = minQ.remove();
        maxQ.remove(remove);
      }
    }

    if (!minQ.isEmpty()) {
      answer[0] = maxQ.remove();
      answer[1] = minQ.remove();
    }


    return answer;
  }

  public Integer insertNumber(String command) {
    String[] s = command.split(" ");
    if ("I".equals(s[0])) {
      return Integer.parseInt(s[1]);
    }
    return null;
  }

  public enum Operation {
    INSERT, DELETE_LOW, DELETE_MAX;

    public static Operation get(String command) {
      String[] str = command.split(" ");
      if ("I".equals(str[0]))
        return INSERT;
      if ("-1".equals(str[1]))
        return DELETE_LOW;
      if ("1".equals(str[1]))
        return DELETE_MAX;
      throw new IllegalArgumentException();
    }
  }

}
