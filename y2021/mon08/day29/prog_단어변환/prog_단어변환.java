package y2021.mon08.day29.prog_단어변환;

public class prog_단어변환 {

	static String begin = "hit";
	static String target = "cog";
	static String[] words = {"hot", "dot", "dog", "lot", "log"};
	static boolean[] selected;
	static int answer = 0;
	
	public static void main(String[] args) {

		// 1. target�� words�ȿ� �ִ� �� üũ
		// 1-1. ���ٸ� 0�� return 
		// 1-2. �ִٸ� ���ĺ��� �ϳ��� �����ذ��鼭 target���� ��ȯ
		
		// 2. dfs ������� ���ĺ��� ��ȯ (�ܾ��� ���̴� 10����)
		selected = new boolean[words.length];
		
		if(isPossible(target))
			getChangeCount(begin, 0);
		
		System.out.println(answer);
	}
	
	private static boolean isPossible(String target) {
		for (int i = 0; i < words.length; i++) {
			if(target.equals(words[i]))
				return true;
		}	
		return false;
	}
	
	private static void getChangeCount(String now, int changeCount) {
		if(now.equals(target)) {
			answer = changeCount;
			return;
		}
		
		// begin�� target�� ù��° ���ĺ����� ���氡���� �ܾ �ִ��� üũ 
		for (int i = 0; i < words.length; i++) {
			if(selected[i] || !compareWord(now, words[i])) continue;
			selected[i] = true;
			getChangeCount(words[i], changeCount+1); // ������ �� ��� ������
			selected[i] = false;
		}
	}
	
	// �� ���ڿ��� ���̰� 1������ üũ
	private static boolean compareWord(String now, String word) {
		int count = 0;
		for (int i = 0; i < now.length(); i++) {
			if(now.charAt(i) != word.charAt(i)) 
				count++;
		}
		return count == 1 ? true : false;
	}
}
