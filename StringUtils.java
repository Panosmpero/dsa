public class StringUtils {

  // Time complexity: O(n), Space complexity: O(1)
  public boolean isPalindrome(String str) {
    validateString(str);
    int left = 0;
    int right = str.length() - 1;
    while (left < right) {
      System.out.println(str.charAt(left) + " " + str.charAt(right));
      if (str.charAt(left) != str.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

  // Time complexity: O(n), Space complexity: O(n)
  public String reverse(String str) {
    validateString(str);
    char[] charArray = str.toCharArray();
    int left = 0;
    int right = str.length() - 1;
    while (left < right) {
      char temp = charArray[left];
      charArray[left] = charArray[right];
      charArray[right] = temp;
      left++;
      right--;
    }
    return new String(charArray);
  }

  public String reverseLib(String str) {
    validateString(str);
    StringBuilder strBuilder = new StringBuilder(str);
    return strBuilder.reverse().toString();
  }

  private void validateString(String str) {
    if (str == null || str.isEmpty()) {
      throw new IllegalArgumentException("String cannot be null or empty");
    }
  }

  public static void main(String[] args) {
    StringUtils stringUtils = new StringUtils();
    String palindromeStr = "racecar";
    System.out.println("Is Palindrome: " + stringUtils.isPalindrome(palindromeStr));
    String strToReverse = "Hello, World!";
    System.out.println("Reversed String: " + stringUtils.reverse(strToReverse));
    System.out.println("Reversed String using Library: " + stringUtils.reverseLib(strToReverse));
  }
}
