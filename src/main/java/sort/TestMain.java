package sort;

public class TestMain {

  public static void main(String[] args) {
    int[] ary = ArrayUtil.supplyList(10, 10);
    ArrayUtil.prettyPrint(ary);
    System.out.println();
    Sort sort = new InsertionSort();
    sort.sort(ary);
    ArrayUtil.prettyPrint(ary);
  }
}
