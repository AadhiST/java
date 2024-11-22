public class search {
    public static void main(String[] args) {
        int[] array = {5, 3, 8, 4, 2};
        System.out.println("Sequential Search: " + sequentialSearch(array, 4));
        System.out.println("Binary Search: " + binarySearch(array, 4));
        bubbleSort(array);
        System.out.print("Sorted Array: ");
        for (int num : array) System.out.print(num + " ");
    }
    public static int sequentialSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) return i;
        }
        return -1;
    }
    public static int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) return mid;
            if (array[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
