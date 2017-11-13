import java.io.*;

/**
 * バイナリファイルをコピーするサンプルプログラム
 * @author Hidekazu Suzuki
 * @version 1.0, 16 Jun 2014
 */
public class ExampleBinaryFileCopy {

	/**
	 * @param args 0：読み込むバイナリファイル名
	 *             1：コピー先バイナリファイル名
	 */
	public static void main(String[] args) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			fis = new FileInputStream(args[0]);		// ファイル入力バイトストリーム
			bis = new BufferedInputStream(fis);		// 入力用バッファ
			fos = new FileOutputStream(args[1]);	// ファイル出力バイトストリーム
			bos = new BufferedOutputStream(fos);	// 出力用バッファ
			
			int ch, i = 0;
			System.out.println(args[0] + "の内容：");
			// ファイルからまとめて入力用バッファ読み込み，入力用バッファから1バイト読み込み
			while ((ch = bis.read()) != -1) {	
				System.out.printf("%02X ", ch);	// 読み込んだ1バイトの値を16進数で表示
				if (++i % 16 == 0)				// 16バイト分表示したら改行する
					System.out.println();
				bos.write(ch);	// 読み込んだ1バイトの値を出力用バッファに書き込む
			}
			bos.flush();		// 出力用バッファの内容をファイルへ書き出す
			System.out.println("\n\n" + args[1] + "にコピーしました．");
		} catch (FileNotFoundException e) {
			System.out.println("ファイル" + args[0] + "が見つかりません．");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			/*
			 * BufferedInputStreamとBufferedOutputStreamをクローズ
			 * （連結されているFileInputStream，FileOutputStreamも同時にクローズされる）
			 */
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {}
			}
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {}
			}
		}
	}
}
