package y2021.mon08.day22.prog_위장;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class prog_위장 {
	
	static String[][] clothes = {{"yellowhat", "0"}, {"bluesunglasses", "1"}, {"green_turban", "0"}};

	static LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
	static int result = 0;
	
	public static void main(String[] args) {
		for (int i = 0; i < clothes.length; i++) {
			String category = clothes[i][1];

			if(map.containsKey(category))
				map.put(category, map.get(category)+1);
			else
				map.put(category, 1);
		}
		
		int i = 0;
		for(Entry<String, Integer> entry :  map.entrySet()) {
			if(i == 0)
				result += entry.getValue()+1;
			else
				result *= entry.getValue()+1;
			i++;
		}
		
		System.out.println(result-1); // ��� �� ���� ���� ��� ���ֱ�
		
	}


}

// 1. ī�װ����� ������
// (key-�ǻ��� ����, value-����)

// 2.���� ���ϱ� 
