//https://leetcode.com/problems/reverse-integer/submissions/
public class Task {

  public static int reverse(int x) {

    try
    {
      String s = Integer.valueOf(x).toString();

      if(s.length() != 1 && s.charAt(s.length() - 1) == '0'){
        s = s.substring(0, s.length() - 1);
      }
      int n = s.length();

      char[] resultArray = new char[n];

      for(int i = 0; i < n; i++){
        char c = s.charAt(i);
        if(c == '-'){
          resultArray[i] = c;
          continue;
        }

        resultArray[ s.charAt(0) != '-' ? (n - (i + 1)) : ((n - 1) - (i - 1))] = c;

      }

      return Integer.parseInt(new String(resultArray));
    } catch(NumberFormatException e){
      return 0;
    }
  }

  public static void main(String[] args) {
    System.out.println(reverse(1534236469));
  }
}
