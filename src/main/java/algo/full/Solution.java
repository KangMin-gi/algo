package algo.full;

import java.util.*;
import sort.ArrayUtil;

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int solution1 = solution.solution("011");
    System.out.println("solution1 = " + solution1);
  }

  public int solution(String input) {
    int[] numbers = new int[input.length()];
    int len = numbers.length;
    for (int i = 0; i < len; ++i) {
      numbers[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
    }

    Permutation permutation = new Permutation(len);
    permutation.permutation(numbers, 0);
    Set<Integer> result = permutation.result;
    int cnt = 0;
    for (Integer num : result) {
      System.out.println("num = " + num);
      if(isThatNum(num))
        ++cnt;
    }

    return cnt;
  }


  public boolean isThatNum(int num) {
    if (num == 1 || num == 0) {
      return false;
    }
    for (int i = 2; i < num; ++i) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static class Permutation {

    private int n;
    private int[] now; // 현재 순열
    private Set<Integer> result;

    public Permutation(int n) {
      this.n = n;
      this.now = new int[n];
      this.result = new HashSet<>();
    }

    public void swap(int[] arr, int i, int j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }

    public void permutation(int[] arr, int depth) {
      if (depth > n) {
        return;
      }
      if (depth != 0) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < depth; i++) {
          builder.append(now[i]);
        }
        result.add(Integer.parseInt(builder.toString()));
      }

      for (int i = depth; i < n; i++) {
        swap(arr, i, depth);
        now[depth] = arr[depth];
        permutation(arr, depth + 1);
        swap(arr, i, depth);
      }
    }
  }

}


