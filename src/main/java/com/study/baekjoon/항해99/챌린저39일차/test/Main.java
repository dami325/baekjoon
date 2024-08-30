package com.study.baekjoon.항해99.챌린저39일차.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {
    private int answer;
    private List<int[]> caseList;
    private int[] pick;
    public int solution(int[] picks, String[] minerals) {
        int dia = 0;
        int iron = 0;
        int stone = 0;

        answer = Integer.MAX_VALUE-1;
        caseList = new ArrayList<>();
        pick = picks;

        int picksLength = (picks[0] + picks[1] + picks[2]) * 5;

        int i=0;
        while(i < picksLength && i<minerals.length){
            if(minerals[i] ==("diamond")){
                dia += 1;
                iron += 5;
                stone += 25;
            }else if(minerals[i]==("iron")){
                dia += 1;
                iron += 1;
                stone += 5;
            }else if(minerals[i]==("stone")){
                dia += 1;
                iron += 1;
                stone += 1;
            }
            if(i%5 == 4){
                caseList.add(new int[]{dia, iron, stone});
                dia = 0;
                iron = 0;
                stone = 0;
            }

            i++;
        }

        if(dia != 0){
            caseList.add(new int[]{dia, iron, stone});
        }

        int[] visited = new int[caseList.size()];
        int[] visitedCase = new int[caseList.size()];

        dfs(visited, visitedCase, 0);
        return answer;
    }

    private void dfs(int[] visited, int[] visitedCase, int depth){
        if(depth == caseList.size()){
            int dia = 0;
            int iron = 0;
            int stone = 0;
            int cnt = 0;
            for(int i=0;i<depth;i++){
                if(visited[i] == 1) dia++;
                else if(visited[i] == 2) iron++;
                else if(visited[i] == 3) stone++;

                cnt += visitedCase[i];
            }

            if(dia > pick[0] || iron > pick[1] || stone > pick[2]) return;

            answer = Math.min(answer, cnt);

            return;
        }

        int[] tmp = caseList.get(depth);
        for(int i=0;i<3;i++) {
            visited[depth] = i + 1;
            visitedCase[depth] = tmp[i];
            dfs(visited, visitedCase, depth + 1);
        }
    }
}
public class Main {

    private static Solution solution = new Solution();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        System.out.println(
                solution.solution(new int[]{1,3,2},strArr)
        );
    }
//        System.out.println(
//                solution.solution(new int[]{1,3,2},
//                        new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"})
//        );
}


