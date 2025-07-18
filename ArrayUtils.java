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

  public int findMin(int[] arr) {
    validateArray(arr);
    int min = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] < min) {
        min = arr[i];
      }
    }
    return min;
  }

  public int findSecondMax(int[] arr) {
    validateArray(arr);
    int max = Integer.MIN_VALUE;
    int secondMax = Integer.MIN_VALUE;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) {
        secondMax = max;
        max = arr[i];
      } else if (arr[i] > secondMax && arr[i] != max) {
        secondMax = arr[i];
      }
    }
    if (secondMax == Integer.MIN_VALUE) {
      throw new IllegalArgumentException("Array must contain at least two distinct elements");
    }
    return secondMax;
  }

  public void bubbleZeros(int[] arr) {
    validateArray(arr);
    int zeroTrackerIdx = 0;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0 && arr[zeroTrackerIdx] == 0) {
        arr[zeroTrackerIdx] = arr[i];
        arr[i] = 0;
      }

      // Move pointer if not at zero
      if (arr[zeroTrackerIdx] != 0) {
        zeroTrackerIdx++;
      }
    }
  }

  public int[] resize(int[] arr, int size) {
    validateArray(arr);
    int[] newArr = new int[size];
    for (int i = 0; i < arr.length; i++) {
      newArr[i] = arr[i];
    }
    return newArr;
  }

  public int findMissingNumber(int[] arr) {
    validateArray(arr);
    int n = arr.length;
    boolean[] seen = new boolean[n + 1];
    for (int num : arr) {
      if (num >= 0 && num <= n) {
        seen[num] = true;
      }
    }

    for (int i = 1; i <= n; i++) {
      if (!seen[i]) {
        return i;
      }
    }
    return -1; // If no missing number found, return -1
  }

  public int findMissingNumberFormula(int[] arr) {
    validateArray(arr);
    int n = arr.length + 1; // Since one number is missing
    int expectedSum = n * (n + 1) / 2;
    int actualSum = 0;
    for (int num : arr) {
      actualSum += num;
    }
    return expectedSum - actualSum; // The difference is the missing number
  }

  private void validateArray(int[] arr) {
    if (arr == null || arr.length == 0) {
      throw new IllegalArgumentException("Array cannot be null or empty");
    }
  }

  public static void main(String[] args) {
    ArrayUtils arrUtils = new ArrayUtils();
    arrUtils.print(new int[] { 5, 1, 23, 4, 5 });
    int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    arrUtils.print(arrUtils.removeEven(arr));
    arrUtils.print(arrUtils.reverse(arr, 0, arr.length - 1));
    System.out.println(arrUtils.findMin(arr));
    System.out.println(arrUtils.findSecondMax(new int[] { 9, 2, 3, 4, 5, 6, 7, 8, 9 }));
    int[] arrWithZeros = { 0, 1, 2, 0, 3, 4, 0, 5, 6 };
    arrUtils.bubbleZeros(arrWithZeros);
    arrUtils.print(arrWithZeros);
    int[] resizedArray = arrUtils.resize(arr, 15);
    System.out.println("Original array length: " + arr.length);
    System.out.println("Resized array length: " + resizedArray.length);
    int[] missingNumberArray = { 1, 2, 6, 4, 5 };
    System.out.println("Missing number: " + arrUtils.findMissingNumber(missingNumberArray));
    System.out.println("Missing number using formula: " + arrUtils.findMissingNumberFormula(missingNumberArray));
  }
}
