package 정렬;

public class 삽입정렬 {

    public static void insertionSort(int[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};

        insertionSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}