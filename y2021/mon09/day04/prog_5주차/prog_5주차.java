package y2021.mon09.day04.prog_5주차;

public class prog_5주차 {
	static String word = "AAAE";
	static int n = 5;
	static int count = 0;
	static int answer;
	static char[] arr = {'A', 'E', 'I' , 'O', 'U'};
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		
		dfs(0);
		System.out.println(answer);
	}
	
	private static void dfs(int depth) {
		if(depth > n) {
			return;
		}
		if(depth == word.length() && word.equals(sb.toString())) {
			answer = count;
			return;
		}
		
		System.out.println(sb.toString());
		System.out.println(count++);

		for(int i = 0; i < n; i++) {
			sb.append(arr[i]);
			dfs(depth+1);
			sb.setLength(sb.length()-1);
		}
	}
}

// A
// AA
// AAA
// AAAA
// AAAAA
// AAAAE
// AAAAI
// AAAAO
// AAAAU
// AAAE
// AAAEA
