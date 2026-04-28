/**
 * 第4章 倉庫番のお仕事
 *
 * 問題11 荷物の入れ替え（三つの配列をまとめる）
 *
 * MQ運送から、新たに三つのコンテナ群を預かり
 * 委託管理を行うことになりました。
 * 三つのコンテナ群はそれぞれ5箱ずつからなり、
 * 合計すると15箱の入れ物になります。
 *
 * 併せてMQ運送から依頼があり、
 * コンテナ群のうち空き箱がいくつかあるので、
 * 空いてるところは詰めてほしいと言われました。
 * つまり、
 *
 * 有、空、有、空、有
 *
 * と並んでいた場合は、
 *
 * 有、有、有、空、空
 *
 * としてほしいという依頼です。
 *
 * 各コンテナのどの箱が空き箱なのかはランダムに決定し、
 * 空き箱である確率は1/4です。
 * 中身がある箱には1～10の何れかの数値が入り、
 * これもランダムに決定します。
 *
 * コメントの位置に適切なコードを記述し、
 * 実行例と同じメッセージを表示してください。
 *
 * <実行例>
 *  E主任：
 *  MQ運送の件、お願いします。
 *
 *  Yさん：
 *  はい、まずは現状から確認いたします。
 *
 *  C...3,4,4,0,7
 *
 *  D...0,5,0,9,0
 *
 *  E...2,1,3,10,6
 *
 *  でした。直してきます...
 *
 *  Yさん：
 *  直してきました。
 *
 *  C...3,4,4,7,5
 *
 *  D...9,2,1,3,10
 *
 *  E...6,0,0,0,0
 *
 *  になりました。
 *
 *  E主任：
 *  ご苦労さまでした。
 *
 */

package lesson04.challenge11;

public class WarehouseManager {

	public static void main(String[] args) {

		//ここに必要な配列の宣言を記述する。
		int[] MQArrayC = new int[5];
		int[] MQArrayD = new int[5];
		int[] MQArrayE = new int[5];
		int[] TotalNonZeroArray = new int[15];
		int input_Zero = 0;
		int input = 0;

		//ここに配列に値を代入する処理を記述する。(要素はランダム)
		for (int i = 0; i < MQArrayC.length; i++) {
			input_Zero = (int) (Math.random() * 10 % 4);
			if (input_Zero == 0) {
				MQArrayC[i] = input_Zero;
			} else {
				input = (int) (Math.random() * 10 % 10 + 1);
				MQArrayC[i] = input;
			}
		}

		for (int i = 0; i < MQArrayD.length; i++) {
			input_Zero = (int) (Math.random() * 10 % 4);
			if (input_Zero == 0) {
				MQArrayD[i] = input_Zero;
			} else {
				input = (int) (Math.random() * 10 % 10 + 1);
				MQArrayD[i] = input;
			}
		}

		for (int i = 0; i < MQArrayE.length; i++) {
			input_Zero = (int) (Math.random() * 10 % 4);
			if (input_Zero == 0) {
				MQArrayE[i] = input_Zero;
			} else {
				input = (int) (Math.random() * 10 % 10 + 1);
				MQArrayE[i] = input;
			}
		}

		System.out.println("E主任：");
		System.out.println("MQ運送の件、お願いします。\n");

		System.out.println("Yさん：");
		System.out.println("はい、まずは現状から確認いたします。\n");

		System.out.print("C...");

		//ここに配列Cの要素をすべて出力する処理を記述する。
		for (int i = 0; i < MQArrayC.length; i++) {
			if (i == (MQArrayC.length - 1)) {
				System.out.print(MQArrayC[i]);
			} else {
				System.out.print(MQArrayC[i] + ",");
			}
		}

		System.out.print("\n\nD...");

		//ここに配列Dの要素をすべて出力する処理を記述する。
		for (int i = 0; i < MQArrayD.length; i++) {
			if (i == (MQArrayD.length - 1)) {
				System.out.print(MQArrayD[i]);
			} else {
				System.out.print(MQArrayD[i] + ",");
			}
		}

		System.out.print("\n\nE...");

		//ここに配列Eの要素をすべて出力する処理を記述する。
		for (int i = 0; i < MQArrayE.length; i++) {
			if (i == (MQArrayE.length - 1)) {
				System.out.print(MQArrayE[i]);
			} else {
				System.out.print(MQArrayE[i] + ",");
			}
		}

		System.out.println("\n\nでした。直してきます...\n");

		int sum_nonZero = 0; //ゼロ以外が出てきた回数を記録し、全体の配列の添字sum_nonZero - 1

		//ここに詰め替え処理を記述する
		for (int i = 0; i < MQArrayC.length; i++) {
			if (MQArrayC[i] != 0) {
				TotalNonZeroArray[sum_nonZero] = MQArrayC[i];
				++sum_nonZero;
			}
		}

		for (int i = 0; i < MQArrayD.length; i++) {
			if (MQArrayD[i] != 0) {
				TotalNonZeroArray[sum_nonZero] = MQArrayD[i];
				++sum_nonZero;
			}
		}

		for (int i = 0; i < MQArrayE.length; i++) {
			if (MQArrayE[i] != 0) {
				TotalNonZeroArray[sum_nonZero] = MQArrayE[i];
				++sum_nonZero;
			}
		}

		for (int i = 0; i < TotalNonZeroArray.length; i++) {
			if (i < 5) {
				MQArrayC[i] = TotalNonZeroArray[i];
			} else if ((i >= 5) && (i < 10)) {
				MQArrayD[i - (MQArrayC.length)] = TotalNonZeroArray[i];
			} else {
				MQArrayE[i - (MQArrayC.length + MQArrayD.length)] = TotalNonZeroArray[i];
			}
		}

		System.out.println("Yさん：");
		System.out.println("直してきました。\n");

		System.out.print("C...");

		//ここに配列Cの要素をすべて出力する処理を記述する。
		for (int i = 0; i < MQArrayC.length; i++) {
			if (i == (MQArrayC.length - 1)) {
				System.out.print(MQArrayC[i]);
			} else {
				System.out.print(MQArrayC[i] + ",");
			}
		}

		System.out.print("\n\nD...");

		//ここに配列Dの要素をすべて出力する処理を記述する。
		for (int i = 0; i < MQArrayD.length; i++) {
			if (i == (MQArrayD.length - 1)) {
				System.out.print(MQArrayD[i]);
			} else {
				System.out.print(MQArrayD[i] + ",");
			}
		}

		System.out.print("\n\nE...");

		//ここに配列Eの要素をすべて出力する処理を記述する。
		for (int i = 0; i < MQArrayE.length; i++) {
			if (i == (MQArrayE.length - 1)) {
				System.out.print(MQArrayE[i]);
			} else {
				System.out.print(MQArrayE[i] + ",");
			}
		}

		System.out.println("\n\nになりました。\n");

		System.out.println("E主任：");
		System.out.println("ご苦労さまでした。");
	}
}
