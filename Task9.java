package leetcode.task5;
//https://leetcode.com/problems/longest-palindromic-substring/
public class Task5 {

  public static boolean isPalindrome(String subString){
    //Start from leftmost and rightmost corners of str
    int left = 0;
    int right = subString.length() - 1;

    while(right > left){
      if(subString.charAt(left++) != subString.charAt(right--)){
        return false;
      }
    }
    return true;
  }

  public static String longestPalindrome(String s) {
    int n = s.length();

    for(int i = n, k = 0; i > 0; i--, k++){ //number action

      int currentK = k;
      for(int j = 0; j < (n - i) + 1; j++){ //number of actions
        String substring = s.substring(j, n - currentK);
        boolean palindrome = isPalindrome(substring);
        if(palindrome){
          return substring;
        }
        currentK--;
      }
    }
    return "";
  }

  public static void main(String[] args) {
    System.out.println(longestPalindrome("babadbababd"));
  }
}
