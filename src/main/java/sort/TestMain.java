package sort;

public class TestMain {

  public static void main(String[] args) {
    int[] ary = ArrayUtil.supplyList(2, 2);
    ArrayUtil.prettyPrint(ary);
    System.out.println();
    Sort sort = new MergeSort();
    sort.sort(ary);
    ArrayUtil.prettyPrint(ary);
  }
}
