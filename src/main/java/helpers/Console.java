package helpers;

import java.util.Scanner;

public class Console {

  public static void error(String errorMessage) {
    String ANSI_RED = "\u001B[31m";
    String ANSI_RESET = "\u001B[0m";
    System.err.println(ANSI_RED + errorMessage + ANSI_RESET);
  }

  public static void error(Exception e) {
    error(e.toString());
  }

  public static String input(String prompt) {

    String response = "";
    Scanner scanner = new Scanner(System.in);

    try {

      print(prompt);
      response = scanner.nextLine();

    } catch (Exception e) {

      error(e);

    } finally {
      try {
        scanner.close();
      } catch (Exception e) { /* nothing to close */ }
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
