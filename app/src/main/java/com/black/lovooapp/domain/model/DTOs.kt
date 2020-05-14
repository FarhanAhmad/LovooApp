package com.black.lovooapp.domain.model

/**
 * Created by farhanahmad on 14/5/20.
 */

data class LovooRoomDTO(val id:String?,
                        val roomNumber:String?,
                        val name:String?,
                        val department:String?,
                        val type:String?,
                        val officeLevel:String?,
                        val lovooFact:LovooFactDTO?)

data class LovooFactDTO(val text:String?,
                       val data:String?,
                       val title:String?,
                       val images:List<String>?)