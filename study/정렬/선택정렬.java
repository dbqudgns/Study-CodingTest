package 정렬;

public class 선택정렬 {

    public static void selectionSort(int[] arr) {
        int length = arr.length;

        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};

        selectionSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}