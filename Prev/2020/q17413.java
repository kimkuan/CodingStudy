import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q17413 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder tmp = new StringBuilder(); // �ӽ� �����
		StringBuilder ans = new StringBuilder(); // answer
		boolean flag = false; // �±װ� ���۵Ǿ����� Ȯ�ο�
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
		
			if( c == '<' || c == '>' ) {
				if(flag == false) { // '<'
					ans.append(tmp.reverse()); // ������ �Էµ� �Ϲ� ���ڿ� reverse�ؼ� append
					tmp.setLength(0);
					tmp.append(c); // < �߰�
					
					flag = true; // �±� ����
				}
				else { // '>'
					tmp.append(c); // > �߰�
					ans.append(tmp); // <���ڿ�>�� ans�� �߰�
					tmp.setLength(0);
					
					flag = false; // �±� ����
				}
			}
			else if(c == ' ') { 
				if(flag == false) { // �Ϲݹ��ڿ������� ��ĭ�̸� 
					tmp = tmp.reverse(); // reverse�ϰ�
					tmp.append(c); // ��ĭ�� ���ؼ�
					
					ans.append(tmp); // �Ųٷε� ���ڿ��� ans�� �߰�
					tmp.setLength(0);
				}
				else // �±׾ȿ� �ִ� �� ���ڿ��̶�� �׳� append
					tmp.append(c);
			}
			else
				tmp.append(c);
		}
		ans.append(tmp.reverse()); // ���� tmp�� ���� <>������ �� ���ڿ��� �Ǿ��� ���̰�, �Ϲ� ���ڿ��̾����� reverse
		
		System.out.println(ans);
	}
}
