import java.io.*;

/**
 * テキストファイルに1文字ずつ書き込むサンプルプログラム
 * @author Hidekazu Suzuki
 * @version 1.0, 16 Jun 2014
 */
public class ExampleFileWriter {

	/**
	 * @param args 書き込むテキストファイル名
	 */
	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(args[0]);	// ファイル出力文字ストリーム
			// 引数で指定した文字列を1文字ずつファイルに書き込む
			fw.write("Hello FileWriter!\r\n");
			fw.write("Save this text to the file!\r\n");
			
			System.out.println(args[0] + "に保存しました．");
		} catch (FileNotFoundException e) {
			System.out.println("ファイル" + args[0] + "が見つかりません．");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// FileWriterストリームをクローズする
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {}
			}
		}
	}
}
