package ru.d3st.socionic.presenatation.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.d3st.socionic.R

/**
 * Screen with start animation
 */
@Deprecated("Will be changed on compose version")
class SplashFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_splash, container, false)

        (root as? MotionLayout)?.run {
            root.addTransitionListener( object: MotionLayout.TransitionListener{
                override fun onTransitionStarted(
                    motionLayout: MotionLayout?,
                    startId: Int,
                    endId: Int,
                ) {
                    //don't use
                }

                override fun onTransitionChange(
                    motionLayout: MotionLayout?,
                    startId: Int,
                    endId: Int,
                    progress: Float,
                ) {
                    //don't use
                }

                override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                    navigateToStart()
                }

                override fun onTransitionTrigger(
                    motionLayout: MotionLayout?,
                    triggerId: Int,
                    positive: Boolean,
                    progress: Float,
                ) {
                    //don't use
                }

            })
        }
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