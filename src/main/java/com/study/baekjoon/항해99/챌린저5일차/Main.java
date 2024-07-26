package com.study.baekjoon.항해99.챌린저5일차;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {


    public int[] solution(String[] genres, int[] plays) {
        List<Album> albumList = new ArrayList<>();
        int[] tmp = new int[200];

        String genre = null;
        for (int i = 0; i < genres.length; i++) {
            genre = genres[i];
            int play = plays[i];
            albumList.add(new Album(i, genre, play));
        }

        Map<String, Integer> albumMap = albumList.stream()
                .collect(
                        Collectors.groupingBy(
                                Album::getGenres,
                                Collectors.summingInt(Album::getPlays)
                        ));


        List<Map.Entry<String, Integer>> sortMap = albumMap.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .collect(Collectors.toList());

        int index = 0;

        for (int i = 0; i < sortMap.size(); i++) {

            Map.Entry<String, Integer> entry = sortMap.get(i);

            List<Album> sortAlbum = albumList.stream()
                    .filter(album -> album.getGenres().equals(entry.getKey()))
                    .sorted((o1, o2) -> {
                        if (o2.getPlays() == o1.getPlays()) {
                            return o1.getAlbumId() - o2.getAlbumId();
                        }
                        return o2.getPlays() - o1.getPlays();
                    })
                    .collect(Collectors.toList());

            Iterator<Album> iterator = sortAlbum.iterator();
            int count = 0;
            while (iterator.hasNext()){
                if (count == 2) {
                    break;
                }
                tmp[index++] = iterator.next().albumId;
                count++;
            }

        }

        int[] answer = new int[index];

        for (int i = 0; i < index; i++) {
            answer[i] = tmp[i];
        }

        return answer;
    }

    class Album {
        private int albumId;
        private String genres;
        private int plays;

        public int getAlbumId() {
            return albumId;
        }

        public String getGenres() {
            return genres;
        }

        public int getPlays() {
            return plays;
        }

        public Album(int albumId, String genres, int plays) {
            this.albumId = albumId;
            this.genres = genres;
            this.plays = plays;
        }
    }
}
