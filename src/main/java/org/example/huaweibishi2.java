package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class huaweibishi2 {

    public static int countSources(int[] a) {
        Arrays.sort(a);

        int rec = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[i - 1] + 1) {
                rec++;
            }
        }
        return rec;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine().trim());
        int[] a = new int[n];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(tokenizer.nextToken());
        }

        System.out.println(countSources(a));
    }

}
