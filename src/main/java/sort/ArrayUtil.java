package sort;

public class ArrayUtil {

  private ArrayUtil() {}

  /**
   * 1 ~ maxNum 까지의 랜덤한 숫자를 가진 size배열을 리턴한다.
   * @param size 제공받을 배열의 크기
   * @param maxNum 제공받을 배열의 최대 사이즈
   * @return 배열
   */
  public static int[] supplyList(int size, int maxNum) {
    if(size <= 1) {
      throw new IllegalArgumentException("배열의 크기는 1보다는 커야 합니다.");
    }
    if(maxNum <= 1) {
      throw new IllegalArgumentException("배열의 최대 숫자가 잘못되었습니다.");
    }
    int[] ary = new int[size];
    int length = ary.length;
    for(int i = 0 ; i < length; ++i) {
      ary[i] = (int)(Math.random() * (maxNum));
    }
    return ary;
  }

  public static void prettyPrint(int[] ary) {
    System.out.print(ary[0]);
    for(int i = 1 ; i < ary.length; ++i) {
      System.out.print(",");
      System.out.print(ary[i]);
    }
    System.out.println();
  }
}
