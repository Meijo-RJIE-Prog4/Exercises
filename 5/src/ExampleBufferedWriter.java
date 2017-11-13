import java.io.*;

/**
 * バッファリングしてテキストファイルに書き込むサンプルプログラム
 * @author Hidekazu Suzuki
 * @version 1.0, 16 Jun 2014
 */
public class ExampleBufferedWriter {

	/**
	 * @param args 書き込むテキストファイル名
	 */
	public static void main(String[] args) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(args[0]);	// ファイル出力文字ストリーム
			bw = new BufferedWriter(fw);	// 出力用バッファ
			// 引数で指定した文字列を出力用バッファに書き込む
			bw.write("Hello FileWriter!\r\n");
			bw.write("Save this text to the file!\r\n");
			// 出力用バッファの内容をファイルへ書き出す
			bw.flush();
			System.out.println(args[0] + "に保存しました．");
		} catch (FileNotFoundException e) {
			System.out.println("ファイル" + args[0] + "が見つかりません．");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			/*
			 * BufferedWriterストリームをクローズ
			 * （連結されているFileWriterストリームも同時にクローズされる）
			 */
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
