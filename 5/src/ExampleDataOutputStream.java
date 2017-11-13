import java.io.*;

/**
 * 指定したフォーマットでバイナリファイルに書き込むサンプルプログラム
 * @author Hidekazu Suzuki
 * @version 1.0, 16 Jun 2014
 */
public class ExampleDataOutputStream {

	/**
	 * @param args 書き出すバイナリファイル名
	 */
	public static void main(String[] args) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream(args[0]);	// ファイル出力バイトストリーム
			bos = new BufferedOutputStream(fos);	// 出力用バッファ
			dos = new DataOutputStream(bos);		// データ出力ストリーム
			
			dos.writeUTF("Orange.");	// UTF-8エンコードで文字列を書き込む
			dos.writeInt(255);			// int型の値を書き込む（オレンジ色のR成分）
			dos.writeInt(165);			// int型の値を書き込む（オレンジ色のG成分）
			dos.writeInt(0);			// int型の値を書き込む（オレンジ色のB成分）
			// データ出力ストリームに書かれたデータをフラッシュする（ファイルに書き出される）
			dos.flush();
			System.out.println(args[0] + "に保存しました．");
		} catch (FileNotFoundException e) {
			System.out.println("ファイル" + args[0] + "が見つかりません．");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			/*
			 * DataOutputStreamをクローズ
			 * （連結されているBufferedOutputStream，FileOutputStreamも同時にクローズされる）
			 */
			if (dos != null) {
				try {
					dos.close();
				} catch (IOException e) {}
			}
		}
	}
}
