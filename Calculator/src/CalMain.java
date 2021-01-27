import javax.swing.*;
import java.awt.*;
import java.util.*;

class InsertPanel extends JPanel{//North에 입력칸
	private JPanel ipanel;
	public JPanel getIpanel() {
		return ipanel;
	}
	public void setIpanel(JPanel ipanel) {
		this.ipanel = ipanel;
	}
	public InsertPanel() {
		ipanel.setLayout(new FlowLayout());
		ipanel.add(new JLabel(" 수식입력"));
		ipanel.add(new JTextField(20));	//20칸정도 들어갈 크기
	}
}

class ButtonPanel extends JPanel {//center에 버튼들
	//3x4 격자의 GridLayout 배치관리자 생성
	public ButtonPanel() {
		setLayout(new GridLayout(4, 4,5,5));
		JButton[] b = new JButton[16];	
		for(int i=0;i<10;i++) {//0~9까지의 버튼
			b[i] = new JButton(Integer.toString(i));
		}
		b[10] = new JButton("CE");
		b[11] = new JButton("계산");
		b[12] = new JButton("+");
		b[13] = new JButton("-");
		b[14] = new JButton("X");
		b[15] = new JButton("/");
		for(int i=0;i<b.length;i++) {
			add(b[i]);
		}
	}
}
class ResultPanel extends JPanel {//South에 계산 결과 출력
	public ResultPanel() {
		setLayout(new GridLayout(1,2, 5, 5));
		add(new JLabel("계산결과 "));
		add(new JTextField(""));
	}
}
public class CalMain extends JFrame {
	public CalMain() {
		setTitle("계산기 프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//프레임 윈도우 닫으면 프로그램을 종료하도록 설정
		Container c = getContentPane();
		
		//컨텐트팬에 BorderLayout 배치관리자 설정
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
