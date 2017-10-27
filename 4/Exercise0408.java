import java.util.Scanner;

public class Exercise0408 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("主人公の職業を選択して下さい");
    System.out.print(" 1:勇者 2:魔法使い > ");
    Character c = null;
    switch (sc.nextInt()) {
    case 1:
      c = new Hero(); break;
    case 2:
      c = new Wizard(); break;
    default:
    	System.out.println("入力が適切ではありません");
    	System.exit(1);
    }
    
    Matango m = new Matango('A');
    c.attack(m);
  }  
}
