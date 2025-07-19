package y2025.mon07.day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    https://www.acmicpc.net/problem/10431
 */
public class boj_줄세우기_2 {

    private static int testCase; // 테스트 케이스 번호
    private static int result; // 테스트 케이스별 걸음 총합 수
    private static int[] students; // 학생들의 번호를 저장할 배열

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int P = Integer.parseInt(bufferedReader.readLine());

        // 테스트 케이스마다 학생들이 뒤로 물러난 걸음 수의 총합을 구한다.
        for (int i = 0; i < P; i++) {
            initResult();
            initStudents(bufferedReader.readLine());

            insertionSort();

            stringBuilder.append(testCase);
            stringBuilder.append(" ");
            stringBuilder.append(result);
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static void initResult() {
        result = 0; // 초기화
    }

    private static void initStudents(String input) {
        StringTokenizer tokenizer = new StringTokenizer(input);

        testCase = Integer.parseInt(tokenizer.nextToken()); // 첫번째 번호는 테스트 케이스 번호로 사용된다.

        int size = tokenizer.countTokens();

        students = new int[size];

        for (int i = 0; i < size; i++) {
            students[i] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    /**
     * 삽입 정렬을 통한 줄 서기 구현 O(N^2)
     */
    private static void insertionSort() {
        int size = students.length;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) { // 맨 앞부터 i-1까지 비교해 정렬하며 한 칸씩 뒤로 보낸다.
                if (students[i] < students[j]) {
                    int temp = students[j];
                    students[j] = students[i];
                    students[i] = temp;
                    result++;
                }
            }
        }
    }
}
