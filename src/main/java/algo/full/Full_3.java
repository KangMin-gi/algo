package algo.full;

public class Full_3 {

  public int[] solution(int brown, int yellow) {
    int size = brown + yellow;
    int maxHeight = (int) Math.sqrt(size);
    int[] answer = new int[2];
    for (int height = maxHeight ; height > 0 ; --height) {
      if (size % height == 0) {
        int width = size / height;
        if (width * 2 + height * 2 - 4 == brown) {
          answer[0] = size / height;
          answer[1] = height;
          return answer;
        }
      }
    }
    return null;
  }
}
