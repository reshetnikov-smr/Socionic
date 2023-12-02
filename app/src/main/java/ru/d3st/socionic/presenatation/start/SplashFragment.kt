package ru.d3st.socionic.presenatation.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.d3st.socionic.R


class SplashFragment: Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_splash, container, false)

        val imageView = root.findViewById<ImageView>(R.id.iv_back)
        imageView.setOnClickListener {
            navigateToStart()
        }


        return root

    }

    private fun navigateToStart() {
        val action = SplashFragmentDirections.actionSplashFragmentToStartFragment()
        findNavController().navigate(action)
    }
}