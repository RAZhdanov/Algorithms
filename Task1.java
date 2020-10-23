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

  static String sortString(String str) {
    char[] chars = str.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }

  public static void main(String[] args) throws IOException {

    try (InputStreamReader inStream = new InputStreamReader(System.in);
         BufferedReader buffer = new BufferedReader(inStream)) {

      String line = null;

      while ((line = buffer.readLine()) != null) {

        String finalLine = line;
        ArrayList<Pair<String, String>> pairs = new ArrayList<>(Arrays.stream(line.split(","))
                .map(x -> new Pair<>(x, sortString(x)))
                .collect(toList()));

        Map<String, List<Integer>> indexes = new HashMap<>();

        for(int i = 0; i < pairs.size(); i++){
          indexes.computeIfAbsent(pairs.get(i).getValue(), c-> new ArrayList<>()).add(i);
        }


        System.out.println(indexes.entrySet().stream().filter(x -> x.getValue().size() > 1).collect(toList()));

      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
