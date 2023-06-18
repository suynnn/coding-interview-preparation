package algorithm.baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class ATM_11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int sum = 0;
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                sum = tmp = arr[i];
            } else {
                sum += tmp + arr[i];
                tmp += arr[i];
            }
        }

        System.out.println(sum);
    }
}
