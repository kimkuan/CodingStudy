package y2025.mon01.day29;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_에라토스테네스의체 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] primeArray = new int[N+1];
        
        fillPrimeArray(primeArray, N);

        System.out.println(getResult(primeArray, N, K));
    }

    private static void fillPrimeArray(int[] primeArray, int n) {
        // 1. 2부터 N까지 모든 정수를 적는다. 
        for (int i = 2; i <= n; i++) {
            primeArray[i] = i;
        }
    }

    private static int getResult(int[] primeArray, int n, int k) {
        int index = 0;
        int result = 0;

        // 2. 아직 지우지 않은 수 중 가장 작은 수를 찾는다.
        for (int i = 2; i <= n; i++) {
            if (primeArray[i] == 0) {
                continue;
            }
            
            for (int j = i; j <= n; j=j+i) {
                // 3. P 를 지우고, 아직 지우지 않은 P의 배수를 크기 순서대로 지운다. 
                if (primeArray[j] > 0) {
                    primeArray[j] = 0;
                    index++;

                    if (index == k) {
                        result = j;
                    }
                }
            }
        }

        return result;
    }
}