import java.io.*;

/**
 * テキストファイルを1文字ずつ読み込むサンプルプログラム
 * @author Hidekazu Suzuki
 * @version 1.0, 16 Jun 2014
 */
public class ExampleFileReader {

	/**
	 * @param args 読み込むテキストファイル名
	 */
	public static void main(String[] args) {
		FileReader fr = null;
		try {
			fr = new FileReader(args[0]);	// ファイル入力文字ストリーム
			String text = "";
			int ch;
			// ファイルから1文字ずつ読み込む
			while ((ch = fr.read()) != -1)
				text += (char)ch;
			
			System.out.println(args[0] + "の内容:");
			System.out.println(text);
		} catch (FileNotFoundException e) {
			System.out.println("ファイル" + args[0] + "が見つかりません．");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// FileReaderストリームをクローズする
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {}
			}
		}
	}
}
