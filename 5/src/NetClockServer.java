import java.io.*;
import java.net.*;
import java.util.*;

/**
 * サーバの現在時刻を取得するサンプルサーバプログラム
 * @author Hidekazu Suzuki
 * @version 1.1, 16 Jun 2014
 */
public class NetClockServer {
	/** 最大接続数（100クライアント） */
	private static final int MAX_CONNECTION = 100;
	private static ServerSocket serverSocket;
	private static Date date;
	
	/**
	 * NetClockサーバプログラム
	 * @param args リッスンポート番号
	 */
	public static void main(String[] args) {
		// コマンドライン引数からポート番号を取得
		int port = Integer.parseInt(args[0]);

		Socket socket = null;
		try {
			serverSocket = new ServerSocket();
			serverSocket.setReuseAddress(true);
			// 指定ポート番号にバインド
			serverSocket.bind(new InetSocketAddress(port), MAX_CONNECTION);
			System.out.println("Server listening on port " + port + "...");
			
			while (true) {
				// クライアントからの接続要求を待機（クライアント接続するまでブロッキング）
				socket = serverSocket.accept();
				// 現在の日時を取得するためのオブジェクトを作成
				date = new Date();
				// 接続されたソケットの出力ストリームを取得し，データ出力ストリームを連結
				OutputStream os = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				
				// 接続したクライアントの情報を表示
				showClientInformation(socket);
				
				// クライアントへ送信するメッセージの作成
				String message = createMessage(socket);
				
				// データの送信（ソケットへ書き出す）
				dos.writeUTF(message);
				dos.flush();
			}
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
	
	/**
	 * 接続したクライアントの情報を表示する
	 * @param socket 接続済みソケットオブジェクト
	 */
	private static void showClientInformation(Socket socket) throws IOException {
		// クライアントのIPアドレスを取得
		InetAddress address = socket.getInetAddress();
		// クライアントのポート番号を取得
		int port = socket.getPort();
		
		System.out.println("Client[" + address.toString() + ":" + port +
				"] was connected at " + date.toString());
	}
	
	/**
	 * クライアントに送信するメッセージを作成する
	 * @param socket 接続済みソケットオブジェクト
	 * @return 作成したメッセージ
	 */
	private static String createMessage(Socket socket) {
		// サーバのホスト名（またはIPアドレス）を取得
		String hostName = socket.getLocalAddress().getHostName();
		// サーバのOS情報を取得
		String osName = System.getProperty("os.name");
		String osArch = System.getProperty("os.arch");
		String osVersion = System.getProperty("os.version");
		
		String message =
				"\nHello, this is NetClock server.\n" +
				"Server Information : " + hostName +		// サーバホスト名
				" (" + osName + " " + osVersion + ", " + osArch + ")\n" +	// OS情報
				"Current server time: " + date.toString() + "\n" +	// 日時
				"Thank you.\n";
		
		return message;
	}
}
