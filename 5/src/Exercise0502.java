import java.io.*;

public class Exercise0502 {

	public static void main(String[] args) {
		/* テキストファイルdata.txtに"hello!"を書き込む */
		save("data.txt");
	}
	
	public static void save(String fileName) {
		/* テキストファイルに書き込むストリームの作成 */
		FileWriter fw = new FileWriter(fileName);
		/* "hello!"を書き込む */
		fw.write("hello!");
		System.out.println(fileName + "に書き込みました，");
		/* ストリームをクローズする */
		fw.close();
	}

}
