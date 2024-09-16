package com.example.practico_4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File

class ListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DateAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val dates = readDatesFromFile()
        adapter = DateAdapter(dates)
        recyclerView.adapter = adapter
    }

    private fun readDatesFromFile(): List<String> {
        val photoFile = File(filesDir, "photos/date.txt")
        return if (photoFile.exists()) {
            photoFile.readLines()
        } else {
            emptyList()
        }
    }
}
