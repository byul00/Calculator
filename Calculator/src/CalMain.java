import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class CalMain extends JFrame implements ActionListener{
	String[] str = {"CE", "���", "+", "-", "X", "/"};	
	JTextField tx1, tx2;
	String numStr = "";
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
		tx1 = new JTextField(20);	//20ĭ
		np.add(is);
		np.add(tx1);
		
		for(int i=0;i<16;i++) {	//��ư ����	(cp)
			JButton[] b = new JButton[16];
			if(i < 10) {
				b[i] = new JButton(Integer.toString(i));
			}
			else {
				b[i] = new JButton(str[i-10]);
			}
			if(i>11) {
				b[i].setBackground(Color.CYAN);
			}
			cp.add(b[i]);
			b[i].addActionListener(this);
		}
		
		JLabel rs = new JLabel("��� ���");	//(sp)
		tx2 = new JTextField(20);	
		sp.add(rs);
		sp.add(tx2);
		
		setVisible(true);
	}
//���� Ŭ������ ��� ����(�̺�Ʈ������ ���)
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		
		if(str.equals("CE")) {
			numStr = "";
			tx1.setText(numStr);
			tx2.setText("");
		}
		else if(str.equals("���")) {
			StringTokenizer st = new StringTokenizer(numStr, "+-X/", true);	//������
			int num1 = Integer.parseInt(st.nextToken());
			String op = st.nextToken();
			int num2 = Integer.parseInt(st.nextToken());
			switch(op) {//����
			case "+" : tx2.setText(num1 + num2 + ""); break;
			case "-" : tx2.setText(num1 - num2 + ""); break;
			case "X" : tx2.setText(num1 * num2 + ""); break;
			case "/" : tx2.setText(num1 / num2 + ""); break;
			default: tx2.setText("����"); break;
			}
			tx1.setText(numStr);
		}else  {
			numStr +=str;
			tx1.setText(str);
		}
	}
	public static void main(String[] args) {
		new CalMain();
	}

}

