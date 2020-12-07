package com.example.anotheruselessapp.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.anotheruselessapp.R
import com.google.android.material.checkbox.MaterialCheckBox

class UselessElementView(context: Context, attributeSet: AttributeSet) :
    ConstraintLayout(context, attributeSet) {

    private var titleUseless: TextView
    private var priorityUseless: TextView
    private var isDoneBox: MaterialCheckBox

    init {
        inflate(context, R.layout.view_useless_element, this)

        titleUseless = findViewById(R.id.titleUseless)
        priorityUseless = findViewById(R.id.priorityUseless)
        isDoneBox = findViewById(R.id.isDoneBox)
    }

    fun setBoxListener(isDone: (Boolean) -> Unit) {
        isDoneBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                setTaskDone()
                isDone(isChecked)
            } else {
                isDone(isChecked)
                setTaskInProgress()
            }
        }
    }

    private fun setTaskInProgress() {
        titleUseless.alpha = 1f
        isDoneBox.alpha = 1f
    }

    private fun setTaskDone() {
        titleUseless.alpha = 0.3f
        isDoneBox.alpha = 0.3f
    }

    fun setData(title: String, priority: String, isDone: Boolean) {
        titleUseless.text = title
        priorityUseless.text = priority
        isDoneBox.isChecked = isDone

        if (isDone) {
            setTaskDone()
        }
    }

}