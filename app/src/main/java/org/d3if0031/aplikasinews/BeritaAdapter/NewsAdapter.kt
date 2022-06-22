package org.d3if0031.aplikasinews.BeritaAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.lay_berita.view.*
import org.d3if0031.aplikasinews.R

class NewsAdapter(val context: Context, val list: List<news>) : RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var currenNews: news? = null
        var currenPosition: Int = 0

        fun setData(currennews: news, position: Int){
            itemView.tvw_title.text = currennews!!.title
            itemView.tvw_Desc.text = currennews!!.desc
            itemView.img_news.setImageResource(currennews!!.photo)

            this.currenNews
            this.currenPosition
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.lay_berita, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var datanews = list[position]
        holder.setData(datanews, position)

        holder.itemView.setOnClickListener() { onItemClickCallback.onItemClick(list[position]) }
    }
    // region 1. Event Click
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    interface OnItemClickCallback {
        fun onItemClick(data: news)
    }


    override fun getItemCount(): Int {
        return list.size
    }
}