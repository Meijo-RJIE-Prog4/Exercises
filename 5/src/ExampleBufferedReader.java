import java.io.*;

/**
 * バッファリングしてテキストファイルを読み込むサンプルプログラム
 * @author Hidekazu Suzuki
 * @version 1.0, 16 Jun 2014
 */
public class ExampleBufferedReader {

	/**
	 * @param args 読み込むテキストファイル名
	 */
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(args[0]);	// ファイル入力文字ストリーム
			br = new BufferedReader(fr);	// 入力用バッファ
			String text = "";
			String str;
			// ファイルからまとめて入力用バッファ読み込み，入力用バッファから1行読み込み
			while ((str = br.readLine()) != null)
				text += str + "\r\n";	// 改行コードを付け加える
			
			System.out.println(args[0] + "の内容:");
			System.out.println(text);
		} catch (FileNotFoundException e) {
			System.out.println("ファイル" + args[0] + "が見つかりません．");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			/*
			 * BufferedReaderストリームをクローズ
			 * （連結されているFileReaderストリームも同時にクローズされる）
			 */
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {}
			}
		}
	}
}
