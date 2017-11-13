import java.io.*;

/**
 * バイナリファイルを1バイトずつ読み込むサンプルプログラム
 * @author Hidekazu Suzuki
 * @version 1.0, 16 Jun 2014
 */
public class ExampleFileInputStream {

	/**
	 * @param args 読み込むバイナリファイル名
	 */
	public static void main(String[] args) {
		FileInputStream fis = null;	
		try {
			fis = new FileInputStream(args[0]);		// ファイル入力バイトストリーム
			
			int ch, i = 0;
			System.out.println(args[0] + "の内容：");
			// ファイルから1バイトずつ読み込む
			while ((ch = fis.read()) != -1) {	
				System.out.printf("%02X ", ch);	// 読み込んだ1バイトの値を16進数で表示
				if (++i % 16 == 0)				// 16バイト分表示したら改行する
					System.out.println();
			}
		} catch (FileNotFoundException e) {
			System.out.println("ファイル" + args[0] + "が見つかりません．");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// FileInputStreamをクローズする
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {}
			}
		}
	}
}
