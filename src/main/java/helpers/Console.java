package helpers;

import java.util.Scanner;

public class Console {

  public static interface Styles {
    public void apply();
  }

  private final static class PvtStyle implements Styles {
    private String escapeCode;
    private PvtStyle(){ super(); }
    protected PvtStyle(String escapeCode) {
      this();
      this.escapeCode = escapeCode;
    }
    public void apply() {
      print("\u001B[" + escapeCode + "m");
    }
    protected void applyForError() {
      System.err.print("\u001B[" + escapeCode + "m");
    }
  }

  public static final class Style {
    public static final Styles RESET = new PvtStyle("0");
    // Foreground
    public static final Styles BLACK = new PvtStyle("30");
    public static final Styles RED = new PvtStyle("0;31");   
    public static final Styles GREEN = new PvtStyle("0;32"); 
    public static final Styles YELLOW = new PvtStyle("0;33"); 
    public static final Styles BLUE = new PvtStyle("0;34");   
    public static final Styles PURPLE = new PvtStyle("0;35"); 
    public static final Styles CYAN = new PvtStyle("0;36");   
    public static final Styles WHITE = new PvtStyle("0;37");  
    public static final Styles BLACK_BOLD = new PvtStyle("1;30"); 
    public static final Styles RED_BOLD = new PvtStyle("1;31");   
    public static final Styles GREEN_BOLD = new PvtStyle("1;32"); 
    public static final Styles YELLOW_BOLD = new PvtStyle("1;33"); 
    public static final Styles BLUE_BOLD = new PvtStyle("1;34");  
    public static final Styles PURPLE_BOLD = new PvtStyle("1;35");
    public static final Styles CYAN_BOLD = new PvtStyle("1;36");  
    public static final Styles WHITE_BOLD = new PvtStyle("1;37"); 
    public static final Styles BLACK_UNDERLINED = new PvtStyle("4;30");
    public static final Styles RED_UNDERLINED = new PvtStyle("4;31"); 
    public static final Styles GREEN_UNDERLINED = new PvtStyle("4;32");
    public static final Styles YELLOW_UNDERLINED = new PvtStyle("4;33");
    public static final Styles BLUE_UNDERLINED = new PvtStyle("4;34"); 
    public static final Styles PURPLE_UNDERLINED = new PvtStyle("4;35");
    public static final Styles CYAN_UNDERLINED = new PvtStyle("4;36"); 
    public static final Styles WHITE_UNDERLINED = new PvtStyle("4;37"); 
    public static final Styles BLACK_BRIGHT = new PvtStyle("0;90"); 
    public static final Styles RED_BRIGHT = new PvtStyle("0;91");   
    public static final Styles GREEN_BRIGHT = new PvtStyle("0;92"); 
    public static final Styles YELLOW_BRIGHT = new PvtStyle("0;93");
    public static final Styles BLUE_BRIGHT = new PvtStyle("0;94");  
    public static final Styles PURPLE_BRIGHT = new PvtStyle("0;95");
    public static final Styles CYAN_BRIGHT = new PvtStyle("0;96"); 
    public static final Styles WHITE_BRIGHT = new PvtStyle("0;97"); 
    public static final Styles BLACK_BOLD_BRIGHT = new PvtStyle("1;90");
    public static final Styles RED_BOLD_BRIGHT = new PvtStyle("1;91");
    public static final Styles GREEN_BOLD_BRIGHT = new PvtStyle("1;92");
    public static final Styles YELLOW_BOLD_BRIGHT = new PvtStyle("1;93");
    public static final Styles BLUE_BOLD_BRIGHT = new PvtStyle("1;94");
    public static final Styles PURPLE_BOLD_BRIGHT = new PvtStyle("1;95");
    public static final Styles CYAN_BOLD_BRIGHT = new PvtStyle("1;96");
    public static final Styles WHITE_BOLD_BRIGHT = new PvtStyle("1;97");

    // Background
    public static final Styles BG_BLACK = new PvtStyle("40"); 
    public static final Styles BG_RED = new PvtStyle("41");   
    public static final Styles BG_GREEN = new PvtStyle("42"); 
    public static final Styles BG_YELLOW = new PvtStyle("43");
    public static final Styles BG_BLUE = new PvtStyle("44");   
    public static final Styles BG_PURPLE = new PvtStyle("45"); 
    public static final Styles BG_CYAN = new PvtStyle("46");   
    public static final Styles BG_WHITE = new PvtStyle("47");  
    public static final Styles BG_BLACK_BRIGHT = new PvtStyle("0;100");
    public static final Styles BG_RED_BRIGHT = new PvtStyle("0;101");
    public static final Styles BG_GREEN_BRIGHT = new PvtStyle("0;102");
    public static final Styles BG_YELLOW_BRIGHT = new PvtStyle("0;103");
    public static final Styles BG_BLUE_BRIGHT = new PvtStyle("0;104");
    public static final Styles BG_PURPLE_BRIGHT = new PvtStyle("0;105");
    public static final Styles BG_CYAN_BRIGHT = new PvtStyle("0;106");
    public static final Styles BG_WHITE_BRIGHT = new PvtStyle("0;107");
  }

  private static boolean printNotes = true;

  public static void error(String errorMessage) {
    // String ANSI_RED = "\u001B[31m";
    // String ANSI_RESET = "\u001B[0m";
    // System.err.println(ANSI_RED + errorMessage + ANSI_RESET);
    ((PvtStyle) Style.BG_RED_BRIGHT).applyForError();
    ((PvtStyle) Style.YELLOW_BOLD_BRIGHT).applyForError();
    System.err.println(errorMessage);
    ((PvtStyle) Style.RESET).applyForError();
  }

  public static void error(Exception e) {
    error(e.toString());
  }

  public static void note(String note) {

    if (printNotes) {
      Style.BLACK_BRIGHT.apply();
      println(note);
      Style.RESET.apply();
    }

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

  public static void print(Object obj) { print(obj.toString()); }

  public static void println(String text) {
    System.out.println(text);
  }

    public static void println(Object obj) { println(obj.toString()); }


}
