package algorithm.baekjoon.linkedlist;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class keylogger_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(bf.readLine());

        for (int i = 0; i < t; i++) {
            String str = bf.readLine();
            LinkedList<Character> list = new LinkedList<>();
            ListIterator iter = list.listIterator();

            for (int j = 0; j < str.length(); j++) {
                switch (str.charAt(j)) {
                    case '<' :
                        if (iter.hasPrevious())
                            iter.previous();
                        break;
                    case '>':
                        if (iter.hasNext())
                            iter.next();
                        break;
                    case '-':
                        if (iter.hasPrevious()) {
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    default:
                        iter.add(str.charAt(j));
                        break;
                }
            }

            for (char c : list)
                bw.write(c);

            bw.flush();
            System.out.println();
        }
        bw.close();
    }
}
