import java.util.Scanner;

/**
 * キーボード入力確認用ソースコード
 * @author	Hidekazu Suzuki
 * @date	2017/09/11
 * @version	1.0
 */
public class Exercise0106 {
	public static void main(String[] args) {
		System.out.print("input num: ");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();

		// scanner.nextLine();	// 改行コードを読み取る

		System.out.print("input name: ");
		String name = scanner.nextLine();

		System.out.println("num = " + num + ", name = " + name);
	}
}
