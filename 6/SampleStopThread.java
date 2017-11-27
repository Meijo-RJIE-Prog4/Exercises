/**
 * SampleStopThread：ピリオドを表示し続けるスレッドを5秒後に停止するサンプル
 * @author hsuzuki
 *
 */
public class SampleStopThread {

	public static void main(String[] args) {
		// ピリオドを表示し続けるスレッドを作成して実行
		ShowPeriod process = new ShowPeriod();
		Thread thread = new Thread(process);
		thread.start();
		
		// 5秒後にスレッドを停止
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		process.stopRunning();
	}

}
