package 알고리즘_고득점_Kit.review2;

import java.util.*;

public class 베스트앨범 {

    static class Album {

        private String genres;
        private int plays;
        private int index;

        private Album(String genres, int plays, int index) {
            this.genres = genres;
            this.plays = plays;
            this.index = index;
        }

        public String getGenres() {
            return genres;
        }

        public int getPlays() {
            return plays;
        }

        public int getIndex() {
            return index;
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        List<Album> albums = new ArrayList<>(); // 모든 앨범 정보를 담는 리스트
        Map<String, Integer> genrePlayCount = new HashMap<>(); // 각 장르별 총 재생 횟수
        List<Integer> resultList = new ArrayList<>(); // 결과를 담을 리스트

        // 1. 각 앨범 정보를 albums 리스트에 저장
        for (int i = 0; i < genres.length; i++) {
            albums.add(new Album(genres[i], plays[i], i));
        }

        // 2. 각 장르별 총 재생 횟수를 계산해서 genrePlayCount HashMap에 저장
        for (int i = 0; i < genres.length; i++) {
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 3. 장르별 총 재생 횟수를 기준으로 내림차순 정렬
        List<Map.Entry<String, Integer>> sortedGenres = new ArrayList<>(genrePlayCount.entrySet());
        sortedGenres.sort((e1, e2) -> e2.getValue() - e1.getValue());

        // 4. 장르별로 최대 2개씩 앨범 선택
        for (Map.Entry<String, Integer> entry : sortedGenres) {

            // 현재 장르에 속하는 앨범들만 필터링
            List<Album> genreAlbums = new ArrayList<>();
            for (Album album : albums) {
                if (album.getGenres().equals(entry.getKey())) {
                    genreAlbums.add(album);
                }
            }

            /**
             * 해당 장르 내에서 정렬
             * 1순위 : 재생 횟수 내림차순
             * 2순위 : 인덱스 오름차순
             */
            genreAlbums.sort((a1, a2) -> {
                if (a1.getPlays() != a2.getPlays()) {
                    return Integer.compare(a2.getPlays(), a1.getPlays());
                }
                return Integer.compare(a1.getIndex(), a2.getIndex());
            });

            // 최대 2개까지만 선택 (장르에 1개만 있다면 1개만)
            int count = Math.min(2, genreAlbums.size());
            for (int i = 0; i < count; i++) {
                resultList.add(genreAlbums.get(i).getIndex());
            }
        }

        // 5. List를 배열(int)로 변환하여 반환
        int[] answer = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        String[] genres = new String[size];
        int[] plays = new int[size];

        sc.nextLine();
        for (int i = 0; i < size; i++) {
            genres[i] = sc.nextLine();
        }

        for (int i = 0; i < size; i++) {
            plays[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(solution(genres, plays)));
    }

}
