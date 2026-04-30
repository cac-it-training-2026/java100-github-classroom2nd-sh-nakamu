/**
 * 第1章 マカロン屋さんのお仕事
 *
 * 問題5 合計金額を求める
 *
 * 入力されたマカロンの個数から合計購入数、合計金額を求めます。
 * 合計購入数、合計金額を求める処理を追記した後で
 * [問題4]の表示を実行例を参考にして改変してください。
 *
 * <実行例>
 *
 * それぞれ何個ずつ買いますか？（最大30個まで）
 *
 * シトロン      >8
 * ショコラ      >2
 * ピスターシュ  >6
 *
 * シトロン     8個
 * ショコラ     2個
 * ピスターシュ 6個
 *
 * 合計個数    16個
 * 合計金額  4480円
 *
 * をお買いあげですね。
 * 承りました。
 *
 */

package lesson01.challenge05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Patisserie {

	public static void main(String[] args) throws IOException {
		//		変数の宣言
		int a = 30;
		int b = 30;
		int c = 30;

		//		文字の表示
		System.out.println("本日のおすすめ商品です。\n");
		System.out.println("シトロン　　　\\250 ・・・ 残り" + a + "個");
		System.out.println("ショコラ　　　\\280 ・・・ 残り" + b + "個");
		System.out.println("ピスターシュ　\\320 ・・・ 残り" + c + "個");

		//		文字列の出力
		System.out.println("それぞれ何個ずつ買いますか？（最大30個まで）\n");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("シトロン		>");
		String input_citron = reader.readLine();
		int num_citron = Integer.parseInt(input_citron);

		System.out.print("ショコラ		>");
		String input_chocolate = reader.readLine();
		int num_chocolate = Integer.parseInt(input_chocolate);

		System.out.print("ピスターシュ	>");
		String input_p = reader.readLine();
		int num_p = Integer.parseInt(input_p);

		System.out.println("シトロン		>" + num_citron + "個");
		System.out.println("ショコラ		>" + num_chocolate + "個");
		System.out.println("ピスターシュ	>" + num_p + "個\n");

		int sum = num_citron + num_chocolate + num_p;
		int total_amount = num_citron * 250 + num_chocolate * 280 + num_p * 320;
		System.out.println("合計個数\t" + sum + "個");
		System.out.println("合計金額\t" + total_amount + "円\n");

		System.out.println("をお買い上げですね");
		System.out.println("承りました");
	}

}
