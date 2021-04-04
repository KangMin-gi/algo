package sort;

public class InsertionSort implements Sort {

  @Override
  public int[] sort(int[] ary) {
    int idx;
    int i;
    int length = ary.length;
    for(idx = 1 ; idx < length ; ++ idx) {
      int value = ary[idx];
      for(i = idx - 1 ; i >= 0 && value < ary[i] ; --i) {
        ary[i + 1] = ary[i];
      }
      ary[i+1] = value;
    }
    return ary;
  }
}
