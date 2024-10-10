package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2018 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        int lp = 1;
        int rp = 1;
        int sum = 1;
        int cnt = 1;
        while(rp != n) {
            System.out.println(sum + " " + lp + " " + rp);
            if(sum == n) {
                cnt++;
                rp++;
                sum += arr[rp];
            } else if(sum > n) {
                sum -= arr[lp];
                lp++;
            } else {
                rp++;
                sum += arr[rp];
            }
        }
        System.out.println(cnt);
    }
}
