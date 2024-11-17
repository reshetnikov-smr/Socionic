package ru.d3st.socionic.presenatation.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.d3st.socionic.ui.theme.SocionicTheme

class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                SocionicTheme {
                    AboutScreen { onBack() }
                }
            }
        }
    }

    private fun onBack() {
        val action = AboutFragmentDirections.actionAboutFragmentToStartFragment()
        findNavController().navigate(action)
    }
}