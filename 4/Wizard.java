/* 魔法使いクラス */
public class Wizard extends Character {
	private int mp;
	
	public Wizard() {
		this.name = "魔法使い";
		this.hp = 50;
		this.mp = 30;
	}

	/* 攻撃するメソッド */
	@Override
	public void attack(Matango m) {
		System.out.println(this.name + "の攻撃");
		System.out.println("敵に3ポイントのダメージ");
		m.takeDamage(3);
		// お化けキノコを倒したらメッセージを表示
		if (m.isDead())
			System.out.println(m.getName() + "を倒した！");
	}

	/* 火の玉を放つメソッド */
	public void firewall(Matango m) {
		System.out.println(this.name + "は火の玉を放った！");
		System.out.println("敵に20ポイントのダメージ");
		m.takeDamage(20);	// 20ポイントのダメージ
		this.consumeMp(5);	// MPを5ポイント消費
		// お化けキノコを倒したらメッセージを表示
		if (m.isDead())
			System.out.println(m.getName() + "を倒した！");
	}
	
	/* MPを消費するメソッド */
	private void consumeMp(int mp) {
		if (mp < 0)
			throw new IllegalArgumentException("負の値は指定できません");
		if (this.mp >= mp)
			this.mp -= mp;
		else
			this.mp = 0;
	}
}
