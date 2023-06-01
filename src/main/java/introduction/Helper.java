package introduction;

import java.util.Scanner;

public class Helper {

  public static String INPUT(String prompt) {

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

  public static void PRINT(String text) {
    System.out.println(text);
  }

}
