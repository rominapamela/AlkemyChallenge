package com.example.alkemychallenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.alkemychallenge.databinding.ActivityDetailsBinding
import com.example.alkemychallenge.databinding.ActivityMainBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(this.binding.root)
        bind()
        onClickEvents()

    }


    private fun bind(){
        var popularity = intent.extras?.getString("popularity")
        var title = intent.extras?.getString("title")
        var date = intent.extras?.getString("date")
        var overview= intent.extras?.getString("overview")
        //Toast.makeText(this, "A presionado" + popularity, Toast.LENGTH_SHORT).show()
        this.binding = ActivityDetailsBinding.inflate(layoutInflater)
        this.binding.textPopularity.setText(popularity)
        this.binding.textTitle.setText(title)
        this.binding.textDate.setText(date)
        this.binding.textOverview.setText(overview)
        setContentView(this.binding.root)
    }

    private fun onClickEvents(){
        this.binding.btnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

}