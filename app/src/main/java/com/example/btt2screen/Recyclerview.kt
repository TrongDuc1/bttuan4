package com.example.btt2screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import com.example.btt2screen.adapter.ImageAdapter
import com.example.btt2screen.adapter.OnImageItemListener
import com.example.btt2screen.databinding.ActivityRecyclerviewBinding


class Recyclerview : AppCompatActivity() {
    lateinit var binding: ActivityRecyclerviewBinding
    lateinit var adapter: ImageAdapter
    lateinit var viewModel: RecyclerviewViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recyclerview)
        viewModel = ViewModelProvider(this)[RecyclerviewViewModel::class.java]

        setUpRecyclerView()
        setUpViewModelObservers()
    }
    private fun setUpViewModelObservers() {
        viewModel.menuLayoutType.observe(this){
            binding.rvImage.layoutManager = viewModel.getLayout(this)
        }

        viewModel.newList.observe(this){
            setList(it)
        }
    }
    private fun setUpRecyclerView() {
        binding.rvImage.layoutManager = viewModel.getLayout(this);
        adapter = ImageAdapter(onImageItemListener)
        binding.rvImage.adapter = adapter
        run {
            adapter.submitList(DataStore.Restaurant.value)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        viewModel.setLayout(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private val onImageItemListener  = object : OnImageItemListener {
        override fun onClickItem(item: View, restaurant: Image) {
            viewModel.handleItemWhenClicked(item,restaurant)
            Toast.makeText(this@Recyclerview, "on click item", Toast.LENGTH_SHORT).show();
        }

        override fun onLongClick(item: View) {
            viewModel.handleItemWhenLongClicked(item)
            Toast.makeText(this@Recyclerview, "on click long item", Toast
                .LENGTH_SHORT).show();
        }
    }
    private fun setList(newList: MutableList<Image>) {
        DataStore.Restaurant.value?.let {
            ImageAdapter.ImageDiffUtilCallback(
                it,
                newList
            )
        }
            ?.let { DiffUtil.calculateDiff(it).dispatchUpdatesTo(adapter) }
        DataStore.Restaurant.value?.clear()
        DataStore.Restaurant.value?.addAll(newList)
    }

}

