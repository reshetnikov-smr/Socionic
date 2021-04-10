package ru.d3st.socionic.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.d3st.socionic.R

/**
The fragment does not save any data and therefore does not need to use the ViewModel
and DataBinding
 */


class AboutFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_about, container, false)

        val back = root.findViewById<Button>(R.id.btn_back)

        back.setOnClickListener {
            val action = AboutFragmentDirections.actionAboutFragmentToStartFragment()
            findNavController().navigate(action)
        }

        return root

    }

}