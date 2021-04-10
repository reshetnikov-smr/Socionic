package ru.d3st.socionic.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.d3st.socionic.R


class SplashFragment: Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_splash, container, false)

        val motionLayout: MotionLayout = root.findViewById(R.id.motion_splash)

        val imageView = root.findViewById<ImageView>(R.id.iv_back)
        imageView.setOnClickListener {
            navigateToStart()
        }


/*        motionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
                TODO("Not yet implemented")
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
                TODO("Not yet implemented")
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                navigateToStart()
            }

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
                TODO("Not yet implemented")
            }

        })*/

        return root

    }

    private fun navigateToStart() {
        val action = SplashFragmentDirections.actionSplashFragmentToStartFragment()
        findNavController().navigate(action)
    }
}