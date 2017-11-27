
public class CountDownThread {
	private int startTime;
	
	/**
	 * 指定した名前と開始秒数で初期化するコンストラクタ
	 * @param name	スレッド名
	 * @param startTime	開始秒数
	 */
	public CountDownThread(String name, int startTime) {
		// スレッド名を設定

		// 開始秒数を設定
		setStartTime(startTime);
	}
	
	/**
	 * 開始秒数を設定するセッター
	 * @param startTime	開始秒数
	 */
	public void setStartTime(int startTime) {
		if (startTime <= 0) {
			throw new IllegalArgumentException("不正な値：" + startTime);
		}
		this.startTime = startTime;
	}

}
