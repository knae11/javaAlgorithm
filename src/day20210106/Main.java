package day20210106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jdk.swing.interop.SwingInterOpUtils;

public class Main {
/* 제출용 template

import java.util.*;
import java.io.*;

public class Main{
	public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        if (Integer.bitCount(n) <= k) {
            System.out.println("0");
            return;
        }

        int newCount = 1;
        while (Integer.bitCount(n + newCount) > k) {
            newCount++;
        }
        System.out.println(newCount);


	}
}

 */

    private static void bj1009() throws IOException {
        int[][] remains = {
            {10},
            {1},
            {6, 2, 4, 8},
            {1, 3, 9, 7},
            {6, 4},
            {5},
            {6},
            {1, 7, 9, 3},
            {6, 8, 4, 2},
            {1, 9}
        };
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ts = Integer.parseInt(br.readLine());
        for (int i = 0; i < ts; i++) {
            String[] pair = br.readLine().split(" ");
            int a = Integer.parseInt(pair[0]) % 10;
            int b = Integer.parseInt(pair[1]);
            if (a == 0 || a == 1 || a == 5 || a == 6) {
                System.out.println(remains[a][0]);
            } else if (a == 4 || a == 9) {
                System.out.println(remains[a][b % 2]);
            } else {
                System.out.println(remains[a][b % 4]);
            }

        }
    }

    private static void bj1076() throws IOException {
        Map<String, Integer> resistance = new HashMap<>(Map.of(
            "black", 0,
            "brown", 1,
            "red", 2,
            "orange", 3,
            "yellow", 4,
            "green", 5,
            "blue", 6,
            "violet", 7,
            "grey", 8,
            "white", 9
        ));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();
        String input2 = br.readLine();
        String input3 = br.readLine();
        int two = resistance.get(input1) * 10 + resistance.get(input2);
        if (two == 0) {
            System.out.println("0");
        } else {
            StringBuilder answer = new StringBuilder();
            answer.append(two);
            answer.append("0".repeat(resistance.get(input3)));
            System.out.println(answer);
        }

    }


    private static void bj1052() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        if (Integer.bitCount(n) <= k) {
            System.out.println("0");
            return;
        }

        int newCount = 1;
        while (Integer.bitCount(n + newCount) > k) {
            newCount++;
        }
        System.out.println(newCount);

    }


    public static void main(String[] args) throws IOException {

        bj1052();
    }


}
