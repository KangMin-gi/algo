package algo.stack_queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SQ2_MINE {

  public int solution(int[] priorities, int location) {
    PriorityQueue<Element> priorityQueue = new PriorityQueue<>();

    for (int i = 0; i < priorities.length; ++i) {
      Element element = new Element(i, priorities[i], i);
      priorityQueue.add(element);
    }

    List<Element> addList = new ArrayList<>();
    List<Element> removeList = new ArrayList<>();
    int maxIndex = priorities.length;

    int answer = 1;

    while (priorityQueue.size() > 1) {
      Element remove = priorityQueue.remove();
      if (remove.originLocation == location) {
        return answer;
      }

      int finalMaxIndex = maxIndex;
      priorityQueue.stream()
          .filter(ele -> ele.index < remove.index)
          .forEach(ele -> {
            addList
                .add(new Element(ele.index + finalMaxIndex + 1, ele.priority, ele.originLocation));
            removeList.add(ele);
          });
      priorityQueue.removeAll(removeList);
      priorityQueue.addAll(addList);

      maxIndex = priorityQueue.stream()
          .max(Comparator.comparingInt(o -> o.index))
          .map(ele -> ele.index)
          .get();

      answer++;

      removeList.clear();
      addList.clear();
    }

    return answer;
  }

  public static class Element implements Comparable<Element> {

    int index;
    int priority;
    int originLocation;

    public Element(int index, int priority, int originLocation) {
      this.index = index;
      this.priority = priority;
      this.originLocation = originLocation;
    }

    @Override
    public int compareTo(Element o) {
      if (o.priority == this.priority) {
        return Integer.compare(this.index, o.index);
      }
      return Integer.compare(o.priority, this.priority);
    }
  }
}
