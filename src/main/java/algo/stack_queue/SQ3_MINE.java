package algo.stack_queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class SQ3_MINE {
  public static int totalTime;
  public static int totalLength;

  public int solution(int bridge_length, int weight, int[] truck_weights) {
    int time = 0;

    totalTime = bridge_length;
    totalLength = bridge_length;

    Queue<Truck> remainTruck = new ArrayDeque<>();
    Queue<Truck> bridge = new ArrayDeque<>();

    for (int truckWeight : truck_weights) {
      Truck truck = new Truck(totalTime, truckWeight);
      remainTruck.add(truck);
    }

    while(!remainTruck.isEmpty()) {
      time++;

      if (!bridge.isEmpty()) {
        bridge.forEach(Truck::timeTick);
        Truck bridgeFirst = bridge.peek();
        if (bridgeFirst.isEnd())
          bridge.remove();
      }

      int bridgeTotalWeight = bridge.stream().mapToInt(truck -> truck.weight).sum();
      int bridgeTruckSize = bridge.size();

      Truck peek = remainTruck.peek();

      if (weight >= bridgeTotalWeight + peek.weight && totalLength >= bridgeTruckSize + 1) {
        bridge.add(peek);
        remainTruck.remove();
      }

    }

    return time + totalTime;
  }

  public static class Truck {
    int remainTime;
    int weight;

    public Truck(int remainTime, int weight) {
      this.remainTime = remainTime;
      this.weight = weight;
    }

    public boolean isEnd() { return this.remainTime == 0;}
    public void timeTick() { this.remainTime--; }
  }
}
