package y2021.mon10.day24.boj_단어맞추기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_단어맞추기 {
	
	static int[] alpha = new int[26]; // A ~ Z���� ����� �� �ִ� ���ĺ��� ����
	static char[] word; // ���� �ܾ�

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			String str = br.readLine();
			word = str.toCharArray();
			nextWord();
			sb.append(String.valueOf(word) + "\n");
		}
		System.out.print(sb.toString());
	}
	
	private static void nextWord() {
		int i = word.length - 1;

		// ���� ������ �ܾ� ã���鼭 ���� ���ĺ� �����
		for (; i >= 0; i--) {
			int index = word[i] - 'A';
			
			// ���� ���ĺ� �����
			alpha[index]++;
			
			// ���� ��ġ�� ���� �� �ִ� ���ĺ��� �ִ���
			int nextAlpha = chooseAlpha(index);
			if(nextAlpha >= 0)
				break;
		}
		
		// ���� �ܾ ���� ���������� ������ �ܾ���
		if(i == -1) 
			return;
		
		// ���� ������ �ܾ� ã���鼭 ���� ��ġ�� ���� ���ĺ� �ֱ�
		boolean start = true;
		for(; i < word.length; i++) {
			int index = word[i] - 'A';
			int nextAlpha;
			
			if(start) { // ù��°�� ���� ���ĺ��� �������� ū ���ĺ��� �� �� �ְ�
				nextAlpha = chooseAlpha(index); 
				start = false;
			}
			else { // �������� ������ ���ĺ����� ���������� ��������
				nextAlpha = chooseAlpha(-1);
			}
			
			word[i] = (char)(nextAlpha + 'A');
			alpha[nextAlpha]--;
		}
	}
	
	private static int chooseAlpha(int start) {
		int index = -1; // ����� �� �ִ� ���ĺ��� ������ -1
		
		// start�� 0�� �ƴϸ� �� ���� ���ĺ� ���� ã�ƾ���
		for (int i = start+1; i < alpha.length; i++) {
			if(alpha[i] > 0) {
				index = i;
				break;
			}
		}
		return index;
	}

}

// 1. �� ������ ���ĺ� ���� ���� (��� ������ �����)
// 2. �� ��° ���ĺ��� ����� 
// 2-1. ���� �� �� �ִ� ���ĺ��� ���� ���ĺ����� ���ĸ� ��� O
// 2-2. ���� �� �� �ִ� ���ĺ��� ���� ���ĺ����� �����̸� ��� X -> ����° ���ĺ��� ����
// 3. ���ĺ��� �����ٸ� ���������� ���ĺ����� ���.
