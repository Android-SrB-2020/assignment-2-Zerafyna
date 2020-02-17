package learn.nbcc.quizapp

/**
 * @author: Erica Moisei
 * @date: 09/02/2020
 */
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import learn.nbcc.quizapp.databinding.FragmentCheatBinding
import learn.nbcc.therickandmortyquizapp.Question

/**
 * A simple [Fragment] subclass.
 */
class CheatFragment : Fragment() {

    private lateinit var binding: FragmentCheatBinding

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
        binding = DataBindingUtil.inflate( inflater, R.layout.fragment_cheat, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var args = CheatFragmentArgs.fromBundle(arguments!!)

        binding.apply{

            questionLabel.setText(questionBank[args.question].textResId)

            val answ: String = if (args.answer == true) "TRUE" else "FALSE"
            answerLabel.text = answ
            answerLabel.visibility = View.INVISIBLE

            cheatBtn.setOnClickListener{
                answerLabel.visibility = View.VISIBLE
            }

            cancelBtn.setOnClickListener{
                activity!!.onBackPressed()
            }
        }
    }

}
