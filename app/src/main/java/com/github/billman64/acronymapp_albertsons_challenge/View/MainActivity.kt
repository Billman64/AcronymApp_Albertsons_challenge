package com.github.billman64.acronymapp_albertsons_challenge.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.github.billman64.acronymapp_albertsons_challenge.R
import com.github.billman64.acronymapp_albertsons_challenge.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private var searchFragment: SearchFragment = SearchFragment()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {

            val acro = binding.acronymEdittext.text.toString().trim()

            if(acro.isNotEmpty())
                openSearchFragment(acro)
            else
                Toast.makeText(this, getString(R.string.error_emptytext), Toast.LENGTH_SHORT).show()
        }


    }

    private fun openSearchFragment(acro: String) {
        val bundle = Bundle().also {
            it.putString("acronym", acro)
        }
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                android.R.anim.slide_in_left,
                android.R.anim.slide_out_right,
                android.R.anim.slide_in_left,
                android.R.anim.slide_out_right
            )
            .add(R.id.main_frame, searchFragment.also {
                it.arguments = bundle
            }).addToBackStack(searchFragment.tag)
            .commit()
    }

}