import java.io.*;

/**
 * バイナリファイルに1バイトずつ書き込むサンプルプログラム
 * @author Hidekazu Suzuki
 * @version 1.0, 16 Jun 2014
 */
public class ExampleFileOutputStream {

	/**
	 * @param args 書き込むバイナリファイル名
	 */
	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(args[0]);	// ファイル出力バイトストリーム
			
			for (int i = 0; i < 100; i++)
				fos.write(i);
			
			System.out.println(args[0] + "に保存しました．");
		} catch (FileNotFoundException e) {
			System.out.println("ファイル" + args[0] + "が見つかりません．");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// FileOutputStreamストリームをクローズする
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {}
			}
		}
	}
}
