package com.black.lovooapp.domain.model

import com.black.lovooapp.common.BaseModel

/**
 * Created by farhanahmad on 14/5/20.
 */

data class LovooRoomDTO(val id: String?,
                        val roomNumber: String? = null,
                        val name: String? = null,
                        val department: String? = null,
                        val type: String? = null,
                        val officeLevel: String? = null,
                        val lovooFact: LovooFactDTO? = null) : BaseModel() {

    override fun isValid(): Boolean {
        //Checking for important fields
        return !id.isNullOrBlank() && !roomNumber.isNullOrBlank() && !name.isNullOrBlank()
    }
}

data class LovooFactDTO(val text: String?,
                        val title: String?,
                        val images: List<String>?) : BaseModel() {
    override fun isValid(): Boolean {
        return !title.isNullOrBlank()
    }
}