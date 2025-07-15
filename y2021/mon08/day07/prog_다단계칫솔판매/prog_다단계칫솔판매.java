package y2021.mon08.day07.prog_다단계칫솔판매;

import java.util.Arrays;
import java.util.HashMap;

public class prog_다단계칫솔판매 {

	static String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
	static String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
	static String[] seller = {"sam", "emily", "jaimie", "edward"};
	static int[] amount = {2, 3, 5, 4};
	
	static int[] cost;
	static HashMap<String, Integer> index = new HashMap<>(); // �ش� ������ �ε����� ����
	
	public static void main(String[] args) {

		cost = new int[enroll.length+1]; // ���� ���� ���� �ڽ��� index ��ġ�� �ֱ�
	
		for (int i = 0; i < enroll.length; i++) { // ��Ʈ�� 0, �������� 1���� ����
			index.put(enroll[i], i); 
		}
		for (int i = 0; i < seller.length; i++) {
			reward(index.get(seller[i]), amount[i]*100);
		}
		System.out.println(Arrays.toString(cost));
	}

	private static void reward(int currentIndex, int amount) {
		System.out.println("���� �Ǹſ� " + enroll[currentIndex]);
		System.out.println("���� �ݾ� " + amount);
		
		int nextAmount = amount*1/10; // �Ѱ��� ��
		if(nextAmount < 1) { // 1�� �̸��� ��쿡�� �ѱ��� �ʰ� �ڽ��� �� ����
			cost[currentIndex] += amount;
			return; // �׸��� �Ѱ����� ����
		}else {
			cost[currentIndex] += amount - nextAmount;
		}
		
		// �Ѱ��� �� �ִٸ�
		if(referral[currentIndex].equals("-")) { // ���� ��ġ�� ��Ʈ��� �������ʰ� �� ����
			return;
		}
		int referralIndex = index.get(referral[currentIndex]);
		reward(referralIndex, nextAmount);
	}
}
