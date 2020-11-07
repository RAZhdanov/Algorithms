//https://leetcode.com/problems/palindrome-number/
public class Task {
  public static boolean isPalindrome(int x) {

    if(x < 0) return false;

    int currentValue = x;
    int size = 0;
    int step = 10;
    boolean flagTwoDigitSize = false;
    while(currentValue != 0){
      currentValue = currentValue / step;
      size++;
    }
    if(size == 2){
      flagTwoDigitSize = true;
    }

    if(flagTwoDigitSize){
      int firstDigit = x / 10;
      int lastDigit = x % 10;
      if(firstDigit != lastDigit){
        return false;
      }
    }
    else
    {
      for(int i = 0; i < size; i++){

        int firstDigit = forwardDigit(x, size, i+1);
        int lastDigit = forwardDigit(x, size, size-i);

        if(firstDigit != lastDigit){
          return false;
        }
      }
    }

    return true;
  }
  public static int forwardDigit(int n, int size, int index)
  {
    int i = 0;
    while (i != size - index){
      n /= 10;
      i++;
    }
    return backwardDigit(n);
  }
  public static int backwardDigit(int n)
  {
    return (n % 10);
  }
  public static void main(String[] args) {

    Integer val = 1410110141;
    System.out.println(isPalindrome(val));
  }
}
