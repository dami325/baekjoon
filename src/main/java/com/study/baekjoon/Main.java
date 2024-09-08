package com.study.baekjoon;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


class Solution {
    private static LocalTime videoLen;
    private static LocalTime now;
    private static LocalTime opStart;
    private static LocalTime opEnd;

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        videoLen = convertTime(video_len);
        now = convertTime(pos);
        opStart = convertTime(op_start);
        opEnd = convertTime(op_end);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("mm:ss");

        for (String command : commands) {
            result(df, command);
        }

        return now.format(df);
    }

    private static void result(DateTimeFormatter df, String command) {
        isOpening();


        if (command.equals("prev")) {
            if (now.isAfter(LocalTime.of(0, 0, 10))) {
                now = now.minusSeconds(10);
            } else {
                now = LocalTime.of(0, 0, 0);
            }
        } else {
            if (now.plusSeconds(10).isAfter(videoLen)) {
                now = videoLen;
            } else {
                now = now.plusSeconds(10);
            }
        }

        isOpening();
    }

    private static void isOpening() {
        if ((now.equals(opEnd) || now.isBefore(opEnd)) && (now.isAfter(opStart) || now.equals(opStart))) {
            now = opEnd;
        }
    }

    private LocalTime convertTime(String str) {
        String[] strArr = str.split(":");
        return LocalTime.of(0, Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1]));
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("10:55", "00:05", "00:15", "06:55", new String[]{"prev", "next", "next"}));
    }
}

