package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj5568 {

    static int n;
    static int k;
    static int[] arr;
    static List<String> answer =new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        List<Integer> temp = new ArrayList<>();
        bfs(k, temp);
        System.out.println(answer.size());
    }

    public static void bfs(int cnt, List<Integer> temp) {
        if(cnt == 0) {
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < k; i++) {
                result.append(arr[temp.get(i)]);
            }
            if(!answer.contains((result.toString()))) {
                answer.add((result.toString()));
            }
        }

        for(int i = 0; i < n; i++) {
            if(!temp.contains(i)) {
                temp.add(i);
                bfs(cnt - 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
