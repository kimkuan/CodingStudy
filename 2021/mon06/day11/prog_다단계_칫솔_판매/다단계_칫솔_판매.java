package mon06.day11.prog_다단계_칫솔_판매;

import java.util.Arrays;
import java.util.HashMap;

public class 다단계_칫솔_판매 {
	static String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
	static String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
	static String[] seller = {"sam", "emily", "jaimie", "edward"};
	static int[] amount = {2, 3, 5, 4};
	
	static int[] result; // 각 판매원이 갖는 이익 (민호 제외)
	static HashMap<String, Integer> enrollOfIndex = new HashMap<String, Integer>(); // 판매원 이름, enroll에서의 인덱스 매칭

	public static void main(String[] args) {
		result = new int[enroll.length];
		
		for(int i = 0; i < enroll.length; i++) 
			enrollOfIndex.put(enroll[i], i);
		
		for(int i = 0; i < seller.length; i++) 
			calculateProfit(seller[i], amount[i]*100);

		System.out.println(Arrays.toString(result));
	}

	private static void calculateProfit(String sellerName, int price) {
		if(price == 0 || sellerName.equals("-")) 
			return;
		
		int index = enrollOfIndex.get(sellerName); // 해당 판매원의 인덱스
		int give = price / 10; // 금액의 10퍼센트
		int my = price - give; 
		
		result[index] += my;
		
		calculateProfit(referral[index], give);
	}
}
