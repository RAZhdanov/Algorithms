https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class Task {

  public static int lengthOfLongestSubstring(String s) {
    char[] chars = s.toCharArray();

    List<Pair<Integer,Character>> listForward = new LinkedList<>();

    Set<Integer> sizes = new HashSet<Integer>();

    int iCurrentIndex = 0;
    for(int i = iCurrentIndex; i < chars.length; i++){
      for(int j = i; j < chars.length; j++){

        int finalJ = j;

        if(!listForward.isEmpty() && listForward.stream().anyMatch(x -> x.getValue() == chars[finalJ])){
          Optional<Pair<Integer, Character>> optionalPair = listForward.stream().filter(x -> x.getValue() == chars[finalJ]).findFirst();
          if(optionalPair.isPresent()){
            iCurrentIndex = optionalPair.get().getKey() + 1;
          }
          sizes.add(listForward.size());
          listForward.clear();
        }

        listForward.add(new Pair<>(j, chars[j]));

        if(j == chars.length - 1){
          sizes.add(listForward.size());
          listForward.clear();
        }
      }
    }


    Optional<Integer> max = sizes.stream().max(Comparator.naturalOrder());

    return max.orElse(0);
  }

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("arwvivbgvtybtnudd"));
  }
}
