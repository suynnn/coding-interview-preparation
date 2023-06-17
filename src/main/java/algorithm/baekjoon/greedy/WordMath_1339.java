package algorithm.baekjoon.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class WordMath_1339 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] alphabets = new int[26];
        int sum = 0;

        String [] sArr = new String[n];
        for (int i = 0; i < n; i++) {
            sArr[i] = sc.next();
        }

        for (int i = 0; i < n; i++) {
            int num = (int) Math.pow(10, sArr[i].length()-1);

            for (int j = 0; j < sArr[i].length(); j++) {
                alphabets[(int)sArr[i].charAt(j) - 65] += num;
                num /= 10;
            }
        }

        Integer[] alphabets_boxed = Arrays.stream(alphabets).boxed().toArray(Integer[]::new);
        Arrays.sort(alphabets_boxed, Collections.reverseOrder());

        int idx = 9;
        int i = 0;
        while(alphabets_boxed[i] > 0) {
            sum += alphabets_boxed[i] * idx;
            idx--;
            i++;
        }

        System.out.println(sum);
    }
}
