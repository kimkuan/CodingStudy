package y2025.mon01.day28;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj_문자열집합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

        HashSet stringSet = new HashSet<String>();

        for (int i = 0; i < N; i++) {
            stringSet.add(br.readLine());
        }

        int includeCount = 0;

        for (int i = 0; i < M; i++) {
            if (stringSet.contains(br.readLine())) {
                includeCount++;
            }
        }

        System.out.println(includeCount);
    }
}
