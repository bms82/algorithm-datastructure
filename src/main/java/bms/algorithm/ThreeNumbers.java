package bms.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class ThreeNumbers {

    public static void main(String[] args) throws IOException {
        int res = 0, a = 0, b = 0, c = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (br.readLine() != null) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        }
        br.close();
        if (a >= b && b >= c) {
            res = b;
        } else if (b >= a && a >= c) {
            res = a;
        } else res = c;


        bw.write(res);


        bw.close();

    }

}