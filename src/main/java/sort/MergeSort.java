package sort;

import java.util.Arrays;

public class MergeSort implements Sort {

  @Override
  public int[] sort(int[] ary) {
    int[] temp = new int[ary.length];
    Arrays.fill(temp, -1);
    merge(ary, temp, 0, temp.length - 1);
    return ary;
  }

  public void merge(int[] ary, int[] temp, int leftIdx, int rightIdx) {
    if(leftIdx == rightIdx)
      return;

    int median = getMedian(leftIdx, rightIdx);
    merge(ary, temp, leftIdx, median);
    merge(ary, temp, median + 1, rightIdx);
    mergeSort(ary, temp, leftIdx, rightIdx);
  }

  public void mergeSort(int[] ary, int[] temp, final int leftIdx, final int rightIdx) {
    if (leftIdx == rightIdx) {
      return;
    }

    int mid = getMedian(leftIdx, rightIdx);
    int leftIter = leftIdx;
    int curIdx = leftIdx;
    int rightIter = mid + 1;

    while (leftIter <= mid && rightIter <= rightIdx) {
      if (ary[leftIter] <= ary[rightIter]) {
        temp[curIdx] = ary[leftIter];
        leftIter++;
      } else {
        temp[curIdx] = ary[rightIter];
        rightIter++;
      }
      curIdx++;
    }

    if (leftIter > mid) {
      for( ; rightIter <= rightIdx; ++rightIter) {
        temp[curIdx] = ary[rightIter];
        curIdx++;
      }
    } else {
      for ( ; leftIter <= mid ; ++leftIter) {
        temp[curIdx] = ary[leftIter];
        curIdx++;
      }
    }

    injectTemp(ary, temp, leftIdx, rightIdx);

  }


  public int getMedian(int leftIdx, int rightIdx) {
    return (leftIdx + rightIdx) / 2;
  }


  public void injectTemp(int[] ary, int[] temp, int leftIdx, int rightIdx) {
    for(int idx = leftIdx ; idx <= rightIdx; ++idx) {
      ary[idx] = temp[idx];
    }
  }

}
