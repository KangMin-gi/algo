package algo.wow;

public class Permutation {
  public void permutation(String seed, String str) {
    int n = str.length();
    //if (n == 0) System.out.println(prefix);

    // 종료조껀

    for (int i = 0; i < n; i++)
      permutation(seed + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
  }
}
