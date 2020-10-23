package Task;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class Task {

  
  public static List<Map.Entry<String, List<Integer>>> parseStringArray(String[] strArray){

    List<Pair<String, String>> pairs = Arrays.stream(strArray).map(line -> Arrays.stream(line.split(",")).map(x -> {
      char[] chars = x.toCharArray();
      Arrays.sort(chars);
      return new Pair<>(x, new String(chars));
    }).collect(toList())).flatMap(Collection::stream).collect(toList());

    Map<String, List<Integer>> indexes = new HashMap<>();

    for(int i = 0; i < pairs.size(); i++){
      indexes.computeIfAbsent(pairs.get(i).getValue(), c-> new ArrayList<>()).add(i);
    }

    return indexes.entrySet().stream().filter(x -> x.getValue().size() > 1).collect(toList());
  }

  public static void main(String[] args) throws IOException {
      String[] array = new String[5];
      array[0] = "qwe";
      array[1] = "wqe";
      array[2] = "qwee";
      array[3] = "a";
      array[4] = "a";

    System.out.println(parseStringArray(array));

  }

}
