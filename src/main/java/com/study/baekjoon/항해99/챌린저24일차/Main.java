
package com.study.baekjoon.항해99.챌린저24일차;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class Solution {

    private boolean[] visited;
    private int answer, depth;
    private ArrayList<Node>[] graph;
    private ArrayList<Node> resultList;
    private Queue<Node> queue;

    public int solution(int n, int[][] edge) {
        depth = 0;
        queue = new ArrayDeque<>(n);
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge.length; i++) {
            int start = edge[i][0];
            int end = edge[i][1];
            graph[start].add(new Node(end, -1));
            graph[end].add(new Node(start, -1));
        }

        bfs();

        resultList.forEach(
                node -> {
                    if (node.depth == depth) {
                        answer++;
                    }
                }
        );


        return answer;
    }

    private void bfs() {
        ArrayList<Node> nodes = graph[1];
        visited[1] = true;
        resultList = new ArrayList<>();

        resultList.add(new Node(1, 0));

        for (Node node : nodes) {
            resultList.add(node);
            node.depth = 1;
            queue.add(node);
            visited[node.end] = true;
        }


        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (depth < node.depth) {
                depth = node.depth;
            }
            for (Node n : graph[node.end]) {
                if (!visited[n.end]) {
                    n.depth = node.depth + 1;
                    queue.add(n);
                    resultList.add(n);
                    visited[n.end] = true;
                }
            }

        }
    }

}

class Node {
    int end;
    int depth;

    public Node(int end, int depth) {
        this.end = end;
        this.depth = depth;
    }
}

public class Main {
    public static void main(String[] args) {
        int solution = new Solution().solution(6, new int[][]{
                {3, 6},
                {4, 3},
                {3, 2},
                {1, 3},
                {1, 2},
                {2, 4},
                {5, 2},
        });
        System.out.println(solution);
    }

}
