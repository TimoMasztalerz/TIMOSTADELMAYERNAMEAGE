import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication.R

class PersonFragment : Fragment() {
    private lateinit var arguments: Bundle
    private lateinit var ageTextView: TextView
    private lateinit var nameTextView: TextView

    companion object {
        private const val ARG_AGE = "arg_age"
        private const val ARG_NAME = "arg_name"

        fun newInstance(age: Int, name: String): PersonFragment {
            val fragment = PersonFragment()
            val args = Bundle()
            args.putInt(ARG_AGE, age)
            args.putString(ARG_NAME, name)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_person, container, false)

        ageTextView = view.findViewById(R.id.AgeTextView)
        nameTextView = view.findViewById(R.id.NameTextView)

        arguments.let {
            val age = it.getInt(ARG_AGE)
            val name = it.getString(ARG_NAME)
            ageTextView.text = age.toString()
            nameTextView.text = name
        }

        return view
    }
}
