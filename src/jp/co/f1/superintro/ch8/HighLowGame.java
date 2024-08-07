package jp.co.f1.superintro.ch8;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class HighLowGame {
    public static void main(String[] args){
        // ランダムに表示される数字の最小値と最大値を設定する。
        int min = 1;
        int max = 9;
        // 勝ち数をカウントする。
        int win_count = 0;

        // タイトル表示部分
        System.out.println("*****************\n*  High & Low   *\n*****************\n");

        while (true){
            // ランダムな数を生成する
            Random random = new Random();
            int value = random.nextInt(max) + min;
            int hidevalue = random.nextInt(max) + min;

            // 問題表示部分
            System.out.println("[Round "+(win_count + 1) +"]\n＊＊＊＊＊　＊＊＊＊＊\n＊　　　＊　＊　＊　＊\n＊  "+ value +"  ＊　＊　＊　＊\n＊　　　＊　＊　＊　＊\n＊＊＊＊＊　＊＊＊＊＊");


            // 入力部分(+入力チェック)
            String input;
            while (true){
                Scanner sc = new Scanner(System.in);
                // 指定外の入力をしたときには、catchを実行する。これにより、指定外の型入力のエラーを回避する。
                try {
                    System.out.print("High or Low? (h/l) ＞");
                    input = sc.nextLine();
                    if (input.equals("h") || input.equals("l")){
                        break;
                    }
                    else {
                        System.out.println("hかl以外は入力できません。hかlで入力してください。");
                    }
                } catch (InputMismatchException e){
                    System.out.println("hかl以外は入力できません。hかlで入力してください。");
                }
            }

            // 結果表示部分
            System.out.println("[結果表示]\n＊＊＊＊＊　＊＊＊＊＊\n＊　　　＊　＊　　　＊\n＊  "+ value +"  ＊　＊　"+ hidevalue +"　 ＊\n＊　　　＊　＊　　　＊\n＊＊＊＊＊　＊＊＊＊＊");
            System.out.println("裏返されていたカードの数字は"+ hidevalue +"でした。");

            // 判定表示部分
            // High正解判定
            if (value < hidevalue && input.equals("h")){
                System.out.println("正解はHigh\nYou Win!!");
                win_count++;
            }
            // Low正解判定
            else if (value > hidevalue && input.equals("l")) {
                System.out.println("正解はLow\nYou Win!!");
                win_count++;
            }
            // 同数判定
            else if (value == hidevalue){
                System.out.println("数値が同じ場合は、どちらを選んでも勝利です。\nYou Win!!");
                win_count++;
            }
            // それ以外(ゲームオーバー判定)
            else {
                System.out.println("You Lose...\n--ゲーム終了--");
                System.out.println("Score："+ win_count +"勝");
                // ゲームを終了し、whileから抜ける
                break;
            }
            // 勝利数の表示
            System.out.println("現在："+ win_count +"勝です。");
        }
    }
}
