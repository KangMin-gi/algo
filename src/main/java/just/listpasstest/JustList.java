package just.listpasstest;

import java.util.ArrayList;
import java.util.List;

public class JustList {

  private List<Integer> list;

  public JustList() {
    this.list = new ArrayList<>();
    for(int i = 0 ; i < 10 ; ++i) {
      list.add(i);
    }
  }

  public List<Integer> getList() {
    return list;
  }
}
