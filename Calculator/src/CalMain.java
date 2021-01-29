import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class CalMain extends JFrame implements ActionListener{
	String[] str = {"CE", "계산", "+", "-", "X", "/"};	
	JTextField tx1, tx2;
	String numStr = "";
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
		tx1 = new JTextField(20);	//20칸
		np.add(is);
		np.add(tx1);
		
		for(int i=0;i<16;i++) {	//버튼 생성	(cp)
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
		
		JLabel rs = new JLabel("계산 결과");	//(sp)
		tx2 = new JTextField(20);	
		sp.add(rs);
		sp.add(tx2);
		
		setVisible(true);
	}
//내부 클래스로 기능 구현(이벤트리스너 사용)
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		
		if(str.equals("CE")) {
			numStr = "";
			tx1.setText(numStr);
			tx2.setText("");
		}
		else if(str.equals("계산")) {
			StringTokenizer st = new StringTokenizer(numStr, "+-X/", true);	//구분자
			int num1 = Integer.parseInt(st.nextToken());
			String op = st.nextToken();
			int num2 = Integer.parseInt(st.nextToken());
			switch(op) {//연산
			case "+" : tx2.setText(num1 + num2 + ""); break;
			case "-" : tx2.setText(num1 - num2 + ""); break;
			case "X" : tx2.setText(num1 * num2 + ""); break;
			case "/" : tx2.setText(num1 / num2 + ""); break;
			default: tx2.setText("오류"); break;
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

