package jp.ac.meijo_u.prog4.countdown;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CountDownController {
	/** カウント初期値を入力するテキストフィールド */
	@FXML private TextField textCount;
	/** カウントダウン開始ボタン */
	@FXML private Button buttonStart;
	/** カウント値を表示するラベル */
	@FXML private Label labelCount;
	
	/**
	 * 開始ボタンをクリックしたときに呼び出されるハンドラ
	 * @param event	イベントインスタンス
	 */
	@FXML protected void handleButtonStartAction(ActionEvent event) {
		// テキストフィールドの文字列をint型に変換して取得
		int count = Integer.parseInt(textCount.getText());
		// 1秒間隔でカウント初期値を減算し、0未満になるまで繰り返す
		for (int i = count; i >= 0; i--) {
			// 現在の値を文字列に変換して，メッセージプロパティに反映
			labelCount.setText(String.valueOf(i));
			// 1秒間停止
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
