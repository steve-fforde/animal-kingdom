package helpers;

import java.util.Scanner;

public class Console {

  public static void error(String errorMessage) {
    System.err.println(errorMessage);
  }

  public static String input(String prompt) {

    String response = "";
    Scanner scanner = new Scanner(System.in);

    try {

      System.out.print(prompt);
      response = scanner.nextLine();

    } catch (Exception e) {

      System.err.println(e);

    } finally {
      try {
        scanner.close();
      } catch (Exception e) {
      }
    }
    return response;

  }

  public static void print(String text) {
    System.out.print(text);
  }

  public static void println(String text) {
    System.out.println(text);
  }

}
