package algorithm.baekjoon.linkedlist;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Editor_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String earlyStr = bf.readLine();
        int m = Integer.parseInt(bf.readLine());

        LinkedList<Character> editor = new LinkedList<>();
        for (char c : earlyStr.toCharArray())
            editor.add(c);

        ListIterator cursor = editor.listIterator();

        while (cursor.hasNext())
            cursor.next();

        while (m > 0) {
            String command = bf.readLine();

            switch (command.charAt(0)) {
                case 'L' :
                    if (cursor.hasPrevious())
                        cursor.previous();
                    break;
                case 'D' :
                    if (cursor.hasNext())
                        cursor.next();
                    break;
                case 'B' :
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                    break;
                case 'P' :
                    cursor.add(command.charAt(2));
                    break;
            }
            m--;
        }

        for (char c : editor) {
            bw.write(c);
        }

        bw.flush();
        bw.close();
    }
}
