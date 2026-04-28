/**
 * 第4章 倉庫番のお仕事
 *
 * 問題8 荷物の入れ替え（二つの配列の要素を入れ替える）
 *
 * AB興産から新たな荷物のセットを預かりました。
 * 5袋からなる荷物のセットで、それぞれ6～10の数値が入っており、
 * どの袋にどの数値が入っているのかはランダムに決定し、
 * それぞれの袋の値は重複しません。
 *
 * AB興産からの依頼は、以前から預かっている1～5の荷物と
 * 今回預かる6～10の荷物を再編し、奇数のみの配列と
 * 偶数のみの配列に分けるというものです。
 *
 * コメントの位置に適切なコードを記述し、
 * 実行例と同じメッセージを表示してください。
 *
 * <実行例>
 *  E主任：
 *  AB興産から新たに預かった荷物と以前から預かっている荷物の
 *  中身を確認してください。
 *
 *  Yさん：
 *  はい、
 *  以前から預かっている荷物の状態は、
 *  3,2,1,5,4
 *  です。
 *
 *  今回預かった荷物の状態は、
 *  7,9,10,6,8
 *  です。
 *
 *  E主任：
 *  その二つの荷物を奇数群、偶数群で入れ替えてください。
 *
 *  Yさん：
 *  はい、入れ替えました。
 *  奇数群の荷物の状態は、
 *  3,5,1,9,7
 *  です。
 *
 *  偶数群の荷物の状態は、
 *  10,2,8,6,4
 *  です。
 *
 */

package lesson04.challenge08;

public class WarehouseManager {

	public static void main(String[] args) {

		int[] ABKosanArray1 = new int[5];
		int[] ABKosanArray2 = new int[5];

		boolean loopFlag = false;
		int inputNum1 = 0;
		int inputNum2 = 0;

		//ここに重複チェックおよび値の代入処理を記述する①(1～5)
		for (int i = 0; i < ABKosanArray1.length; i++) {
			inputNum1 = (int) (Math.random() * 10 % 5 + 1);
			loopFlag = false;

			do {
				loopFlag = false;
				inputNum1 = (int) (Math.random() * 10 % 5 + 1);

				for (int j = 0; j < ABKosanArray1.length; j++) {
					if (ABKosanArray1[j] == inputNum1) {
						loopFlag = true;
						break;
					}
				}
			} while (loopFlag);

			ABKosanArray1[i] = inputNum1;
		}

		//ここに重複チェックおよび値の代入処理を記述する②(6～10)
		for (int i = 0; i < ABKosanArray2.length; i++) {
			inputNum2 = (int) (Math.random() * 10 % 5 + 6);
			loopFlag = false;

			do {
				loopFlag = false;
				inputNum2 = (int) (Math.random() * 10 % 5 + 6);

				for (int j = 0; j < ABKosanArray2.length; j++) {
					if (ABKosanArray2[j] == inputNum2) {
						loopFlag = true;
						break;
					}
				}
			} while (loopFlag);

			ABKosanArray2[i] = inputNum2;
		}

		System.out.println("E主任：");
		System.out.println("AB興産から新たに預かった荷物と以前から預かっている荷物の");
		System.out.println("中身を確認してください。\n");

		System.out.println("Yさん：");
		System.out.println("はい、");
		System.out.println("以前から預かっている荷物の状態は、");
		for (int i = 0; i < ABKosanArray1.length; i++) {
			System.out.print(ABKosanArray1[i]);
			if (i != (ABKosanArray1.length - 1)) {
				System.out.print(",");
			}
		}
		System.out.println("\nです。\n");

		System.out.println("今回預かった荷物の状態は、");
		for (int i = 0; i < ABKosanArray2.length; i++) {
			System.out.print(ABKosanArray2[i]);
			if (i != (ABKosanArray2.length - 1)) {
				System.out.print(",");
			}
		}
		System.out.println("\nです。\n");

		System.out.println("E主任：");
		System.out.println("その二つの荷物を奇数群、偶数群で入れ替えてください。\n");

		//ここに奇数群(ABKosanArray1)と偶数群(ABKosanArray2)に振り分ける処理を記述する。
		//昇順の配列にまとめてから、奇数群と偶数群に振り分ける
		int[] evenArray = new int[5];
		int[] oddArray = new int[5];
		int[] AllAscendingArray = new int[10];

		for (int i = 0; i < ABKosanArray1.length; i++) {
			switch (ABKosanArray1[i]) {
			case 1:
				AllAscendingArray[0] = ABKosanArray1[i];
				break;
			case 2:
				AllAscendingArray[1] = ABKosanArray1[i];
				break;
			case 3:
				AllAscendingArray[2] = ABKosanArray1[i];
				break;
			case 4:
				AllAscendingArray[3] = ABKosanArray1[i];
				break;
			default:
				AllAscendingArray[4] = ABKosanArray1[i];
				break;
			}
		}

		for (int i = 0; i < ABKosanArray2.length; i++) {
			switch (ABKosanArray2[i]) {
			case 6:
				AllAscendingArray[5] = ABKosanArray2[i];
				break;
			case 7:
				AllAscendingArray[6] = ABKosanArray2[i];
				break;
			case 8:
				AllAscendingArray[7] = ABKosanArray2[i];
				break;
			case 9:
				AllAscendingArray[8] = ABKosanArray2[i];
				break;
			default:
				AllAscendingArray[9] = ABKosanArray2[i];
				break;
			}
		}

		for (int i = 0; i < AllAscendingArray.length; i++) {
			if ((i % 2) != 0) {
				evenArray[i / 2] = AllAscendingArray[i];
			} else {
				oddArray[i / 2] = AllAscendingArray[i];
			}
		}

		System.out.println("Yさん：");
		System.out.println("はい、入れ替えました。");
		System.out.println("奇数群の荷物の状態は、");
		for (int i = 0; i < oddArray.length; i++) {
			System.out.print(oddArray[i]);
			if (i != (oddArray.length - 1)) {
				System.out.print(",");
			}
		}
		System.out.println("\nです。\n");

		System.out.println("偶数群の荷物の状態は、");
		System.out.println("");
		for (int i = 0; i < evenArray.length; i++) {
			System.out.print(evenArray[i]);
			if (i != (evenArray.length - 1)) {
				System.out.print(",");
			}
		}
		System.out.println("\nです。");

	}
}
