package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class huaweibishi3 {

    static List<Integer>[] adj;
    static int[] visited;
    static int n, answer = 0;
    static int dfs(int node, int parent) {
        int childCount = 0;

        for (int neighbor : adj[node]) {
            if (neighbor != parent) {
                int childNeed = dfs(neighbor, node);
                if (childNeed == 0) {
                    answer++;
                    return 1;
                }
                childCount += childNeed;
            }
        }

        return childCount == 0 ? 0 : 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine();
        adj = new ArrayList[n];
        visited = new int[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        Pattern pattern = Pattern.compile("(\\d+):\\((\\d+)\\)(.*)");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            Matcher matcher = pattern.matcher(line);

            if (matcher.matches()) {
                int a = Integer.parseInt(matcher.group(1));
                int b = Integer.parseInt(matcher.group(2));
                String[] connections = matcher.group(3).trim().split(" ");

                if (b > 0) {
                    for (String conn : connections) {
                        int rec = Integer.parseInt(conn);
                        adj[a].add(rec);
                        adj[rec].add(b);
                    }
                }
            }
        }

        dfs(0, -1);

        System.out.println(answer);
    }

}
