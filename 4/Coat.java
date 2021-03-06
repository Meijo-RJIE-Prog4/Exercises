public class Coat {
	private String name;		// コートの名前
	
	/* 指定した名前で初期化するコンストラクタ */
	public Coat(String name) {
		setName(name);
	}
	
	/* 名前を設定するsetter */
	private void setName(String name) {
		if (!(name != null && name.length() > 0))
			throw new IllegalArgumentException("名前が不適切です");
		this.name = name;
	}
	
	/* 名前を取得するgetter */
	public String getName() {
		return this.name;
	}
 }
