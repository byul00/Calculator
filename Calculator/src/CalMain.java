import javax.swing.*;
import java.awt.*;
import java.util.*;

class InsertPanel extends JPanel{//North�� �Է�ĭ
	private JPanel ipanel;
	public JPanel getIpanel() {
		return ipanel;
	}
	public void setIpanel(JPanel ipanel) {
		this.ipanel = ipanel;
	}
	public InsertPanel() {
		ipanel.setLayout(new FlowLayout());
		ipanel.add(new JLabel(" �����Է�"));
		ipanel.add(new JTextField(20));	//20ĭ���� �� ũ��
	}
}

class ButtonPanel extends JPanel {//center�� ��ư��
	//3x4 ������ GridLayout ��ġ������ ����
	public ButtonPanel() {
		setLayout(new GridLayout(4, 4,5,5));
		JButton[] b = new JButton[16];	
		for(int i=0;i<10;i++) {//0~9������ ��ư
			b[i] = new JButton(Integer.toString(i));
		}
		b[10] = new JButton("CE");
		b[11] = new JButton("���");
		b[12] = new JButton("+");
		b[13] = new JButton("-");
		b[14] = new JButton("X");
		b[15] = new JButton("/");
		for(int i=0;i<b.length;i++) {
			add(b[i]);
		}
	}
}
class ResultPanel extends JPanel {//South�� ��� ��� ���
	public ResultPanel() {
		setLayout(new GridLayout(1,2, 5, 5));
		add(new JLabel("����� "));
		add(new JTextField(""));
	}
}
public class CalMain extends JFrame {
	public CalMain() {
		setTitle("���� ������");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//������ ������ ������ ���α׷��� �����ϵ��� ����
		Container c = getContentPane();
		
		//����Ʈ�ҿ� BorderLayout ��ġ������ ����
		c.setLayout(new BorderLayout());
		
		c.add(new InsertPanel().getIpanel(), BorderLayout.NORTH);
		c.add(new ButtonPanel(), BorderLayout.CENTER);	
		c.add(new ResultPanel(), BorderLayout.SOUTH);
		
		setSize(450, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new CalMain();
	}

}
