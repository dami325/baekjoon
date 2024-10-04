package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1753최단경로 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());

            ArrayList<Node>[] graphs = new ArrayList[v + 1];
            int[] resultArr = new int[v + 1];
            boolean[] visited = new boolean[v + 1];

            Arrays.fill(resultArr, Integer.MAX_VALUE);

            for (int i = 1; i <= v; i++) {
                graphs[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());

                graphs[start].add(new Node(end, value));
            }

            dijkstra(startNode, graphs, resultArr, visited);

            StringBuilder sb = new StringBuilder();

            for (int i = 1; i < resultArr.length; i ++) {
                if (resultArr[i] == Integer.MAX_VALUE) {
                    sb.append("INF\n");
                }else{
                    sb.append(resultArr[i] + "\n");
                }
            }

            System.out.println(sb.toString());

        }
    }

    private static void dijkstra(int startNode, ArrayList<Node>[] graphs, int[] resultArr, boolean[] visited) {
        resultArr[startNode] = 0;  // startNode에 0을 설정
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(startNode, 0));

        while (!queue.isEmpty()) {
            Node qNode = queue.poll();
            int current = qNode.getEnd();
            if(visited[current])
                continue;
            visited[current] = true;

            for (Node node : graphs[current]) {
                int end = node.getEnd();
                int weight = node.getWeight();
                if(resultArr[end] > resultArr[current] + weight){
                    resultArr[end] = resultArr[current] + weight;
                    queue.add(new Node(end, resultArr[end]));
                }
            }
        }
    }
}

class Node implements Comparable<Node>{
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    public int getEnd() {
        return end;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}
