package com.example.anotheruselessapp

import android.os.Bundle
import android.view.Window
import androidx.transition.Explode
import com.example.anotheruselessapp.data.Priority
import com.example.anotheruselessapp.data.entity.Element
import kotlinx.android.synthetic.main.activity_create_shit.*
import kotlinx.coroutines.*

class CreateShitActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_shit)

        submit.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                viewModel.insertElement(Element(0, titleInput.editText?.text.toString()))
                withContext(Dispatchers.Main) {
                    onBackPressed()
                }
            }
        }
    }
}
