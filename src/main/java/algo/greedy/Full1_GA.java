package algo.greedy;

public class Full1_GA {

  public static void main(String[] args) {
    Full1_GA solution = new Full1_GA();
    int n = 5;
    int[] ary1 = {1,2,4};
//    int[] ary2 = {1,3,5};
    int[] ary2 = {1,3,5};
    int solution1 = solution.solution(n, ary1, ary2);
    System.out.println("solution1 = " + solution1);
  }

  public int solution(int n, int[] losts, int[] reserves) {
    int[] people = new int[n+2];
    int answer = n;

    for (int lost : losts) {
      people[lost]--;
    }
    for (int reserve : reserves) {
      people[reserve]++;
    }

    for (int i = 1 ; i <= n ; ++i) {
      if (people[i] == -1 && people[i-1] == 1) {
        people[i] = 0;
        people[i-1] = 0;
      } else if (people[i] == -1 && people[i+1] == 1) {
        people[i] = 0;
        people[i+1] = 0;
      } else if (people[i] == -1) {
        --answer;
      }
    }
    return answer;
  }
}
