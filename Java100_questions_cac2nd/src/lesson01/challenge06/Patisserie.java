/**
 * 第1章 マカロン屋さんのお仕事
 *
 * 問題6  在庫を減らす
 *
 * [問題5]までの表示を行った後で
 * 3種のマカロンそれぞれの在庫を減らす処理を追記し
 * 以下の実行例と同じものを最後に表示してください。
 *
 * <実行例>
 *
 * ～～～～～～～～～省略～～～～～～～～～～～
 *
 * 本日のおすすめ商品です。
 *
 * シトロン      \250 ・・・ 残り22個
 * ショコラ      \280 ・・・ 残り28個
 * ピスターシュ  \320 ・・・ 残り24個
 *
 */

package lesson01.challenge06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Patisserie {

	public static void main(String[] args) throws IOException {
		//		変数の宣言
		int stock_citron = 30;
		int stock_chocolate = 30;
		int stock_p = 30;

		//		文字の表示
		System.out.println("本日のおすすめ商品です。\n");
		System.out.println("シトロン　　　\\250 ・・・ 残り" + stock_citron + "個");
		System.out.println("ショコラ　　　\\280 ・・・ 残り" + stock_chocolate + "個");
		System.out.println("ピスターシュ　\\320 ・・・ 残り" + stock_p + "個");

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

		stock_citron = stock_citron - num_citron;
		stock_chocolate = stock_chocolate - num_chocolate;
		stock_p = stock_p - num_p;

		System.out.println("本日のおすすめ商品です");
		System.out.println("シトロン　　　\\250 ・・・ 残り" + stock_citron + "個");
		System.out.println("ショコラ　　　\\280 ・・・ 残り" + stock_chocolate + "個");
		System.out.println("ピスターシュ　\\320 ・・・ 残り" + stock_p + "個");

	}

}
