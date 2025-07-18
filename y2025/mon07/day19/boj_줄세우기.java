package y2025.mon07.day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    https://www.acmicpc.net/problem/10431
 */
public class boj_줄세우기 {

    private static int testCase; // 테스트 케이스 번호
    private static int result; // 테스트 케이스별 걸음 총합 수

    private static int[] sortedStudents; // 학생들의 번호를 저장할 배열
    private static int[] tempStudents; // 병합 정렬을 위한 임시 배열

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int P = Integer.parseInt(bufferedReader.readLine());

        // 테스트 케이스마다 학생들이 뒤로 물러난 걸음 수의 총합을 구한다.
        for (int i = 0; i < P; i++) {
            initResult();
            initStudents(bufferedReader.readLine());

            mergeSort(tempStudents, 0, tempStudents.length - 1);

            System.out.println(testCase + " " + result);
        }
    }

    private static void initResult() {
        result = 0; // 초기화
    }

    private static void initStudents(String input) {
        StringTokenizer tokenizer = new StringTokenizer(input);

        testCase = Integer.parseInt(tokenizer.nextToken()); // 첫번째 번호는 테스트 케이스 번호로 사용된다.

        int size = tokenizer.countTokens();

        sortedStudents = new int[size];
        tempStudents = new int[size]; // 병합 정렬을 위한 임시 배열

        for (int i = 0; i < size; i++) {
            sortedStudents[i] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    /**
     * 병합 정렬을 사용하여 학생들을 정렬하는 메소드.
     * 해당 함수를 재귀호출하여 가장 작은 단위로 분할 후 합병한다.
     * @param tempStudents
     * @param left
     * @param right
     */
    private static void mergeSort(int[] tempStudents, int left, int right) {
        if (left >= right) {
            return; // 배열의 크기가 1 이하인 경우 정렬할 필요 없음
        }

        int mid = (left + right) / 2;

        // 왼쪽 배열과 오른쪽 배열로 절반을 분할
        mergeSort(tempStudents, left, mid);
        mergeSort(tempStudents, mid + 1, right);

        // 분할된 배열을 병합
        merge(tempStudents, left, mid, right);
    }

    private static void merge(int[] tempStudents, int left, int mid, int right) {
        int tempLeft = left; // 왼쪽 배열의 시작 인덱스
        int tempMid = mid + 1; // 오른쪽 배열의 시작 인덱스
        int checkedIndex = left; // 정렬된 배열에 넣을 시작 인덱스

        for (int i = left; i <= right; i++) {
            tempStudents[i] = sortedStudents[i]; // 현재 상태의 배열을 임시 배열에 복사
        }

        while (tempLeft <= mid && tempMid <= right) {
            if (tempStudents[tempLeft] <= tempStudents[tempMid]) {
                // 왼쪽 배열의 값이 더 작거나 같으면 왼쪽 배열의 값을 선택
                sortedStudents[checkedIndex++] = tempStudents[tempLeft++];
            } else {
                // 오른쪽 배열의 값이 더 작으면 오른쪽 배열의 값을 선택
                // 이 때, tempLeft부터 mid까지의 원소들이 모두 tempMid 뒤로 이동해야 함.
                // 왼쪽 배열과 오른쪽 배열은 각각 정렬된 상태로 병합되기 때문에 tempLeft 보다 뒤에 있는 값들은 무조건 뒤로 이동이 필요하기 때문이다.
                result += (mid - tempLeft + 1);
                sortedStudents[checkedIndex++] = tempStudents[tempMid++];
            }
        }

        // 왼쪽 배열에 남아있는 값들을 추가
        while (tempLeft <= mid) {
            sortedStudents[checkedIndex++] = tempStudents[tempLeft++];
        }

        // 오른쪽 배열에 남아있는 값들을 추가
        while (tempMid <= right) {
            sortedStudents[checkedIndex++] = tempStudents[tempMid++];
        }
    }
}
