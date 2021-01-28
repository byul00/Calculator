import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.*;

public class CalMain extends JFrame {
	public CalMain() {
		setTitle("계산기 프레임");
		setSize(450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//프레임 윈도우 닫으면 프로그램을 종료하도록 설정
		Container c = getContentPane();
		
		JPanel np = new JPanel();	//north부분
		JPanel cp = new JPanel(); 	//center부분
		JPanel sp = new JPanel(); 	//south부분
		
		np.setBackground(Color.LIGHT_GRAY);		//배경색
		cp.setLayout(new GridLayout(4,4,5,5));	//레이아웃 그리드로
		sp.setBackground(Color.yellow);	
		
		c.add(cp);		//위치 배치
		c.add(np, BorderLayout.NORTH);	
		c.add(sp, BorderLayout.SOUTH);
		
		JLabel is = new JLabel("수식입력");	//(np)
		JTextField tx = new JTextField(20);	//20칸
		np.add(is);
		np.add(tx);
		
		for(int i=0;i<16;i++) {	//버튼 생성	(cp)
			JButton[] b = new JButton[16];
			String[] str = {"CE", "계산", "+", "-", "X", "/"};
			if(i < 10) {
				b[i] = new JButton(Integer.toString(i));
			}
			else {
				b[i] = new JButton(str[i-10]);
			}
			cp.add(b[i]);
		}
		
		JLabel rs = new JLabel("계산 결과");	//(sp)
		JTextField tx2 = new JTextField(20);	
		sp.add(rs);
		sp.add(tx2);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new CalMain();
	}

}
