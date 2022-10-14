package com.example.myapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
class MainActivity : AppCompatActivity() {    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val gamer = findViewById<EditText>(R.id.gamer)
    val status = findViewById<TextView>(R.id.status)
    val winner = findViewById<TextView>(R.id.winner)
    val name = findViewById<TextView>(R.id.name)
    val mmora = findViewById<TextView>(R.id.mmora)
    val cmora = findViewById<TextView>(R.id.cmora)
    val scissor = findViewById<RadioButton>(R.id.scissor)
    val rock = findViewById<RadioButton>(R.id.rock)
    val paper = findViewById<RadioButton>(R.id.paper)
    val btn_mora = findViewById<Button>(R.id.btn_mora)
    btn_mora.setOnClickListener {

        if (gamer.length() < 1)
            status.text = "請輸入玩家姓名"
        else
            {
            val playerName = gamer.text
            name.text = ("名字\n$playerName")

            if (scissor.isChecked)
                    mmora.text = "我方出拳\n剪刀"
            else if (rock.isChecked)
                    mmora.text = "我方出拳\n石頭"
            else
                    mmora.text = "我方出拳\n布"
            val computer = (Math.random() * 3).toInt()
            if (computer == 0)
                cmora.text = "電腦出拳\n剪刀"
            else if (computer == 1)
                cmora.text = "電腦出拳\n石頭"
            else
                cmora.text = "電腦出拳\n布"

            if (scissor.isChecked && computer == 2
                || rock.isChecked && computer == 0
                || paper.isChecked && computer == 1)
                {
                    winner.text = "勝利者\n$playerName"
                    status.text = "恭喜你獲勝了!!!"
                }
            else if (scissor.isChecked && computer == 1
                || rock.isChecked && computer == 2
                || paper.isChecked && computer == 0)
                {
                winner.text = "勝利者\n電腦"
                status.text = "可惜，電腦獲勝了!"
                }
            else
                {
                winner.text = "勝利者\n平手"
                status.text = "平局，請再試一次!"
                }
            }
        }
}
}