package y2021.mon09.day25.prog_영어끝말잇기;

import java.util.HashSet;

public class prog_영어끝말잇기 {

	static int n = 2;
	static String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
	
	public static void main(String[] args) {
		
		HashSet<String> set = new HashSet<>();
		char lastChar;
		int[] answer = new int[2]; // (Ʋ�� ����� ��ȣ, �� ��° ���ʿ��� Ʋ�ȴ���)
		
		set.add(words[0]); // ù��° �ܾ�
		lastChar = words[0].charAt(words[0].length()-1); // ù��° �ܾ��� ������ ����
		
		// �ι�° �ܾ���� üũ
		for (int i = 1; i < words.length; i++) {
			
			// 1. ���� ����� ���� �ܾ��� ������ ���ڿ� ���� �ܾ��� ù��° ���ڸ� ��
			// 2. ���� ����� ���� �ܾ����� Ȯ��
			if(lastChar != words[i].charAt(0) || set.contains(words[i])) {
				// gameout
				answer[0] = (i % n) + 1;
				answer[1] = (i / n) + 1;
				break;
			}
			else {
				set.add(words[i]);
				lastChar = words[i].charAt(words[i].length()-1);
			}
		}
		
		System.out.println(answer[0]);
		System.out.println(answer[1]);
	}

}
