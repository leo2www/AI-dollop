package com.H.affirmations.data

import com.H.affirmations.model.Affirmation
import com.H.affirmations.model.Dog
import com.H.ai_dollop.R

class Datasource {
    // loadAffirmations() 方法会收集起始代码中提供的所有数据，
    // 并以列表形式将其返回。稍后，您将使用这些数据来构建可滚动列表。
    // 一种中间层
    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation2, R.drawable.image2),
            Affirmation(R.string.affirmation3, R.drawable.image3),
            Affirmation(R.string.affirmation4, R.drawable.image4),
            Affirmation(R.string.affirmation5, R.drawable.image5),
            Affirmation(R.string.affirmation6, R.drawable.image6),
            Affirmation(R.string.affirmation7, R.drawable.image7),
            Affirmation(R.string.affirmation8, R.drawable.image8),
            Affirmation(R.string.affirmation9, R.drawable.image9),
            Affirmation(R.string.affirmation10, R.drawable.image10)
        )
    }

    fun loadDogs(): List<Dog> {
        return listOf<Dog>(
            Dog(R.drawable.koda, R.string.dog_name_1, 2, R.string.dog_description_1),
            Dog(R.drawable.lola, R.string.dog_name_2, 16, R.string.dog_description_2),
            Dog(R.drawable.frankie, R.string.dog_name_3, 2, R.string.dog_description_3),
            Dog(R.drawable.nox, R.string.dog_name_4, 8, R.string.dog_description_4),
            Dog(R.drawable.faye, R.string.dog_name_5, 8, R.string.dog_description_5),
            Dog(R.drawable.bella, R.string.dog_name_6, 14, R.string.dog_description_6),
            Dog(R.drawable.moana, R.string.dog_name_7, 2, R.string.dog_description_7),
            Dog(R.drawable.tzeitel, R.string.dog_name_8, 7, R.string.dog_description_8),
            Dog(R.drawable.leroy, R.string.dog_name_9, 4, R.string.dog_description_9)

        )
    }
}