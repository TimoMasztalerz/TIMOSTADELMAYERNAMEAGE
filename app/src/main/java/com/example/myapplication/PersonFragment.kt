import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.myapplication.databinding.FragmentPersonBinding

class PersonFragment : Fragment() {
    private lateinit var binding: FragmentPersonBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPersonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel.Daten.observe(viewLifecycleOwner) {
            binding.personNameTextView.text = it
        }
        sharedViewModel.Daten.observe(viewLifecycleOwner) {binding.personAgeTextView.text=it}
    }
}