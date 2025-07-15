package y2021.mon09.day11.prog_튜플;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class prog_튜플 {
	
	static String s = "{{123}}";

	public static void main(String[] args) {
		String tuple = s.substring(1, s.length()-1); // �� �ٱ��� �߰�ȣ�� ����
		ArrayList<String> list = new ArrayList<String>(); // �߰�ȣ�� ������ ���·� ���� ���ڿ� �迭 -> 2 / 2,1 / 2,1,3 / 2,1,3,4
		StringBuilder sb = new StringBuilder();// ���ڵ��� ��Ƽ� ���ڷ� ����� ���� SB
		
		boolean start = false; // �߰�ȣ�� ���ȴ��� ���� (�׷��� �ۿ��ִ� ��ǥ�� �ȿ��ִ� ��ǥ�� ����)
		for (int i = 0; i < tuple.length(); i++) {
			char c = tuple.charAt(i);
			
			if(c == '{') { // �߰�ȣ ����
				start = true;
			}
			else if(c == '}') { // �߰�ȣ ���� -> �ϳ��� Ʃ�� ���Ҹ� �ϼ� ��Ŵ
				list.add(sb.toString()); // list�� ����
				sb.setLength(0);
				start = false;
			}
			else {
				if(start) // �߰�ȣ�� ���� ���¿����� ��ǥ�� ���ڸ� ����
					sb.append(c);
			}
		}

		// ���ڿ��� ���̰� ���� ������ Ʃ�� ���ҵ��� ������� �����̹Ƿ� 
		list.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length()); // ���ڿ��� ���̰� ���� ������� ����
			}
		});
		
		// ���ĵ� ������ �״�� ��Ű�� ���� LinkedHashMap ���
		LinkedHashMap<Integer, Boolean> map = new LinkedHashMap<>();
		for (int i = 0; i < list.size(); i++) {
			String[] elements = list.get(i).split(","); // �߰�ȣ �ȿ��ִ� ��ǥ�� ��������
			
			for (int j = 0; j < elements.length; j++) {
				map.put(Integer.parseInt(elements[j]), true); // ������ ��ȯ & map�� ����(�ߺ��Ǵ� ���� ���⿡ ����)
			}
		}
		
		int idx = 0;
		int[] answer = new int[map.size()];
		for(Entry<Integer, Boolean> e : map.entrySet()) {
			answer[idx++] = e.getKey();
		}
		System.out.println(Arrays.toString(answer));
	}
}
