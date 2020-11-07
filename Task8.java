import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//https://leetcode.com/problems/median-of-two-sorted-arrays/submissions/
public class Task {
  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

    int size = nums1.length + nums2.length;

    if(size == 0) return 0;

    double sum = 0;
    double result = 0;
    if(size <= 2){
      for(int i = 0; i < nums1.length; i++){
        sum += nums1[i];
      }
      for(int i = 0; i < nums2.length; i++){
        sum += nums2[i];
      }
      result = sum / (nums1.length + nums2.length);
    }
    else
    {
      int[] array1and2 = new int[nums1.length + nums2.length];
      System.arraycopy(nums1, 0, array1and2, 0, nums1.length);
      System.arraycopy(nums2, 0, array1and2, nums1.length, nums2.length);
      List<Integer> collect = Arrays.stream(array1and2).sorted().boxed().collect(Collectors.toList());
      while(true){
        if(collect.size() >= 3){
          collect.remove(0);
          collect.remove(collect.size()-1);
        }

        if(collect.size() <= 2){
          sum = collect.stream().reduce(0, Integer::sum);
          result = sum / collect.size();
          break;
        }
      }
    }

    return result;
  }
  public static void main(String[] args) {
    int[] nums1 = new int[]{1};
    int[] nums2 = new int[]{2,3,4,5,6,7,8,9};
    double res = findMedianSortedArrays(nums1, nums2);
    System.out.println(res);
  }
}
