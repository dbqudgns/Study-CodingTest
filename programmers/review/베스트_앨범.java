package review;

import java.util.*;

public class 베스트_앨범 {

    static class Album {
        private String name;
        private int play;
        private int index;

        public Album(String name, int play, int index) {
            this.name = name;
            this.play = play;
            this.index = index;
        }

        public String getName() {return this.name;}

        public int getPlay() {return this.play;}

        public int getIndex() {return this.index;}
    }

    public static int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> getPlays = new HashMap<>();
        List<Album> albums = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            Album album = new Album(genres[i], plays[i], i);
            albums.add(album);
        }

        for (int i = 0; i < genres.length; i++) {
            getPlays.put(genres[i], getPlays.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(getPlays.entrySet());
        sortedList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sortedList) {

            List<Album> genresList = new ArrayList<>();
            for (Album album : albums) {
                if (album.getName().equals(entry.getKey())) {
                    genresList.add(album);
                }
            }

            genresList.sort((a1, a2) -> {
                if (a1.getPlay() != a2.getPlay()) return a2.getPlay() - a1.getPlay();
                else return a1.getIndex() - a2.getIndex();
            });

            int size = Math.min(genresList.size(), 2);
            for (int i = 0; i < size; i++) {
                result.add(genresList.get(i).getIndex());
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        return answer;


    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        String[] genres = new String[size];
        int[] plays = new int[size];

        for (int i = 0; i < size; i++) {
            genres[i] = sc.next();
        }

        for (int i = 0; i < size; i++) {
            plays[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(solution(genres, plays)));

    }

}
