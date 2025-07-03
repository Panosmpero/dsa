public class ArrayUtils {

  public void print(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public int[] removeEven(int[] arr) {
    int n = arr.length;
    int oddCount = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] % 2 != 0) {
        oddCount++;
      }
    }

    int[] result = new int[oddCount];
    int index = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] % 2 != 0) {
        result[index] = arr[i];
        index++;
      }
    }
    return result;
  }

  public int[] reverse(int[] numbers, int start, int end) {
    while (start < end) {
      int temp = numbers[start];
      numbers[start] = numbers[end];
      numbers[end] = temp;
      start++;
      end--;
    }
    return numbers;
  }

  public static void main(String[] args) {
    ArrayUtils arrUtils = new ArrayUtils();
    arrUtils.print(new int[] { 5, 1, 23, 4, 5 });
    int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    arrUtils.print(arrUtils.removeEven(arr));
    arrUtils.print(arrUtils.reverse(arr, 0, arr.length - 1));
  }
}
