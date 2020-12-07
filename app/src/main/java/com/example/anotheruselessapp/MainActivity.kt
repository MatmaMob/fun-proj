package com.example.anotheruselessapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.isEmpty
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anotheruselessapp.data.entity.Element
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.element.observe(this) {
            uselessHeader.setCounter(it.size)
            if (it.isNotEmpty()) {
                setUselessList(it)
            } else {
                setUselessInformation()
            }
        }

        openShit.setOnClickListener {
            startActivity(Intent(this@MainActivity, CreateShitActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.refresh()
    }

    private fun setUselessInformation() {
        emptyListInfo.visibility = View.VISIBLE
        uselessRecycler.visibility = View.GONE
    }

    private fun removeUselessInformation() {
        emptyListInfo.visibility = View.GONE
        uselessRecycler.visibility = View.VISIBLE
    }

    private fun setUselessList(elements: List<Element>) {
        removeUselessInformation()
        val lm = LinearLayoutManager(this)
        val adapter = UselessAdapter(elements, {
            GlobalScope.launch(Dispatchers.IO) {
                viewModel.updateElement(it)
            }
        }) {
            GlobalScope.launch(Dispatchers.IO) {
                viewModel.deleteElement(it)
            }
        }
        uselessRecycler.layoutManager = lm
        uselessRecycler.adapter = adapter

    }
}
