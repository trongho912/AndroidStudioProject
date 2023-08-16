package com.example.thirtydaysapp.data

import com.example.thirtydaysapp.R
import com.example.thirtydaysapp.model.AppContentModel

class AppContent() {
    fun loadAppContent(): List<AppContentModel> {
        return listOf<AppContentModel>(
            AppContentModel(R.drawable.image1, R.string.day1, R.string.content1),
            AppContentModel(R.drawable.image2, R.string.day2, R.string.content2),
            AppContentModel(R.drawable.image3, R.string.day3, R.string.content3),
            AppContentModel(R.drawable.image4, R.string.day4, R.string.content4),
            AppContentModel(R.drawable.image5, R.string.day5, R.string.content5),
            AppContentModel(R.drawable.image6, R.string.day6, R.string.content6),
            AppContentModel(R.drawable.image7, R.string.day7, R.string.content7),
            AppContentModel(R.drawable.image8, R.string.day8, R.string.content8),
            AppContentModel(R.drawable.image9, R.string.day9, R.string.content9),
            AppContentModel(R.drawable.image10, R.string.day10, R.string.content10),
            AppContentModel(R.drawable.image11, R.string.day11, R.string.content11),
            AppContentModel(R.drawable.image12, R.string.day12, R.string.content12),
            AppContentModel(R.drawable.image13, R.string.day13, R.string.content13),
            AppContentModel(R.drawable.image14, R.string.day14, R.string.content14),
            AppContentModel(R.drawable.image15, R.string.day15, R.string.content15)
        )
    }
}