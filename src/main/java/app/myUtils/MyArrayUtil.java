package app.myUtils;

import app.annotations.Author;
import app.annotations.MethodInfo;

import java.util.ArrayList;
import java.util.List;

public class MyArrayUtil {
    @Author(firstName = "Mykyta", lastName = "Herasymov")
    @MethodInfo(name = "mergeSort", type = "List<T>", description = "Recursively sorts a list using merge sort algorithm")
    public static <T extends Comparable<T>> List<T> mergeSort(List<T> arr) {
        if (arr.size() <= 1) {
            return arr;
        }

        int mid = arr.size() / 2;
        List<T> left = new ArrayList<>(arr.subList(0, mid));
        List<T> right = new ArrayList<>(arr.subList(mid, arr.size()));

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }
    @Author(firstName = "Serhii", lastName = "Herasymov")
    @MethodInfo(name = "merge", type = "List<T>", description = "Merges two sorted lists into one sorted list")
    private static <T extends Comparable<T>> List<T> merge(List<T> left, List<T> right) {
        List<T> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }

        while (i < left.size()) {
            result.add(left.get(i++));
        }

        while (j < right.size()) {
            result.add(right.get(j++));
        }

        return result;
    }
    @Author(firstName = "Olha", lastName = "Nikiforova")
    @MethodInfo(name = "binarySearch", type = "int", description = "Performs binary search on a list to find the target element's index")
    public static <T extends Comparable<T>> int binarySearch(List<T> array, T target) {
        int left = 0;
        int right = array.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Перевіряємо, чи знайшли шукане значення
            if (array.get(mid).compareTo(target) == 0) {
                return mid;
            }

            // Якщо шукане значення менше середнього, змінюємо праву границю
            if (array.get(mid).compareTo(target) < 0) {
                left = mid + 1;
            }
            // Інакше змінюємо ліву границю
            else {
                right = mid - 1;
            }
        }
        return -1;
    }

}