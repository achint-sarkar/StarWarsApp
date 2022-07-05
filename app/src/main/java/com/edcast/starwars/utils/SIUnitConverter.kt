package com.edcast.starwars.utils

object SIUnitConverter {
    fun convertCentimeterToMeter(cms: String?): String {
       return cms?.let { (cms.toDouble()/100).toString() }?:"0.0"
    }

    fun massToKgs(mass:String?):String{
        return mass?.let { "$mass kgs" }?:"0 kg"
    }
}