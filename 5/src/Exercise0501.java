import java.io.*;

public class Exercise0501 {

	public static void main(String[] args) {
		/* テキストファイルdata.txtに書き込むストリームの作成 */
		FileWriter fw = new FileWriter("data.txt");
		/* "hello!"を書き込む */
		fw.write("hello!");
		System.out.println("data.txtに書き込みました，");
		/* ストリームをクローズする */
		fw.close();
	}

}
