package com.zaelani.pendeteksigempadantsunami.ui.edukasi

import com.zaelani.pendeteksigempadantsunami.utils.Edukasi

data class DataModelEdukasi(
        val edukasi: Edukasi,
        var isExpandable: Boolean = false
)