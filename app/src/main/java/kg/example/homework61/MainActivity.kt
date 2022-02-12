package kg.example.homework61

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kg.example.homework61.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var registerForActivityResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGo.setOnClickListener {
            if (binding.tvMail.text.toString().isEmpty()){
                Toast.makeText(this, "Вы нечего не написали!!!", Toast.LENGTH_SHORT).show()

            }else{
                Intent(this@MainActivity,EmailActivity::class.java).apply {
                    putExtra("edit_text", binding.tvMail.text.toString())
                    registerForActivityResult.launch(this)
                }
            }
        }
        registerForActivityResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){result->
            binding.tvMail.setText(result.data?.getStringExtra("result"))
        }
    }
}