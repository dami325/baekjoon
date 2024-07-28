package com.study.baekjoon.항해99.챌린저7일차;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        class Solution {

            private PriorityQueue<Schedule> taskQue = new PriorityQueue<>((o1, o2) -> (int) (o1.start - o2.start));
            private List<String> answer;

            public String[] solution(String[][] plans) {
                answer = new ArrayList<>();

                // 계획을 PriorityQueue에 추가
                for (int i = 0; i < plans.length; i++) {
                    String name = plans[i][0];
                    String startStr = plans[i][1];
                    int playtime = Integer.parseInt(plans[i][2]);

                    String[] split = startStr.split(":");
                    int startTime = (Integer.parseInt(split[0]) * 60) + Integer.parseInt(split[1]);
                    taskQue.offer(new Schedule(name, startTime, playtime));
                }

                Schedule s = taskQue.poll();

                int currentStartTime = s.start; // 초기 스케줄 실행 시간

                Stack<Schedule> stopStack = new Stack<>();
                while (true) {
                    int nowEndTime = currentStartTime + s.plusTime;

                    // 다음 실행 시간이 현재 스케줄 종료 시간보다 작을경우 중지
                    if (!taskQue.isEmpty() && taskQue.peek().start < nowEndTime) {

                        // plus시간 = 현재 plus 시간 - (다음 스케줄 실행시간 - 현재 스케줄 실행 시간)
                        int plusTime = s.plusTime - (taskQue.peek().start - currentStartTime); // 실행된 시간 계산

                        stopStack.push(new Schedule(s.name,s.start, plusTime));

                        currentStartTime = taskQue.peek().start;

                        s = taskQue.poll(); // 새로운 과제
                    }else {
                        answer.add(s.name);
                        currentStartTime += s.plusTime; // 현재 시각 재설정

                        //새로 시작해야 하는 과제가 있다면 새로운 과제 시작
                        if(!stopStack.isEmpty()){
                            //멈춰둔 과제 다시 시작
                            s = stopStack.pop();
                        }
                        else if(!taskQue.isEmpty()){
                            s = taskQue.poll();
                            currentStartTime = s.start;
                        }
                        else break;
                    }
                }

                return answer.toArray(new String[0]);
            }

            class Schedule {
                private String name;
                private int start;
                private int plusTime;
                public Schedule(String name, int start, int plusTime) {
                    this.name = name;
                    this.start = start;
                    this.plusTime = plusTime;
                }
            }

        }

        String[] solution = new Solution().solution(new String[][]{
                {"music", "12:20", "40"}, // 13
                {"computer", "12:30", "100"}, // 2) 13 30 ~ 15
                {"science", "12:40", "50"},  // 13 30 1) 끝
                {"history", "14:00", "30"}} // 14 30
        );

    }
}
