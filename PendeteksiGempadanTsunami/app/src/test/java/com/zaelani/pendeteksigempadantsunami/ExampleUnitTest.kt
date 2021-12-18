package com.zaelani.pendeteksigempadantsunami

import DataModelEdukasi
import com.zaelani.pendeteksigempadantsunami.utils.EdukasiData
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private var mListEdukasi = ArrayList<DataModelEdukasi>()
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    fun check(){
        val model1 = DataModelEdukasi(EdukasiData.sebelumGempa())
        val model2 = DataModelEdukasi(EdukasiData.saatGempa())
        val model3 = DataModelEdukasi(EdukasiData.setelahGempa())
        mListEdukasi.add(model1)
        mListEdukasi.add(model2)
        mListEdukasi.add(model3)
        print(mListEdukasi)
    }
}