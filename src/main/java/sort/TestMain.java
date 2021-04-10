package sort;

public class TestMain {

  public static void main(String[] args) {
    int[] ary = ArrayUtil.supplyList(16, 7);
    ArrayUtil.prettyPrint(ary);
    System.out.println();
    Sort sort = new QuickSort();
    sort.sort(ary);
    ArrayUtil.prettyPrint(ary);
  }
}
