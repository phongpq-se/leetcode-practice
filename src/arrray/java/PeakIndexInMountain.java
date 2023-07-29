package arrray.java;

public class PeakIndexInMountain {

    public static int peakIndexInMountainArray(int[] arr) {
        return binarySearch(arr, 0, arr.length - 1);
    }

    public static int binarySearch(int[] arr, int min, int max) {
        int mid = ((min + max) / 2);
        if (min == max) return min;
        else if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid;
        else {
            if (arr[mid] > arr[mid - 1]) return binarySearch(arr, mid + 1, max);
            else return binarySearch(arr, mid, mid - 1);
        }
    }


    public static void main(String[] args) {
        int[] input = {0, 2, 1, 0};
        int[] input01 = {3, 5, 3, 2, 0};
        int rs = peakIndexInMountainArray(input01);
        System.out.println(rs);
    }
}
