package y2025.mon07.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_나는야포켓몬마스터이다솜 {

    private static List<String> pokemonList; // 포켓몬 이름을 저장할 리스트
    private static Map<String, Integer> pokemonMap; // 포켓몬 이름과 인덱스를 매핑할 맵

    public static void main(String[] args) throws IOException {

        var inputStream = new BufferedReader(new InputStreamReader(System.in));
        var stringTokenizer = new StringTokenizer(inputStream.readLine());
        var stringBuilder = new StringBuilder();

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        pokemonList = new ArrayList<>(N);
        pokemonMap = new HashMap<>(N);

        for (int i = 0; i < N; i++) {
            String pokemonName = inputStream.readLine();
            pokemonList.add(pokemonName);
            pokemonMap.put(pokemonName, i + 1); // 포켓몬 이름과 인덱스를 1부터 시작하도록 저장
        }

        for (int i = 0; i < M; i++) {
            var input = inputStream.readLine();
            if (isNumber(input)) {
                var index = Integer.parseInt(input) - 1; // 입력은 1부터 시작하므로 -1
                stringBuilder.append(pokemonList.get(index));
            } else {
                stringBuilder.append(pokemonMap.get(input));
            }
            stringBuilder.append("\n");
        }
        System.out.print(stringBuilder);
    }

    private static boolean isNumber(String input) {
        if (input.charAt(0) >= '1' && input.charAt(0) <= '9') {
            return true;
        }
        return false;
    }
}
