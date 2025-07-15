package y2021.mon10.day31.boj_빗물;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_빗물 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] height = new int[W];
		
		int maxHeight = 0;
		int maxHeightIndex = 0;
		int heightSum = 0;
		
		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < W; i++) {
			height[i] = Integer.parseInt(st.nextToken());
			
			// ���� ���� ������ ���̿� �ε����� ã��
			if(height[i] > maxHeight) {
				maxHeight = height[i];
				maxHeightIndex = i;
			}
			// ������� �� ���ϱ�
			heightSum += height[i];
		}
		
		int total = 0; // ��ü ���̸� ������ ����
		int prevHeight = 0; // ���� ������ ���̿� ���� ���� ����
		
		// 1. ���� ���� ���븦 �������� ���� ����
		for(int i = 0; i < maxHeightIndex; i++) {
			// ���� ���̿� ������ ��, ���� ���̰� �� ũ�� ���� ���� ����. (���� ���̰� �� ������ ���� ���� ����)
			if(height[i] > prevHeight)
				prevHeight = height[i];
			
			total += prevHeight;
		}
		
		prevHeight = 0; // �ʱ�ȭ
		
		// 2. ���� ���� ���븦 �������� ���������� ����
		for(int i = W-1; i >= maxHeightIndex; i--) {
			// ���� ���̿� ������ ��, ���� ���̰� �� ũ�� ���� ���� ����. (���� ���̰� �� ������ ���� ���� ����)
			if(height[i] > prevHeight)
				prevHeight = height[i];
			
			total += prevHeight;
		}
		
		// ������ �� = ��ü ���� - ������� ������ ��
		System.out.println(total - heightSum);	
	}
}
