package com.study.baekjoon.알고리즘분류.슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        String dna = br.readLine();

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int aCount = 0;
        int cCount = 0;
        int gCount = 0;
        int tCount = 0;

        int left = 0;
        int right = p - 1;
        int result = 0;

        for (int i = left; i <= right; i++) {
            char c1 = dna.charAt(i);
            switch (c1) {
                case 'A':
                    aCount++;
                    break;
                case 'C':
                    cCount++;
                    break;
                case 'G':
                    gCount++;
                    break;
                case 'T':
                    tCount++;
                    break;
            }
        }


        right++;
        left++;

        while (right < s) {
            result = isValid(a, c, g, t, aCount, cCount, gCount, tCount, result);


            switch (dna.charAt(left-1)) {
                case 'A':
                    aCount--;
                    break;
                case 'C':
                    cCount--;
                    break;
                case 'G':
                    gCount--;
                    break;
                case 'T':
                    tCount--;
                    break;
            }

            switch (dna.charAt(right)) {
                case 'A':
                    aCount++;
                    break;
                case 'C':
                    cCount++;
                    break;
                case 'G':
                    gCount++;
                    break;
                case 'T':
                    tCount++;
                    break;
            }
            right++;
            left++;
        }
        result = isValid(a, c, g, t, aCount, cCount, gCount, tCount, result);
        System.out.println(result);

    }

    private static int isValid(int a, int c, int g, int t, int aCount, int cCount, int gCount, int tCount, int result) {
        if (a <= aCount && c <= cCount && g <= gCount && t <= tCount) {
            result++;
        }
        return result;
    }
}
