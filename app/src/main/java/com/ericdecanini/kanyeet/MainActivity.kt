package com.ericdecanini.kanyeet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  private val viewModel = MainViewModel()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    setButtonListener()
    observeQuote()
  }

  private fun observeQuote() {
    viewModel.quoteLiveData.observe(this) { quote ->
      quote_text.text = quote
    }
  }

  private fun setButtonListener() {
    generate_button.setOnClickListener {
      viewModel.fetchQuote()
    }
  }
}
