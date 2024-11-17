package ru.d3st.socionic.presenatation.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.d3st.socionic.models.presentation.TestType
import ru.d3st.socionic.presenatation.compose.StartScreen
import ru.d3st.socionic.ui.theme.SocionicTheme

/**
 * Screen choosing test
 */
class StartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {
            // Dispose of the Composition when the view's LifecycleOwner
            // is destroyed
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                SocionicTheme {
                    // In Compose world
                    StartScreen(
                        { navigateToFastTest() },
                        { navigateToFullTest() },
                        { id -> navigateToOverview(id) },
                        { navigateToFAQ() }
                    )
                }
            }
        }
    }

    private fun navigateToFAQ() {
        val action = StartFragmentDirections.actionStartFragmentToAboutFragment()
        findNavController().navigate(action)

    }

    private fun navigateToOverview(category: Int) {
        val action = StartFragmentDirections.actionStartFragmentToFragmentOverview(category)
        findNavController().navigate(action)
    }

    private fun navigateToFastTest() {
        val action =
            StartFragmentDirections.actionStartFragmentToQuestionsFragment(TestType.SHORT.value)
        findNavController().navigate(action)
    }

    private fun navigateToFullTest() {
        val action =
            StartFragmentDirections.actionStartFragmentToQuestionsFragment(TestType.FULL.value)
        findNavController().navigate(action)
    }

}