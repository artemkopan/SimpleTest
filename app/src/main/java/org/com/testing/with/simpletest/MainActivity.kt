package org.com.testing.with.simpletest

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import org.com.testing.with.simpletest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        val adapter = RVCustomAdapter()
        binding.mRecyclerView.adapter = adapter
        binding.mRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        viewModel.data.observe(this) {
            adapter.setItems(it)
            // todo use ListAdapter or implement notifying data
            adapter.notifyDataSetChanged()
        }
    }
}