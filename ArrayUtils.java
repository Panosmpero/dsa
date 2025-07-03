public class ArrayUtils {

  public void print(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    ArrayUtils arrUtils = new ArrayUtils();
    arrUtils.print(new int[] { 5, 1, 23, 4, 5 });
  }
}
