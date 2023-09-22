package com.example.kt_less17

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)


        val listView: RecyclerView = findViewById(R.id.listView)
        val api = ApiClient.client.create(ApiInterface::class.java)
        api.getRequest()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                if (response.isNotEmpty()) {
                    val items = response

                    // Створюємо адаптер та передаємо дані у фрагмент ListFragment
                    val myAdapter = MyRecyclerViewAdapter(items) { selectedItem ->
                        val detailFragment =
                            ListFragment.newInstance(selectedItem.biography.firstAppearance, selectedItem.images.lg)
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.myFragment, detailFragment)
                            .addToBackStack("ListFragment")
                            .commit()
                    }

                    // Встановлюємо адаптер для RecyclerView
                    listView.adapter = myAdapter
                }
            }, { error ->
                // Обробка помилки запиту
                error.printStackTrace()
                Toast.makeText(this, "Error: ${error.message}", Toast.LENGTH_SHORT).show()
            })

        val dividerItemDecoration = DividerItemDecoration(listView.context, LinearLayoutManager.VERTICAL)
        listView.addItemDecoration(dividerItemDecoration)
        listView.layoutManager = LinearLayoutManager(this)
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            // Видаляємо останній фрагмент зі стеку бекстеку
            supportFragmentManager.popBackStack()
        } else {
            // Якщо стек бекстеку пустий, викликаємо стандартний onBackPressed
            super.onBackPressed()
        }
    }
}