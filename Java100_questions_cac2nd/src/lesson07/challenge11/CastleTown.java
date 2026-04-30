/**
 * 第7章 武士のお仕事
 *
 * 問題11 instanceof演算子
 *
 * instanceof演算子を利用する。
 *
 * 侍クラスの配列に（藩士、浪人）をランダムに入れ、
 * それぞれの人数を表示してください。
 *
 * <実行例>
 * 5人の侍を配列に詰めます。
 *
 * 詰め終わりました。
 *
 * それぞれの人数を表示してみます。
 *
 * 藩士：3人
 *
 * 浪人：2人
 *
 */

package lesson07.challenge11;

//ここにSamuraiクラスを記述
abstract class Samurai {

	protected String name;

	public abstract void work();

	void fight() {
		System.out.println("戦うよ～。");
	}
}

//ここにRetainerクラスを記述
class Retainer extends Samurai {
	protected String domain;

	public Retainer() {
	}

	public Retainer(String name, String domain) {
		super();
		this.name = name;
		this.domain = domain;
		System.out.println("拙者は" + this.domain + this.name + "ともうす。");
	}

	public String toString() {
		return this.name;
	}

	public void equals(Retainer retainer) {
		boolean isChecked = this.domain.equals(retainer.domain);
		if (isChecked) {
			System.out.println("【同じ藩に所属しています】");
		} else {
			System.out.println("【同じ藩に所属していません】");
		}
	}

	public void work() {
		System.out.println("年貢を取り立てるよ～。");
	}
}

//ここにRoninクラスを記述
class Ronin extends Samurai {

	public Ronin() {
	}

	void covered() {
		System.out.println("傘張りするよ～。");
	}

	public void work() {
		System.out.println("傘張るよ～。");
	}
}

public class CastleTown {

	public static void main(String[] args) {
		System.out.println("5人の侍を配列に詰めます。\n");

		//ここに適切な処理を記述
		Samurai[] samurais = new Samurai[5];
		for (int i = 0; i < samurais.length; i++) {
			int num = (int) (Math.random() * 10 % 2);
			if (num == 0) {
				samurais[i] = new Retainer();
			} else {
				samurais[i] = new Ronin();
			}
		}

		System.out.println("詰め終わりました。\n");
		System.out.println("それぞれの人数を表示してみます。\n");

		int retainerCount = 0;
		int roninCount = 0;

		//ここに適切な処理を記述
		for (Samurai samurai : samurais) {
			if (samurai instanceof Retainer) {
				++retainerCount;
			} else {
				++roninCount;
			}
		}

		System.out.println("藩士：" + retainerCount + "人");
		System.out.println("\n浪人：" + roninCount + "人");
	}
}
