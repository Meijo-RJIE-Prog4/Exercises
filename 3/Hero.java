/**
 * 勇者クラス用ソースコード
 * @author	Hidekazu Suzuki
 * @date	2017/10/10
 * @version	1.0
 */
public class Hero {
	String name;
	int hp;
	
	void setName(String name) {
		this.name = name;
	}
	
	String getName() {
		return this.name;
	}
	
	void setHp(int hp) {
		this.hp = hp;
	}
	
	int getHp() {
		return this.hp;
	}
	
	void sleep() {
		this.hp = 100;
		System.out.println(this.name + "は、眠って回復した！");
	}
	
	void sit(int sec) {
		this.hp += sec;
		System.out.println(this.name + "は、" + sec + "秒すわった！");
		System.out.println("HPが" + sec + "ポイント回復した．");
	}
	
	void slip() {
		this.hp -= 5;
		System.out.println(this.name + "は、転んだ！");
		System.out.println("5のダメージ！");
	}
	
	void run() {
		System.out.println(this.name + "は、逃げ出した！");
		System.out.println("GAMEOVER");
		System.out.println("最終HPは" + this.hp + "でした");
	}

}
