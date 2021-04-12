package just.listpasstest;

import java.util.List;

public class TestMain {

  public static void main(String[] args) {
    JustList justList = new JustList();
    List<Integer> list = justList.getList();
    System.out.println("#1 list = " + list);
    list.add(100);
    list.add(111);
    System.out.println("#2 list = " + list);
    List<Integer> list1 = justList.getList();
    System.out.println("#3 list = " + list1);
    list.add(222);
    System.out.println("#4 list = " + list1);

  }
}
