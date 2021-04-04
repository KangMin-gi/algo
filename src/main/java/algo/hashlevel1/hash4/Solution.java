package algo.hashlevel1.hash4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  public static void main(String[] args) {
    String[] genres = {"1g", "2g", "1g", "1g", "2g"};
    int[] plays = {500, 600, 150, 800, 2500};
    int[] solution = solution(genres, plays);
    for (int i : solution) {
      System.out.print(i);
      System.out.print(",");
    }
  }

  public static int[] solution(String[] genres, int[] plays) {
    Map<String, List<Music>> musicMap = new HashMap<>();
    Map<String, Integer> totalCountMap = new HashMap<>();
    for (int i = 0; i < genres.length; ++i) {
      String genre = genres[i];
      List<Music> musicList = musicMap.getOrDefault(genre, new ArrayList<>());
      musicList.add(new Music(i, genre, plays[i]));
      musicMap.put(genre, musicList);
      totalCountMap.put(genre, totalCountMap.getOrDefault(genre, 0) + plays[i]);
    }

    for (String s : musicMap.keySet()) {
      List<Music> music = musicMap.get(s);
      music.sort((o1, o2) -> Integer.compare(o2.plays, o1.plays));
      musicMap.put(s, music);
    }

    List<String> genreOrderList = new ArrayList<>(totalCountMap.keySet());
    genreOrderList.sort((o1, o2) -> totalCountMap.get(o2).compareTo(totalCountMap.get(o1)));
    List<Integer> retList = new ArrayList<>();
    for (String gen : genreOrderList) {
      List<Music> music = musicMap.get(gen);
      retList.add(music.get(0).idx);
      if (music.size() >= 2) {
        retList.add(music.get(1).idx);
      }
    }

    int[] ary = new int[retList.size()];
    for (int i = 0; i < retList.size(); ++i) {
      ary[i] = retList.get(i);
    }
    return ary;

  }

  public static class Music {

    int idx;
    String genre;
    int plays;

    public Music(int idx, String genre, int plays) {
      this.idx = idx;
      this.genre = genre;
      this.plays = plays;
    }
  }
}
