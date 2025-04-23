package calculator;


import java.util.InputMismatchException;
import java.util.Scanner;

import formula.FoAdd;
import formula.FoDefault;
import formula.FoDivide;
import formula.FoMultiply;
import formula.FoSubtract;
import formula.IFoTwoVariable;

public class Calculator {

	Calculator() {
	}

	public static void main(String[] args) {
		IFoTwoVariable formula = new FoDivide();
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter a number");
			double x = sc.nextDouble();
			System.out.println("Enter a number");
			double y = sc.nextDouble();
			System.out.println("The result is\t" + formula.execute(x, y));
		} catch (ArithmeticException e) {
			System.out.println("You cannot divide by zero, you dummy!");
		} catch (InputMismatchException e) {
			System.out.println("That's not a number, omg.");
		} catch (Exception e) {
			System.out.println("Something's wrong, figure it out...");
		} finally {
			sc.close();
		}
	}
	
}
