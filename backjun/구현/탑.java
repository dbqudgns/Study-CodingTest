package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        int size = Integer.parseInt(br.readLine());
        token = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        Stack<int[]> stack = new Stack<>();

        for (int i = 1; i <= size; i++) {

            int height = Integer.parseInt(token.nextToken());

            while(!stack.isEmpty()) {

                int[] peek = stack.peek();

                if (peek[1] < height) {
                    stack.pop();
                }
                else if (peek[1] >= height) {
                    sb.append(peek[0]).append(" ");
                    break;
                }
            }

            if (stack.isEmpty()) {
                sb.append("0 ");
            }

            stack.push(new int[]{i, height});
        }

        System.out.print(sb.toString());
    }
}