/* 勇者クラス */
public class Hero {
	private String name;	// 名前
	private int hp;			// HP
	private Sword sword;	// 武器（剣）
	private static int money = 100;	// 所持金
	
	// デフォルトコンストラクタ
	public Hero() {
		this("勇者", 100, null);
	}

	// 指定した名前で初期化するコンストラクタ
	public Hero(String name) {
		this(name, 100, null);
	}

	// 指定したHPで初期化するコンストラクタ
	public Hero(int hp) {
		this("勇者", hp, null);
	}

	// 指定した名前，HPで初期化するコンストラクタ
	public Hero(String name, int hp) {
		this(name, hp, null);
	}
	
	// 指定した名前，HP，剣で初期化するコンストラクタ
	public Hero(String name, int hp, Sword sword) {
		this.setName(name);
		this.setHp(hp);
		this.setSword(sword);
	}
	
	/* 名前を設定するsetter */
	private void setName(String name) {
		/* 渡された名前がnullの場合，エラーを表示して終了 */
		if (name == null)
			throw new IllegalArgumentException("nullは設定できません。");
		/* 渡された名前が0文字の場合，エラーを表示して終了 */
		if (name.length() == 0)
			throw new IllegalArgumentException("空文字は設定できません。");
		/* 渡された名前が1〜10文字の範囲でない場合，エラーを表示して終了 */
		if (!(name.length() >= 1 && name.length() <=10))
			throw new IllegalArgumentException("文字数が不適切です。");
		this.name = name;
	}
	
	/* 名前を取得するgetter */
	public String getName() {
		return this.name;
	}
	
	/* HPを設定するsetter */
	public void setHp(int hp) {
		/* 渡されたHPが0以下の場合，エラーを表示して終了 */
		if (hp <= 0)
			throw new IllegalArgumentException("0以下の値は設定できません。");
		this.hp = hp;
	}
	
	/* HPを取得するgetter */
	public int getHp() {
		return this.hp;
	}

	/* 武器を装備するsetter */
	public void setSword(Sword sword) {
		/* 渡された武器がnullの場合，デフォルトの剣を装備させる */
		if (sword == null)
			this.sword = new Sword();
		else
			this.sword = sword;
	}
	
	/* 装備している武器を取得するgetter */
	public Sword getSword() {
		return this.sword;
	}
	
	/* 攻撃するメソッド */
	public void attack(Matango m) {
		System.out.println(this.name + "は攻撃した！");
		System.out.println(m.getName() + "に" + this.sword.getDamage() + "ポイントのダメージをあたえた！");
	}
	
	/* 眠るメソッド */
	public void sleep() {
		this.hp = 100;
		System.out.println(this.name + "は、眠って回復した！");
	}
	
	/* 座るメソッド */
	public void sit(int sec) {
		this.hp += sec;
		System.out.println(this.name + "は、" + sec + "秒すわった！");
		System.out.println("HPが" + sec + "ポイント回復した．");
	}
	
	/* 転ぶメソッド */
	public void slip() {
		this.hp -= 5;
		System.out.println(this.name + "は、転んだ！");
		System.out.println("5のダメージ！");
	}
	
	/* 逃げるメソッド */
	public void run() {
		System.out.println("逃げ出した");
	}
	
	/* 所持金を増やすクラスメソッド */
	public static void addMoney(int money) {
		/* 渡された金額が負の値の場合，エラーを表示して終了 */
		if (money < 0)
			throw new IllegalArgumentException("負の値は設定できません");
		Hero.money += money;
	}
	
	/* 所持金を取得するクラスメソッド */
	public static int getMoney() {
		return Hero.money;
	}
}
