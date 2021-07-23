package jay.nehete.calz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvOne.setOnClickListener { appendOnClick("1", true) }
        tvTwo.setOnClickListener { appendOnClick("2", true) }
        tvThree.setOnClickListener { appendOnClick("3", true) }
        tvFour.setOnClickListener { appendOnClick("4", true) }
        tvFive.setOnClickListener { appendOnClick("5", true) }
        tvSix.setOnClickListener { appendOnClick("6", true) }
        tvSeven.setOnClickListener { appendOnClick("7", true) }
        tvEight.setOnClickListener { appendOnClick("8", true) }
        tvNine.setOnClickListener { appendOnClick("9", true) }
        tvZero.setOnClickListener { appendOnClick("0", true) }
        tvDecimal.setOnClickListener { appendOnClick(".", true) }


        tvLeftPara.setOnClickListener { appendOnClick("(", false) }
        tvRightPara.setOnClickListener { appendOnClick(")", false) }
        tvAdd.setOnClickListener { appendOnClick("+", false) }
        tvSubtract.setOnClickListener { appendOnClick("-", false) }
        tvMultiply.setOnClickListener { appendOnClick("*", false) }
        tvDivide.setOnClickListener { appendOnClick("/", false) }

        tvClear.setOnClickListener {
            tvInput.text = ""
            tvOutput.text = ""
        }

        tvDelete.setOnClickListener {
            val string = tvInput.text.toString()
            if(string.isNotEmpty()) {
                tvInput.text = string.substring(0,string.length-1)
            }
            tvOutput.text = ""
        }

        tvEqual.setOnClickListener {
            val input = ExpressionBuilder(tvInput.text.toString()).build()
            val output = input.evaluate()
            tvOutput.text = output.toString()
        }
    }

    fun appendOnClick(string : String, onClear : Boolean) {
        if(tvOutput.text.isNotEmpty()) {
            tvInput.text = ""
        }

        if(onClear) {
            tvOutput.text = ""
            tvInput.append(string)
        }
        else {
            tvInput.append(tvOutput.text)
            tvInput.append(string)
            tvOutput.text = ""
        }
    }
}