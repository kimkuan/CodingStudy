package y2021.mon08.day31.prog_문자열압축;

import java.util.ArrayList;

public class prog_문자열압축 {

	static String s = "abcabcabcabcdededededede";
	
	public static void main(String[] args) {
		
		int answer = s.length();
		
		// �ڸ��� ���� (1~���ڿ��� ��)
		for (int i = 1; i <= s.length()/2; i++) {
			System.out.println(i + "�� ����");
			ArrayList<String> list = new ArrayList<>();
			
			// SubString
			for(int j = 0; j < s.length(); j += i) {
				if(j+i < s.length()) {
					list.add(s.substring(j, j+i));
				}else {
					list.add(s.substring(j, s.length()));
				}
			}
			
			// ������ ���ڿ����� ó�����ֱ� ���� ������ ���ڿ� �߰�
			list.add("");
			
			// �ߺ� ���ڿ� ī��Ʈ
			StringBuilder sb = new StringBuilder();
			String before = "";
			int count = 1;
			for(String str : list) {
				if(str.equals(before))
					count++;
				else {
					sb.append(count > 1 ? count + before : before);
					count = 1;
					before = str;
				}
			}
			
			answer = Math.min(answer, sb.length());
		}
		System.out.println(answer);
	}

}
