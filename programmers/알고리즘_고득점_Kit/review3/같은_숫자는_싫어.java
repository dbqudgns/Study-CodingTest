package 알고리즘_고득점_Kit.review3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 같은_숫자는_싫어 {

    public static int[] solution(int[] arr) {

        int[] copyArray = new int[arr.length];
        int count = 1;

        int cur = 0;
        copyArray[0] = arr[0]; // 배열 arr의 크기는 자연수 이므로
        for (int i = 1; i < arr.length; i++) {
            if (copyArray[cur] != arr[i]) {
                copyArray[++cur] = arr[i];
                count++;
            }
        }

        return Arrays.copyOf(copyArray, count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];

        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        System.out.println(Arrays.toString(solution(arr)));
    }
}