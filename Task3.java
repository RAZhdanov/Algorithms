import javafx.util.Pair;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task {
  public static int[] twoSum(int[] nums, int target) {

    List<Pair<Integer, Pair<Integer, List<Integer>>>> pairs = IntStream.range(0, nums.length)
            .mapToObj(
                    index_i ->
                            new Pair<>(
                                    index_i,
                                    new Pair<>(
                                            nums[index_i],
                                            IntStream.range(0, nums.length)
                                                    .filter(
                                                            index_j ->
                                                                    (index_i != index_j)).map(index_j -> nums[index_j]).

                                                    boxed().sorted((x, y) -> Math.abs(x) < Math.abs(y) ? 1 : -1).collect(Collectors.toList())
                                    )
                            )
            ).sorted((x, y) -> Math.abs(x.getKey()) < Math.abs(y.getKey()) ? 1 : -1).collect(Collectors.toList());



    List<Integer> resultList = new LinkedList<>();
    for(Pair<Integer, Pair<Integer, List<Integer>>> pair : pairs){

      resultList.clear();
      int result = pair.getValue().getKey();
      resultList.add(pair.getKey());

      for(Integer value : pair.getValue().getValue()){

        if(Math.abs(result + value) < Math.abs(target)){
          result += value;
          resultList.add(pairs.stream().filter(x -> x.getValue().getKey().equals(value)).findFirst().get().getKey());
        }
        else if(Math.abs(result + value) == Math.abs(target)){
          resultList.add(pairs.stream().filter(x -> x.getValue().getKey().equals(value) && x.getKey() != pair.getKey()).findFirst().get().getKey());
          if(resultList.size() > 2){
            break;
          }
          return resultList.stream().mapToInt(x -> x).sorted().toArray();
        }
      }
    }
    return null;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(twoSum(new int[]{2,1,9,4,4,56,90,3}, 8)));
  }
}
