package compare.the.triplets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = compareTriplets(a, b);
        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );
        bufferedReader.close();
        bufferedWriter.close();
    }
    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> score = new ArrayList<Integer>();
        Integer aScore = (a.get(0) > b.get(0) ? 1 : 0) + (a.get(1) > b.get(1) ? 1 : 0) + (a.get(2) > b.get(2) ? 1 : 0);
        Integer bScore = (b.get(0) > a.get(0) ? 1 : 0) + (b.get(1) > a.get(1) ? 1 : 0) + (b.get(2) > a.get(2) ? 1 : 0);
        score.add(aScore);
        score.add(bScore);
        return score;
    }

    static List<Integer> compareTriplets2(List<Integer> a, List<Integer> b) {
        List<Integer> win = new LinkedList<Integer>();
        int pointsAlice = ((a.get(0) > b.get(0)) ? 1 : 0) + ((a.get(1) > b.get(1)) ? 1 : 0) + ((a.get(2) > b.get(2)) ? 1 : 0);
        int pointsBob = ((a.get(0) < b.get(0)) ? 1 : 0) + ((a.get(1) < b.get(1)) ? 1 : 0) + ((a.get(2) < b.get(2)) ? 1 : 0);
        win.add(pointsAlice);
        win.add(pointsBob);
        return win;
    }

    static List<Integer> compareTriplets3(List<Integer> a, List<Integer> b) {
        int aWin = 0;
        int bWin = 0;
        List<Integer> win = new LinkedList<Integer>();
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i))
                ++aWin;
            else if (a.get(i) < b.get(i))
                ++bWin;

        }
        win.add(aWin);
        win.add(bWin);
        return win;
    }
}

