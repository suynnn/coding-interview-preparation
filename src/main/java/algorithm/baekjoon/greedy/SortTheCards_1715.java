package algorithm.baekjoon.greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class SortTheCards_1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i =0 ; i< n; i++) {
            pq.add(sc.nextInt());
        }

        int sum = 0;
        while (pq.size() >= 2) {
            int tmp = pq.poll() + pq.poll();
            sum += tmp;
            pq.add(tmp);
        }

        System.out.println(sum);
    }
}