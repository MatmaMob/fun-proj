package com.example.anotheruselessapp.ui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.anotheruselessapp.R
import java.text.SimpleDateFormat
import java.util.*

class UselessTimeView(context: Context, attributeSet: AttributeSet) :
    ConstraintLayout(context, attributeSet) {

    private var uselessDay: TextView
    private var uselessMonth: TextView
    private var uselessTaskCount: TextView

    init {
        inflate(context, R.layout.view_useless_time, this)

        uselessDay = findViewById(R.id.uselessDay)
        uselessMonth = findViewById(R.id.uselessMonth)
        uselessTaskCount = findViewById(R.id.uselessTaskCount)
        setDate()
    }

    private fun setDate() {
        val calendar = Calendar.getInstance().time
        val month = SimpleDateFormat("MMMM", Locale.getDefault())
        val day = SimpleDateFormat("d EEEE", Locale.getDefault())
        uselessMonth.text = "${month.format(calendar)}"
        uselessDay.text = "${day.format(calendar)}"
    }

    fun setCounter(count: Int) {
        if (count > 1) {
            uselessTaskCount.visibility = View.VISIBLE
            uselessTaskCount.text = "Tasks: $count"
        } else {
            uselessTaskCount.visibility = View.GONE
        }
    }
}