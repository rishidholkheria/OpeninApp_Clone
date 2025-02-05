package com.example.openinapp.ui.links

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bumptech.glide.Glide
import com.example.openinapp.databinding.ListItemBinding
import com.example.openinapp.model.Link
import com.example.openinapp.utils.HelperFunctions

class CustomAdapter(private val context: Context, private val dataSource: List<Link>) :
    BaseAdapter() {

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Link {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding: ListItemBinding
        if (convertView == null) {
            binding = ListItemBinding.inflate(inflater, parent, false)
        } else {
            binding = ListItemBinding.bind(convertView)
        }

        val listItem = getItem(position)

        Glide.with(context).load(listItem.original_image).into(binding.linkImg)
        binding.linkName.text = listItem.title
        binding.linkDate.text = HelperFunctions.getDate(listItem.created_at)
        binding.link.text = listItem.web_link
        binding.clickedNumber.text = listItem.total_clicks.toString()

//        Copy to clipboard functionality
        binding.link.setOnClickListener {
            HelperFunctions.copyToClipboard(context, "Links", listItem.web_link)
        }

        return binding.root
    }
}
