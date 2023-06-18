package algorithm.baekjoon.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class NumberTying_1744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Integer[] arr_boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(arr_boxed, Collections.reverseOrder());

        int[] negatives = new int[n];
        int tmp = -1;
        for (int i = 0, k = 0; i < arr_boxed.length; i++) {
            if (arr_boxed[i] <= 0) {
                negatives[k++] = arr_boxed[i];
                if(tmp == -1) {
                    tmp = i;
                }
            }
        }

        if(tmp != -1) {
            Arrays.sort(negatives);
            for (int i = tmp, k = 0; i < arr_boxed.length; i++) {
                arr_boxed[i] = negatives[k++];
            }
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (n == 1) {
                sum += arr_boxed[i];
            } else if (arr_boxed[i] == 0) {
                if(i != n-1) {
                    if (arr_boxed[i+1] >= 0) {
                        sum += arr_boxed[i];
                    } else {
                        sum += ((long) arr_boxed[i] * arr_boxed[i+1]);
                        i++;
                    }
                } else {
                    sum += arr_boxed[i];
                }
            } else if (arr_boxed[i] < 0) {
                if (i != n-1) {
                    if (arr_boxed[i+1] <= 0) {
                        sum += ((long) arr_boxed[i] * arr_boxed[i+1]);
                        i++;
                    } else {
                        sum += arr_boxed[i];
                    }
                } else {
                    sum += arr_boxed[i];
                }
            } else if (arr_boxed[i] == 1) {
                sum += arr_boxed[i];
            } else if (arr_boxed[i] > 0) {
                if (i != n-1) {
                    if (arr_boxed[i+1] > 1) {
                        sum += ((long) arr_boxed[i] * arr_boxed[i+1]);
                        i++;
                    } else {
                        sum += arr_boxed[i];
                    }
                } else {
                    sum += arr_boxed[i];
                }
            }
        }

        System.out.println(sum);
    }
}
