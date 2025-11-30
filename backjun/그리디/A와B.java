package 그리디;

import java.io.*;

public class A와B {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        StringBuilder s = new StringBuilder(S);
        StringBuilder t = new StringBuilder(T);

        while(s.length() < t.length()) {
            if (t.charAt(t.length()-1) == 'A') {
                t.deleteCharAt(t.length()-1);
            }
            else if (t.charAt(t.length()-1) == 'B'){
                t.deleteCharAt(t.length()-1);
                t.reverse();
            }
        }

        if (s.toString().equals(t.toString())) System.out.println(1);
        else System.out.println(0);
    }

}
