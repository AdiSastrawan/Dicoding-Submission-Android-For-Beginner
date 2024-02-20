package com.adisastrawan.mysubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.adisastrawan.mysubmission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Champion>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvChamps.setHasFixedSize(true)
        list.addAll(getAllChamp())
        showRecyclerView()
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