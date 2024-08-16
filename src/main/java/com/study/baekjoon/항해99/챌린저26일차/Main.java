package com.study.baekjoon.항해99.챌린저26일차;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
class Solution {

    private int autoId = 1;
    private LocalDate today;

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> monthMap = new HashMap<>();
        this.today = dateParser(today);

        for (String t : terms) {
            String[] termsSplit = t.split(" ");

            String name = termsSplit[0];
            int month = Integer.parseInt(termsSplit[1]);

            monthMap.put(name, month);
        }


        for (String p : privacies) {
            String[] privaciesSplit = p.split(" ");

            String expireDay = privaciesSplit[0];
            int month = monthMap.get(privaciesSplit[1]);

            Privacy privacy = new Privacy(expireDay, month);

            if (privacy.isExpired()) {
                answer.add(privacy.getId());
            }
            ;
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    class Privacy {
        private int id;
        private String expireDay;
        private int plusMonth;

        public Privacy(String expireDay, int plusMonth) {
            this.id = autoId++;
            this.expireDay = expireDay;
            this.plusMonth = plusMonth;
        }

        public int getId() {
            return this.id;
        }

        public boolean isExpired() {

            LocalDate expiredDay = dateParser(this.expireDay).plusMonths(this.plusMonth);

            return expiredDay.isEqual(today) || expiredDay.isBefore(today);
        }

        /**
         * 날짜 형식 2021.05.02
         */
    }

    private LocalDate dateParser(String date) {
        String[] split = date.split("\\.");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);

        return LocalDate.of(year, month, day);
    }
}

public class Main {
    public static void main(String[] args) {
        int[] solution = new Solution().solution(
                "2022.05.19",
                new String[]{"A 6", "B 12", "C 3"},
                new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});

        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}

