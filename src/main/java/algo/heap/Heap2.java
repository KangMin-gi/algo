package algo.heap;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class Heap2 {


  public int solution(int[][] jobs) {
    Queue<Task> priQ = new PriorityQueue<>();
    Queue<Task> jobQ = new ArrayDeque<>();
    int nowSec = 0;
    int totalTime = 0;
    int totalSize = jobs.length;

    List<Task> collect = Arrays.stream(jobs)
        .sorted((o1, o2) -> Integer.compare(o1[0], o2[0]))
        .map(v -> new Task(v[0], v[1]))
        .collect(Collectors.toList());

    jobQ.addAll(collect);

    while(!jobQ.isEmpty() || !priQ.isEmpty()) {
      while (!jobQ.isEmpty()) {
        Task peekJobQ = jobQ.peek();
        if (nowSec >= peekJobQ.innerTime) {
          priQ.add(jobQ.remove());
        } else if (priQ.isEmpty()) {
          nowSec = peekJobQ.innerTime;
          priQ.add(jobQ.remove());
        } else {
          break;
        }
      }

      Task peek = priQ.peek();
      if(peek != null) {
        Task remove = priQ.remove();
        nowSec +=remove.taskTime;
        totalTime += nowSec - remove.innerTime;
        remove.doneTime = nowSec;
      }
    }

    return totalTime / totalSize;
  }

  public static class Task implements Comparable<Task> {
    int innerTime;
    int taskTime;
    int doneTime;

    public Task(int innerTime, int taskTime) {
      this.innerTime = innerTime;
      this.taskTime = taskTime;
    }

    @Override
    public int compareTo(Task o) {
      return Integer.compare(taskTime, o.taskTime);
    }
  }
}
