package com.adisastrawan.mysubmission

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.adisastrawan.mysubmission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Champion>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.blue_6)))
        supportActionBar?.setIcon(R.drawable.lol_flat)
        supportActionBar?.setTitle(Html.fromHtml("<font  color=\"#C8AA6E\">"+getString(R.string.title)+"</font>"))
        setContentView(binding.root)
        binding.rvChamps.setHasFixedSize(true)
        list.addAll(getAllChamp())
        showRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.about_page ->{

            }
        }
        return super.onOptionsItemSelected(item)
    }
    private fun showRecyclerView() {
        binding.rvChamps.layoutManager = LinearLayoutManager(this)
        val listViewAdapter = ListChampionAdapter(list)
        binding.rvChamps.adapter = listViewAdapter
    }

    private fun getAllChamp(): ArrayList<Champion> {
        val dataName = resources.getStringArray(R.array.champions_name)
        val dataDesc = resources.getStringArray(R.array.champions_desc)
        val photos = resources.obtainTypedArray(R.array.champ_photo)
        val listChamp =ArrayList<Champion>()
        for(i in dataName.indices){
            val champions = Champion(dataName[i],dataDesc[i],photos.getResourceId(i,-1))
            listChamp.add(champions)
        }
        return listChamp
    }

}