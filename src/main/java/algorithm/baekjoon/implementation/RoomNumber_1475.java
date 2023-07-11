package algorithm.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RoomNumber_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int sum = Integer.parseInt(bf.readLine());
        int[] nums = new int[10];

        while (sum > 0) {
            nums[sum % 10]++;
            sum /= 10;
        }

        int max = 1;
        for (int i = 0; i < 10; i++) {
            if((i == 6 || i == 9)) {
                continue;
            }
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        if (max < ((nums[6] + nums[9] + 1) /2))
            max = (nums[6] + nums[9] + 1) /2;

        System.out.println(max);
    }
}