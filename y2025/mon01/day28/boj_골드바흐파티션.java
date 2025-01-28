package y2025.mon01.day28;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_골드바흐파티션 {

    private static int N = 1_000_000;

    public static void main(String[] args) throws Exception {
        
        int[] primeArray = new int[N+1]; // 배열 초기화 시 0 으로 디폴트 값을 가진다. 

        fillPrimeArray(primeArray);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(getPartitionCount(n, primeArray));
        }
    }

    private static void fillPrimeArray(int[] array) {
        for (int i = 2; i <= N; i++) {
            array[i] = i;
        }

        for (int i = 2; i <= N; i++) {
            if (array[i] == 0) {
                continue;
            }

            // 자기 자신을 제외한 배수를 0 으로 변경 
            for (int j = i+i; j <= N; j=j+i) {
                array[j] = 0;
            }
        }
    }

    private static int getPartitionCount(int n, int[] array) {
        int count = 0;
        int totalCount = n/2;

        for (int i = 2; i <= totalCount; i++) {
            if (array[i] != 0 && array[n-i] != 0) {
                count++;
            }
        }
        return count;
    }
}
