package calculator;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import formula.FoAdd;
import formula.FoDefault;
import formula.FoDivide;
import formula.FoFactorial;
import formula.FoMultiply;
import formula.FoPower;
import formula.FoSubtract;
import formula.IFoTwoVariable;

public class CalculatorUI implements ActionListener {

	JFrame frame;
	JTextField textField;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[12];
	JButton addB, subB, mulB, divB;
	JButton facB, powB, B, B2;
	JButton decB, equB, delB, clrB;
	JPanel panel;

	double num1 = 0, num2 = 0, result = 0;
	char operator;

	CalculatorUI() {
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(470, 550);
		frame.setLayout(null);

		textField = new JTextField();
		textField.setBounds(50, 25, 350, 50);
		textField.setEditable(false);

		addB = new JButton("+");
		subB = new JButton("-");
		mulB = new JButton("*");
		divB = new JButton("/");
		decB = new JButton(".");
		equB = new JButton("=");
		delB = new JButton("Delete");
		clrB = new JButton("Clear");
		facB = new JButton("!");
		powB = new JButton("^");
		B = new JButton("?");
		B2 = new JButton("??");

		functionButtons[0] = addB;
		functionButtons[1] = subB;
		functionButtons[2] = mulB;
		functionButtons[3] = divB;
		functionButtons[4] = decB;
		functionButtons[5] = equB;
		functionButtons[6] = delB;
		functionButtons[7] = clrB;
		functionButtons[8] = facB;
		functionButtons[9] = powB;
		functionButtons[10] = B;
		functionButtons[11] = B2;

		for (int i = 0; i < 12; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFocusable(false);
		}

		for (int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFocusable(false);
		}

		delB.setBounds(50, 430, 145, 50);
		clrB.setBounds(205, 430, 145, 50);

		panel = new JPanel();
		panel.setBounds(50, 100, 350, 300);
		panel.setLayout(new GridLayout(4, 5, 10, 10));

		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addB);
		panel.add(facB);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subB);
		panel.add(powB);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulB);
		panel.add(B);
		panel.add(decB);
		panel.add(numberButtons[0]);
		panel.add(equB);
		panel.add(divB);
		panel.add(B2);

		frame.add(panel);
		frame.add(delB);
		frame.add(clrB);
		frame.add(textField);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		CalculatorUI calc = new CalculatorUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		IFoTwoVariable formula;
		for (int i = 0; i < 10; i++) {
			if (e.getSource() == numberButtons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		if (e.getSource() == decB) {
			textField.setText(textField.getText().concat(String.valueOf(".")));
		}
		if (e.getSource() == addB) {
			num1 = Double.parseDouble(textField.getText());
			operator = '+';
			textField.setText("");
		}
		if (e.getSource() == subB) {
			if (textField.getText().isEmpty()) {
				textField.setText(textField.getText().concat("-"));
			} else {
				num1 = Double.parseDouble(textField.getText());
				operator = '-';
				textField.setText("");
			}
		}
		if (e.getSource() == mulB) {
			num1 = Double.parseDouble(textField.getText());
			operator = '*';
			textField.setText("");
		}
		if (e.getSource() == divB) {
			num1 = Double.parseDouble(textField.getText());
			operator = '/';
			textField.setText("");
		}
		if (e.getSource() == facB) {
			num1 = Double.parseDouble(textField.getText());
			operator = '!';
			textField.setText("");
		}
		if (e.getSource() == powB) {
			num1 = Double.parseDouble(textField.getText());
			operator = '^';
			textField.setText("");
		}
		if (e.getSource() == B) {
			num1 = Double.parseDouble(textField.getText());
			operator = '?';
			textField.setText("");
		}
		if (e.getSource() == B2) {
			num1 = Double.parseDouble(textField.getText());
			operator = '?';
			textField.setText("");
		}
		if (e.getSource() == equB) {
			num2 = textField.getText().isEmpty() ? 0 : Double.parseDouble(textField.getText());
			switch (operator) {
			case '+':
				formula = new FoAdd();
				break;
			case '-':
				formula = new FoSubtract();
				break;
			case '*':
				formula = new FoMultiply();
				break;
			case '/':
				formula = new FoDivide();
				break;
			case '!':
				formula = new FoFactorial();
				break;
			case '^':
				formula = new FoPower();
				break;
			case '?':
				formula = new FoDefault();
				break;
			default:
				formula = new FoDefault();
				break;
			}
			result = formula.execute(num1, num2);

			textField.setText(String.valueOf(result));
			num1 = result;
		}
		if (e.getSource() == clrB) {
			textField.setText("");
		}
		if (e.getSource() == delB) {
			String string = textField.getText();
			textField.setText("");
			for (int i = 0; i < string.length() - 1; i++) {
				textField.setText(textField.getText() + string.charAt(i));
			}
		}
	}
}
