import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.myapplication.R

class HomeFragment : Fragment() {
    private lateinit var ageInput: EditText
    private lateinit var nameInput: EditText
    private lateinit var buttonSpeichern: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        ageInput = view.findViewById(R.id.ageInput)
        nameInput = view.findViewById(R.id.nameInput)
        buttonSpeichern = view.findViewById(R.id.button2)

        buttonSpeichern.setOnClickListener {
            val age = ageInput.text.toString().toInt()
            val name = nameInput.text.toString()

            val bundle = Bundle()
            bundle.putInt("age", age)
            bundle.putString("name", name)

            val personFragment = PersonFragment()
            personFragment.arguments = bundle

            parentFragmentManager.beginTransaction()
                .replace(R.id.homeFragment, personFragment)
                .addToBackStack(bundle.toString())
                .commit()
        }

        return view
    }
}
