package com.adisastrawan.mysubmission

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import com.adisastrawan.mysubmission.databinding.ActivityDetailBinding
import com.adisastrawan.mysubmission.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_CHAMPION = "extra_champion"
    }
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        supportActionBar?.setTitle(Html.fromHtml("<font  color=\"#C8AA6E\">"+getString(R.string.title)+"</font>"))
        supportActionBar?.hide()
        setContentView(binding.root)
        val champion = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Champion>(EXTRA_CHAMPION, Champion::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Champion>(EXTRA_CHAMPION)
        }
        champion?.photo?.let { binding.imgChamp.setImageResource(it) }
        binding.tvChampSubname.text = champion?.subname.toString()
        binding.tvChampName.text = champion?.name.toString()
        binding.tvChampDesc.text = champion?.description.toString()
        binding.tvDifficulty.text = champion?.difficulty.toString()
        binding.tvRole.text = champion?.role.toString()
        binding.actionShare.setOnClickListener{
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "${champion?.name.toString()} - ${champion?.subname.toString()}")
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(intent, null)
            startActivity(shareIntent)
        }
    }
}