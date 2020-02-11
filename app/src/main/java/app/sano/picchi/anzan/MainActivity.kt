package app.sano.picchi.anzan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //0から999の数字をランダムに作る
        val randomNumber1 = Random.nextInt(1000)
        val randomNumber2 = Random.nextInt(1000)

        number1text.text = randomNumber1.toString()
        numbre2Text.text = randomNumber2.toString()

        //0か1の数字をランダムに作る
        val randomOperator = Random.nextInt(2)

        //符号を入れる変数を作る
        var operatorText = ""

        //答えを入れる変数
        var correctAnswer = 0

        //ランダムに作った数字が0だったら
        if (randomOperator == 0) {
            operatorText = "+"
            signText.text = operatorText
            correctAnswer = randomNumber1 + randomNumber2

        }
        //ランダムに作った数字が1だったら
        else{
            operatorText = "−"
            signText.text  = operatorText
            correctAnswer = randomNumber1 - randomNumber2

        }

        checkButton.setOnClickListener {
            val yourAnswer = inputText.text.toString()

            if (yourAnswer.isNotEmpty()){

                //正解不正解を表示する画面に情報を送る変数を準備する
                val answerPage = Intent(this,AnswerActivity::class.java)

                //問題を文字列で作る
                val questionText = randomNumber1.toString() + operatorText + randomNumber2.toString() + " ="

                //問題をセット
                answerPage.putExtra("quesion",questionText)
                //入力された数字をセットする
                answerPage.putExtra("answer",yourAnswer)
                //正しい答えをセット
                answerPage.putExtra("correct",correctAnswer.toString())
                //判定を表示
                startActivity(answerPage)
                //クイズ画面を閉じる
                finish()

            }
        }








    }
}
