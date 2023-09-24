/**
 * This program contains methods to check if an array is a max or min heap.
 */

public class CheckHeap {
    /**
     * Check if an array is a max heap.
     * @param array array to check
     * @return boolean value.
     */
    public static boolean isMaxHeap(int[] array) {
        boolean maxHeap = true;
        int n = array.length;

        for (int i = (n / 2) - 1; i >= 0; i--) {
            int left = (2 * i) + 1;
            int right = (2 * i) + 2;

            if (left < n && array[left] > array[i]) {
                maxHeap = false;
                break;
            }
            if (right < n && array[right] > array[i]) {
                maxHeap = false;
                break;
            }
        }

        return maxHeap;
    }

    /**
     * Check if an array is a min heap.
     * @param array array to check.
     * @return boolean value.
     */
    public static boolean isMinHeap(int[] array) {
        int n = array.length;
        boolean isMinHeap = true;

        for (int i = (n / 2) - 1; i >= 0; i--) {
            int left = (2 * i) + 1;
            int right = (2 * i) + 2;

            if (left < n && array[left] < array[i]) {
                isMinHeap = false;
                break;
            }
            if (right < n && array[right] < array[i]) {
                isMinHeap = false;
                break;
            }
        }

        return isMinHeap;
    }

    public static void main(String[] args) {
        int[] array = {10, 5, 3, 4, 1};
        System.out.println(isMaxHeap(array));
        System.out.println(isMinHeap(array));
    }
}