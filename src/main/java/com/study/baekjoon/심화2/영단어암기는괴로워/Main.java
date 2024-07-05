package com.study.baekjoon.심화2.영단어암기는괴로워;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        /**
         * 자주 나오는 단어일수록 앞에 배치
         * 해당 단어의 길이가 길수록 앞에 배치
         * 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치
         * 길이가 M 이상인것만
         */
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Map<String,Rank> worlds = new HashMap(n);

            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                if (str.length() < m) {
                    continue;
                }

                if(worlds.containsKey(str)) {
                    Rank rank = worlds.get(str);
                    rank.plusSameCount();
                } else {
                    worlds.put(str,new Rank(str, 0, str.length(), false));
                }
            }

            Comparator<Rank> rankComparator = (o1, o2) -> o2.isBefore(o1) ? 1 : -1;

            worlds.values().stream()
                    .sorted(rankComparator)
                    .forEach(
                            rank -> sb.append(rank.getValue()).append("\n")
                    );

            System.out.println(sb);


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(sb);
        } ;


    }


}

class Rank {
    private String value;
    private int sameCount;
    private int length;
    private boolean isBefore;

    public int getSameCount() {
        return sameCount;
    }

    public String getValue() {
        return value;
    }
    public int getLength() {
        return length;
    }

    public boolean isBefore(Rank rank) {

        String value = rank.getValue();

        if(this.sameCount > rank.getSameCount()) {
            return true;
        } else if(this.sameCount < rank.getSameCount()) {
            return false;
        }

        if(length > rank.getLength()) {
            return true;
        } else if(length < rank.getLength()) {
            return false;
        }

        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            char thisC = this.value.charAt(i);

            if(thisC < c) {
                return true;
            } else if(thisC > c) {
                return false;
            }
        }

        return isBefore;
    }

    public Rank(String value,int sameCount, int length, boolean isBefore) {
        this.value = value;
        this.sameCount = sameCount;
        this.length = length;
        this.isBefore = isBefore;
    }

    public void plusSameCount() {
        this.sameCount += 1;
    }
}
