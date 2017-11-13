import java.io.*;
import java.net.*;

/**
 * サーバの現在時刻を取得するサンプルクライアントプログラム
 * @author Hidekazu Suzuki
 * @version 1.1, 16 Jun 2014
 */
public class NetClockClient {

	/**
	 * NetClockクライアントプログラム
	 * @param args[0] サーバホスト名またはIPアドレス
	 * @param args[1] サーバポート番号
	 */
	public static void main(String[] args) {
		// コマンドライン引数から接続先サーバのホスト名またはIPアドレスを取得
		String server = args[0];
		// コマンドライン引数からポート番号を取得
		int port = Integer.parseInt(args[1]);

		Socket socket = null;
		try {
			// ソケットを作成
			socket = new Socket();
			// 指定されたホスト名（IPアドレス）とポート番号でサーバに接続する
			socket.connect(new InetSocketAddress(server, port));
			// 接続されたソケットの入力ストリームを取得し，データ入力ストリームを連結
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			
			// データの受信
			String message = dis.readUTF();
			// 受信したデータを表示
			System.out.println(message);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// ソケットをクローズする
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {}
			}
		}
	}
}
