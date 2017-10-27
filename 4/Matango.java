/* お化けキノコクラス */
public class Matango {
	private int hp;	// HP
	private final int LEVEL = 10;	// レベル
	private char suffix;	// サフィックス
	
	/* 指定したサフィックスで初期化するコンストラクタ */
	Matango(char suffix) {
		this.hp = 10;
		this.suffix = suffix;
	}
	
	/* お化けキノコの名前を取得するメソッド */
	public String getName() {
		return "お化けキノコ" + this.suffix;
	}
	
	/* 逃げるメソッド */
	public void run() {
		System.out.println("お化けキノコ" + this.suffix + "は逃げ出した！");
	}
	
	/* ダメージを受けるメソッド */
	public void takeDamage(int damage) {
		if (damage < 0)
			throw new IllegalArgumentException("負の値は指定できません");
		this.hp -= damage;
	}
	
	/* 死んだか判定するメソッド */
	public boolean isDead() {
		// 死亡したらtrue，生存している場合はfalseを返す
		if (this.hp <= 0)
			return true;
		else
			return false;
	}
}
