package org.d3if0031.aplikasinews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.d3if0031.aplikasinews.BeritaAdapter.BeritaModel
import org.d3if0031.aplikasinews.BeritaAdapter.NewsAdapter
import org.d3if0031.aplikasinews.BeritaAdapter.news

class MainActivity : AppCompatActivity() {

    lateinit var newsAdapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        var headline:news?
        if(BeritaModel.newsList.size > 0){

            headline = BeritaModel.newsList[BeritaModel.newsList.size -1]
                tvw_TitleHeadLine.setText(headline.title)
                tvw_DescHeadline.setText(headline.desc)
                img_news0.setImageResource(headline.photo)

            cdv_newsheadline.setOnClickListener {
                val detail_intent = Intent(this, DetailActivity::class.java)
                    .apply {
                        putExtra(DetailActivity.cont_TitleNews, headline.title)
                        putExtra(DetailActivity.cont_KontenNews, headline.desc)
                        putExtra(DetailActivity.cont_PhotoNews, headline.photo.toString())
                    }
                startActivity(detail_intent)
                finish()
            }
        }

        var recyclerView = LinearLayoutManager(this)
        recyclerView.orientation = LinearLayoutManager.VERTICAL
        rcv_daftarberita.layoutManager = recyclerView

        newsAdapter = NewsAdapter(this, BeritaModel.newsList)
        rcv_daftarberita.adapter = newsAdapter

        newsAdapter.setOnClickCallback(object : NewsAdapter.OnItemClickCallback {
            override fun onItemClick(data:news) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                    .apply {
                        putExtra(DetailActivity.cont_TitleNews, data.title.toString())
                        putExtra(DetailActivity.cont_KontenNews, data.desc.toString())
                        putExtra(DetailActivity.cont_PhotoNews, data.photo.toString())
                    }
                startActivity(intent)
                finish()
        }})
    }
}