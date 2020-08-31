package ru.gressor.kotlincourse.homework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.gressor.kotlincourse.R

class MainActivity : AppCompatActivity() {
    private lateinit var button : Button
    private lateinit var textView: TextView

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        textView = findViewById(R.id.text_view)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.value().observe(this, Observer {
            textView.text = it
        })

        button.setOnClickListener { viewModel.onClick() }
    }
}