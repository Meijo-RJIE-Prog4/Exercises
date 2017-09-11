/**
 * コマンドライン引数確認用ソースコード
 * @author	Hidekazu Suzuki
 * @date	2017/09/11
 * @version	1.0
 */
public class Exercise0109 {
	public static void main(String[] args) {
		// 第1引数を取得
		String text = args[0];
		System.out.println("第1引数 = " + text);

		// 第2引数を取得
		int value1 = Integer.parseInt(args[1]);
		System.out.println("第2引数 = " + value1);

		// 第3引数を取得
		double value2 = Double.parseDouble(args[2]);
		System.out.println("第3引数 = " + value2);
	}
}