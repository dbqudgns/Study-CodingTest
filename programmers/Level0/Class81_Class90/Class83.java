package Level0.Class81_Class90;

import java.util.Scanner;

public class Class83 {

    public static String solution(String[] id_pw, String[][] db) {

        String id = id_pw[0];
        String pw = id_pw[1];

        int id_correct = 0; // db에 아이디가 일치하는 경우가 있을 경우

        for (int i = 0; i < db.length; i++) {
            if (db[i][0].equals(id)) {
               if (db[i][1].equals(pw)) return "login";
               else id_correct = 1;
            }
        }

        if (id_correct == 1) return "wrong pw";
        else return "fail";

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] id_pw = new String[2];
        for (int i = 0; i < id_pw.length; i++) {
            id_pw[i] = sc.next();
        }

        sc.nextLine();

        int x = sc.nextInt();
        String[][] db = new String[x][2];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < 2; j++) {
                db[i][j] = sc.next();
            }
            sc.nextLine();
        }

        System.out.println(solution(id_pw, db));
    }

}
