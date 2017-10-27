/* 剣クラス */
public class Sword {
	private String name;	// 名前
	private int damage;		// ダメージ
	
	/* デフォルトコンストラクタ（名前=剣，ダメージ=5） */
	public Sword() {
		this.setName("剣");
		this.setDamage(5);
	}
	
	/* 指定された名前とダメージで初期化するコンストラクタ */
	public Sword(String name, int damage) {
		this.setName(name);
		this.setDamage(damage);
	}
	
	/* 名前を設定するsetter */
	private void setName(String name) {
		// 渡された名前がnullの場合，エラーを表示して終了
		if (name == null)
			throw new IllegalArgumentException("nullは設定できません。");
		// 渡された名前が0文字の場合，エラーを表示して終了
		if (name.length() == 0)
			throw new IllegalArgumentException("空文字は設定できません。");
		this.name = name;
	}
	
	/* 名前を取得するgetter */
	public String getName() {
		return this.name;
	}
	
	/* ダメージを設定するsetter */
	public void setDamage(int damage) {
		// 渡されたダメージが0以下の場合，エラーを表示して終了
		if (damage <= 0)
			throw new IllegalArgumentException("指定したダメージの値は不適切です。");
		this.damage = damage;
	}
	
	/* ダメージを取得するgetter */
	public int getDamage() {
		return this.damage;
	}
}
