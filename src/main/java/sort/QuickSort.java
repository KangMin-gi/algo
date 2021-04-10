package sort;

public class QuickSort implements Sort {

  private int[] ary;

  @Override
  public int[] sort(int[] ary) {
    this.ary = ary;
    quickSort(0, ary.length - 1);
    return ary;
  }

  public void quickSort(int left, int right) {
    System.out.println("left = " + left);
    System.out.println("right = " + right);
    if (left >= right) {
      return;
    }

    int pivot = right;
    int L = left;
    int R = right - 1;
    int PV = ary[pivot];

    while (L < R) {
      int LV = ary[L];
      int RV = ary[R];


      if (PV < RV && PV < LV) { // PV < LV,RV
        R--;
        continue;
      }

      if (PV > LV && PV > RV) { // PV > LV,RV
        L++;
        continue;
      }

      if (RV <= PV && PV <= LV) { // RV < PV < LV
        ary[L] = RV;
        ary[R] = LV;
        L++;
        R--;
        continue;
      }

      if (LV <= PV && PV <= RV) { // LV < PV < RV
        L++;
        R--;
      }
    }

    if(ary[L] > PV) {
      ary[pivot] = ary[L];
      ary[L] = PV;
      pivot = L;
    } else {
      ary[pivot] = ary[L + 1];
      ary[L + 1] = PV;
      pivot = L+1;
    }

    quickSort(left, pivot - 1);
    quickSort(pivot + 1, right);
    return;

  }
}
