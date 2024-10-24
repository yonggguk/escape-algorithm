package binarysearch;

import java.io.*;
import java.util.*;

public class Boj2805 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int answer = 0;
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(max < arr[i]) max = arr[i];
        }
        long lt = 0, rt = max;
        while(lt <= rt){
            long mid = (lt + rt) / 2;
            long cutSum = 0;
            for(int i = 0; i < n; i++){
                cutSum += (arr[i] - mid) >= 0 ? (arr[i] - mid) : 0;
            }
            if(cutSum >= m){
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        System.out.println(rt);
    }
}