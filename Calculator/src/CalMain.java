import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.*;

public class CalMain extends JFrame {
	public CalMain() {
		setTitle("���� ������");
		setSize(450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//������ ������ ������ ���α׷��� �����ϵ��� ����
		Container c = getContentPane();
		
		JPanel np = new JPanel();	//north�κ�
		JPanel cp = new JPanel(); 	//center�κ�
		JPanel sp = new JPanel(); 	//south�κ�
		
		np.setBackground(Color.LIGHT_GRAY);		//����
		cp.setLayout(new GridLayout(4,4,5,5));	//���̾ƿ� �׸����
		sp.setBackground(Color.yellow);	
		
		c.add(cp);		//��ġ ��ġ
		c.add(np, BorderLayout.NORTH);	
		c.add(sp, BorderLayout.SOUTH);
		
		JLabel is = new JLabel("�����Է�");	//(np)
		JTextField tx = new JTextField(20);	//20ĭ
		np.add(is);
		np.add(tx);
		
		for(int i=0;i<16;i++) {	//��ư ����	(cp)
			JButton[] b = new JButton[16];
			String[] str = {"CE", "���", "+", "-", "X", "/"};
			if(i < 10) {
				b[i] = new JButton(Integer.toString(i));
			}
			else {
				b[i] = new JButton(str[i-10]);
			}
			cp.add(b[i]);
		}
		
		JLabel rs = new JLabel("��� ���");	//(sp)
		JTextField tx2 = new JTextField(20);	
		sp.add(rs);
		sp.add(tx2);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new CalMain();
	}

}
