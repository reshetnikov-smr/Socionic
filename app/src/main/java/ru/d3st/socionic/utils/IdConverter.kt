package ru.d3st.socionic.utils

import ru.d3st.socionic.models.presentation.SocionicTypes
import javax.inject.Inject

class IdConverter @Inject constructor(){

    /**
     * Convert newType Id ("ENTJ")to oldType id ("112")
     */
    fun convert(id : String) : Int? {
        return (SocionicTypes from id)?.oldId
    }
}