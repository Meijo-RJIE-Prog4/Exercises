/**
 * SampleStopThreadにおけるスレッド処理（. を表示し続ける）
 * @author Hidekazu Suzuki
 */
public class ShowPeriod implements Runnable {
	/** スレッドの実行状態を示すフラグ */
	private boolean running = true;

	@Override
	public void run() {
		while (running) {
			System.out.print(".");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		System.out.println("\nrun()を終了します．");
	}

	/**
	 * スレッドの実行状態をfalseにして停止するメソッド
	 */
	public void stopRunning() {
		this.running = false;
	}
}
