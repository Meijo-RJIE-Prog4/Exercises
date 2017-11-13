import java.io.*;

/**
 * ExampleDataOutputStreamが書き出したバイナリファイルを指定したフォーマットで
 * 読み込むサンプルプログラム
 * @author Hidekazu Suzuki
 * @version 1.0, 16 Jun 2014
 */
public class ExampleDataInputStream {

	/**
	 * @param args 読み込むバイナリファイル名
	 */
	public static void main(String[] args) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream(args[0]);		// ファイル入力バイトストリーム
			bis = new BufferedInputStream(fis);		// 入力用バッファ
			dis = new DataInputStream(bis);			// データ入力ストリーム
			// 文字列の読み込んで表示
			String text = dis.readUTF();
			System.out.println("文字列：" + text);
			// 色のRGB成分を読み込んで表示
			int r = dis.readInt();
			int g = dis.readInt();
			int b = dis.readInt();
			System.out.println("RGB成分：(" + r + ", " + g + ", " + b + ")");
			
		} catch (FileNotFoundException e) {
			System.out.println("ファイル" + args[0] + "が見つかりません．");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			/*
			 * DataInputStreamをクローズ
			 * （連結されているBufferedInputStream，FileInputStreamも同時にクローズされる）
			 */
			if (dis != null) {
				try {
					dis.close();
				} catch (IOException e) {}
			}
		}
	}
}
