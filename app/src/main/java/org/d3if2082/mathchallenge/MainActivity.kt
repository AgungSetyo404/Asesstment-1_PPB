package org.d3if2082.mathchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import org.d3if2082.mathchallenge.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val num1 = Random(100)
        val num2 = Random(100)


        binding.Check.setOnClickListener { result() }
        binding.Generate.setOnClickListener { generate() }

    }

    private fun result(){
        val num1 = binding.bil1.text.toString()
        val num2 = binding.bil2.text.toString()
        val Answer_Input = binding.AnswerInput.text.toString()

        val bil1 = num1
        val bil2 = num2

        val ai_result = bil1 + bil2
        if (TextUtils.isEmpty(Answer_Input)) {
            Toast.makeText(this, R.string.answer_invalid, Toast.LENGTH_LONG).show()
            return
        }

        if (Answer_Input != ai_result) {
            binding.respondMessage.text = getString(R.string.answer_wrong, Answer_Input)
        }else{
            binding.respondMessage.text = getString(R.string.result_x, ai_result)
        }
    }


    fun generate(){
        binding.respondMessage.setText("")
        binding.AnswerInput.setText("")

        val num1 = Random.nextInt(1,100)
        val num2 = Random.nextInt(1,100)
        val bil1 = num1
        val bil2 = num2
    }

}
