package data;

import static data.heap.OrderEnum.MAX;
import static data.heap.OrderEnum.MIN;

import data.heap.OrderEnum;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class MinHeap {

  private final List<Integer> heap;
  private final int ROOT_INDEX = 1;
  private final OrderEnum orderEnum;

  public MinHeap(OrderEnum order) {
    this.heap = new ArrayList<>();
    this.heap.add(0);
    this.orderEnum = order;
  }

  public void insert() {

  }

  public Integer delete() {
    int root = this.getRoot();
    return root;
  }

  private int getRoot() {
    return this.heap.get(ROOT_INDEX);
  }

  private int getLeftChildIndex(int idx) {
    return idx * 2;
  }

  private int getRightChildIndex(int idx) {
    return idx * 2 + 1;
  }

  private int getParentIndex(int idx) {
    return idx / 2;
  }

  private boolean isRoot(int idx) {
    return idx == 1;
  }

  private void swap(int idx1, int idx2) {
    int val_1 = this.heap.get(idx1);
    int val_2 = this.heap.get(idx2);
    this.heap.add(idx1, val_2);
    this.heap.add(idx2, val_1);
  }

  private boolean isSwap(int parent, int child) {
    if(orderEnum == MIN) {
      return parent > child;
    } else if(orderEnum == MAX) {
      return parent < child;
    }
    return false;
  }

}
