package org.example;

import java.util.Scanner;
//TIP コードを<b>実行</b>するには、<shortcut actionId="Run"/> を押すか
// ガターの <icon src="AllIcons.Actions.Execute"/> アイコンをクリックします。
public class Calculator {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    try {
      System.out.print("1番目の数字を入力してください。");
      double firstNumber = Double.parseDouble(scanner.nextLine());

      System.out.print("演算子を入力してください。(+,-,*,/)");
      String operator = scanner.nextLine();

      System.out.print("2番目の数字を入力して下さい。");
      double secondNumber = Double.parseDouble(scanner.nextLine());

      double result = calculate(firstNumber, operator, secondNumber);
      System.out.print("計算結果:" + firstNumber + " " + operator + " " + secondNumber + " = " + result);
    } catch (NumberFormatException e) {
      System.out.println("エラー：数字の形式が正しくありません。");
    } catch (ArithmeticException e) {
      System.out.println("エラー：" + e.getMessage());
    } catch (IllegalArgumentException e) {
      System.out.println("エラー：" + e.getMessage());
    } finally {
      scanner.close();
    }
  }
  public static double calculate(double firstNumber, String operator, double secondNumber) {
    switch (operator) {
      case "+":
        return firstNumber + secondNumber;
      case "-":
        return firstNumber - secondNumber;
      case "*":
        return firstNumber * secondNumber;
      case "/":
        if (secondNumber == 0) {
          throw new ArithmeticException("ゼロで割ることはできません。");
        }
        return firstNumber / secondNumber;
      default:
        throw new IllegalArgumentException("無効な演算子が入力されました。");
    }
  }
}