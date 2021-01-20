package com.example.anotheruselessapp.activities

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.anotheruselessapp.R
import com.example.anotheruselessapp.data.entity.Element
import kotlinx.android.synthetic.main.activity_create_shit.*
import kotlinx.coroutines.*

class CreateSomethingActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_shit)

        viewModel.testString.observe(this, Observer {
            testStringView.text = it
        })

        submit.setOnClickListener {

            viewModel.testString.value = titleInput.editText?.text.toString()

            GlobalScope.launch(Dispatchers.IO) {

                for (i in 0..15) {
                    viewModel.insertElement(Element(0, titleInput.editText?.text.toString()))
                }
                withContext(Dispatchers.Main) {
                    onBackPressed()
                }
            }
        }
    }
}
