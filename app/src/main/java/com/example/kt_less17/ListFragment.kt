package com.example.kt_less17

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment

class ListFragment : Fragment() {
    // Оголосіть статичний метод newInstance з параметром для передачі даних
    companion object {
        fun newInstance(biographyText: String, imageUrl: String): ListFragment {
            val fragment = ListFragment()
            val args = Bundle()
            args.putString("biographyText", biographyText)
            args.putString("imageUrl", imageUrl)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val biographyText = arguments?.getString("biographyText")
        val imageUrl = arguments?.getString("imageUrl")

        val biography: TextView = view.findViewById(R.id.fragmentText)
        val xxlImage: ImageView = view.findViewById(R.id.fragmentImage)

        // Встановлення тексту біографії і відображення зображення за URL
        biography.text = biographyText
        // Завантаження і відображення зображення за imageUrl з використанням бібліотеки Glide або іншої
        // бібліотеки для завантаження зображень.
    }
}