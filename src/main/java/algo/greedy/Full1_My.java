package algo.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Full1_My {
  public int solution(int n, int[] losts, int[] reserves) {
    int answer = 0;

    List<Integer> lostList = new ArrayList<>();
    List<Integer> reserveList = new ArrayList<>();
    for (int lost : losts) {
      lostList.add(lost);
    }
    List<Integer> cpLostList = new ArrayList<>(lostList);
    for (int reserve : reserves) {
      reserveList.add(reserve);
    }
    lostList.removeAll(reserveList);
    reserveList.removeAll(cpLostList);
    lostList.sort(Integer::compare);
    reserveList.sort(Integer::compare);
    List<Integer> lowList;
    List<Integer> highList;
    for (Integer reserve : reserveList) {
      lowList = lostList.stream()
          .filter(v -> v < reserve)
          .collect(Collectors.toList());
      int lowCount = lowList.size();

      highList = lostList.stream()
          .filter(v -> v > reserve)
          .collect(Collectors.toList());
      int highCount = highList.size();

      boolean canLow = false;
      boolean canHigh = false;

      if (lowCount == 0 && highCount == 0) {
        break;
      } else if (lowCount == 0) {
        canHigh = highList.get(0) == reserve + 1;
      } else if (highCount ==0) {
        canLow = lowList.get(lowCount - 1) == reserve - 1;
      } else {
        canHigh = highList.get(0) == reserve + 1;
        canLow = lowList.get(lowCount - 1) == reserve - 1;
      }

      if (canHigh && canLow) {
        if (lowCount > highCount) {
          lostList.remove(lowCount - 1);
        } else {
          lostList.remove(0);
        }
      } else if (canHigh) {
        lostList.remove(0);
      } else if (canLow) {
        lostList.remove(lowCount - 1);
      } else {
        continue;
      }
    }
    answer = n - lostList.size();
    return answer;
  }
}
