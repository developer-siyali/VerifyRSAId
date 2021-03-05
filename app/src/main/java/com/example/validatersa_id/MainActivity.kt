package com.example.validatersa_id

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.validatersa_id.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private val presenterMainActivity =  PresenterMainActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.inputId.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s?.length == TOTAL_NUMERIC_CHARACTERS) {
                    binding.verifyButton.isEnabled = true
                    binding.verifyButton.setOnClickListener{
                        val flag =  (presenterMainActivity.validateID(s.toString()))
                        if (flag){
                            binding.validatedOutput.text = getString(R.string.valid_id)
                        } else {
                            binding.validatedOutput.text = getString(R.string.invalid_id)
                        }
                        binding.verifyButton.isEnabled = false
                    }
                } else {
                    binding.verifyButton.isEnabled = false
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                binding.verifyButton.isEnabled = false
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.length == TOTAL_NUMERIC_CHARACTERS) {
                    binding.verifyButton.isEnabled = true
                    binding.verifyButton.setOnClickListener{
                        presenterMainActivity.validateID(s.toString())
                    }
                } else {
                    binding.verifyButton.isEnabled = false
                }
            }
        })

    }

    companion object {
        const val TOTAL_NUMERIC_CHARACTERS = 13
    }


}
