package ru.d3st.socionic.presenatation.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.assisted.AssistedFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import ru.d3st.socionic.models.presentation.TestType
import ru.d3st.socionic.presenatation.questions.action.QuestionEffect
import ru.d3st.socionic.presenatation.questions.compose.QuestionRoute
import javax.inject.Inject

@AndroidEntryPoint
@Deprecated("need use QuestionScreen")
class QuestionsFragment : Fragment() {

    private val args: QuestionsFragmentArgs by navArgs<QuestionsFragmentArgs>()

    @Inject
    lateinit var viewAssistedFactory: QuestionsViewAssistedFactory

    private val viewModel: QuestionsViewModel by viewModels<QuestionsViewModel> {
        viewAssistedFactory.create(TestType.findType(args.testType))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                QuestionRoute(viewModel)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.effects.collect {
                    when (it) {
                        QuestionEffect.CloseTest -> navigateToStartScreen()
                        is QuestionEffect.ToResult -> navigateToResult(it.resultId)
                    }
                }
            }
        }
    }

    private fun navigateToStartScreen() {
        val action = QuestionsFragmentDirections.actionQuestionsFragmentToStartFragment()
        findNavController().navigate(action)
    }

    private fun navigateToResult(resultId: Int) {
        val action =
            QuestionsFragmentDirections.actionQuestionsFragmentToFragmentDetail(resultId)
        findNavController().navigate(action)
    }
}


@AssistedFactory
interface QuestionsViewAssistedFactory {
    fun create(type: TestType): QuestionsViewModelFactory
}