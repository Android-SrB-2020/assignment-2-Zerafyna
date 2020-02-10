package learn.nbcc.quizapp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_main.*
import learn.nbcc.quizapp.databinding.FragmentMainBinding
import learn.nbcc.therickandmortyquizapp.Question

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var navController: NavController

    private var questionIndex: Int = 0

    /**
     * List of Questions
     */
    private val questionBank = listOf(
        Question(R.string.question_1, false),
        Question(R.string.question_2, true),
        Question(R.string.question_3, true),
        Question(R.string.question_4, false),
        Question(R.string.question_5, false),
        Question(R.string.question_6, true),
        Question(R.string.question_7, false),
        Question(R.string.question_8, true),
        Question(R.string.question_9, false),
        Question(R.string.question_10, false),
        Question(R.string.question_11, false),
        Question(R.string.question_12, true),
        Question(R.string.question_13, false),
        Question(R.string.question_14, true),
        Question(R.string.question_15, false),
        Question(R.string.question_16, false),
        Question(R.string.question_17, true),
        Question(R.string.question_18, false),
        Question(R.string.question_19, false),
        Question(R.string.question_20, true)
    )



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
           inflater, R.layout.fragment_main, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()
        questionIndex = savedInstanceState?.getInt("qIndex", 0) ?: questionIndex

        binding.apply{

            questionView.setText(questionBank[questionIndex].textResId)

            trueBtn.setOnClickListener{
                //if the answer == true - Correct
                var answer = if (questionBank[questionIndex].answer) "Correct" else "Incorrect"
                Toast.makeText(context, answer, Toast.LENGTH_SHORT).show()
            }

            falseBtn.setOnClickListener{
                //if the answer == false - Correct
                var answer = if (!questionBank[questionIndex].answer) "Correct" else "Incorrect"
                Toast.makeText(context, answer, Toast.LENGTH_SHORT).show()
            }

            prevBtn.setOnClickListener {
                questionIndex = (questionIndex + 19) % 20
                questionView.setText(questionBank[questionIndex].textResId)
            }

            nextBtn.setOnClickListener {
                questionIndex = (questionIndex + 1) % 20
                questionView.setText(questionBank[questionIndex].textResId)
            }

            cheatBtn.setOnClickListener {
                val question = questionBank[questionIndex].textResId
                val ans = questionBank[questionIndex].answer
                navController.navigate(MainFragmentDirections.actionMainFragmentToCheatFragment(question, ans))
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("qIndex", questionIndex)

    }
}
