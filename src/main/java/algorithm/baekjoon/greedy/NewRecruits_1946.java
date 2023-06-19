package algorithm.baekjoon.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class NewRecruits_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bf.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bf.readLine());
            int [][] applicants = new int[n][2];
            for (int j = 0; j < n; j++) {
                String s = bf.readLine();
                StringTokenizer st = new StringTokenizer(s);
                applicants[j][0] = Integer.parseInt(st.nextToken());
                applicants[j][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(applicants, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            int max = applicants[0][1];
            int passer = 1;
            for (int k = 1;  k < n; k++) {
                if (max > applicants[k][1]) {
                    passer++;
                    max = applicants[k][1];
                }
            }

            bw.write(passer+"\n");
            bw.flush();

        }
        bw.close();
    }
}
