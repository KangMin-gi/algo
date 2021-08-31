package algo.stack_queue.outputUtil;

public class ArrayUtils {

  public static void print(int[] ary) {
    StringBuilder builder = new StringBuilder();
    builder.append("[");

    for (int i : ary) {
      builder.append(i);
      builder.append(", ");
    }
    builder.deleteCharAt(builder.length() - 1);
    builder.deleteCharAt(builder.length() - 1);
    builder.append("]");
    System.out.println(builder);
  }
}
