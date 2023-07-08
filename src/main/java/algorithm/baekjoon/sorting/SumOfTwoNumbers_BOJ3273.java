package algorithm.baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfTwoNumbers_BOJ3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[] sequence = new int[2000001];
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        while (st.hasMoreTokens()) {
            sequence[Integer.parseInt(st.nextToken())]++;

        }

        int x = Integer.parseInt(bf.readLine());
        int cnt = 0;

        st = new StringTokenizer(s, " ");
        while (st.hasMoreTokens()) {
            String tmp = st.nextToken();
            int num = x - Integer.parseInt(tmp);

            if (num < 0 || num == Integer.parseInt(tmp)) continue;

            if (sequence[num] > 0) {
                sequence[Integer.parseInt(tmp)] = 0;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
