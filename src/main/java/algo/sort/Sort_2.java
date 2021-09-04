package algo.sort;


// 뻠삥할떈 조심하자
// 숫자는 0을 항상 생각하자

import java.util.Arrays;

public class Sort_2 {
  public String solution(int[] numbers) {
    StringBuilder buffer = new StringBuilder();
    Arrays.stream(numbers)
        .mapToObj(MyNumber::new)
        .sorted()
        .map(myNumber -> myNumber.originNum)
        .forEach(buffer::append);
    String s = buffer.toString();
    if (s.matches("0*"))
      return "0";
    return s;


  }

  public static class MyNumber implements Comparable<MyNumber> {

    int originNum;
    Integer compareNum;

    public MyNumber(int num) {
      this.originNum = num;
      String s = String.valueOf(num);
      this.compareNum = Integer.parseInt(s.concat(s.repeat(4 / s.length())).substring(0,4));
    }

    @Override
    public int compareTo(MyNumber o) {
      return o.compareNum.compareTo(this.compareNum);
    }
  }
}
