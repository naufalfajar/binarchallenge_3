package id.nphew.binar.challenge3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.findNavController
import id.nphew.binar.challenge3.databinding.FragmentThirdScreenBinding
import id.nphew.binar.challenge3.model.Person

class ThirdScreen : Fragment() {
    private var _binding: FragmentThirdScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?)
    : View? {
        _binding = FragmentThirdScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun getOddorEven(n: Int): String {
        if (n%2 == 1)
            return "Ganjil"
        else
            return "Genap"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener("fromS4"){ _, bundle ->
            val parcelPerson = bundle.getParcelable<Person>("parcelPerson")
            val usia = parcelPerson?.age
            val alamat = parcelPerson?.address
            val pekerjaan = parcelPerson?.job

            val value = getOddorEven(usia!!)

            val dUsia = usia.toString() + ", bernilai " + value

            binding.apply {
                screen3Age.text = dUsia
                screen3Address.text = alamat
                screen3Job.text = pekerjaan

                screen3Age.visibility = View.VISIBLE
                screen3Address.visibility = View.VISIBLE
                screen3Job.visibility = View.VISIBLE
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataFromThirdScreen = ThirdScreenArgs.fromBundle(arguments as Bundle).name
        binding.screen3DisplayName.text = dataFromThirdScreen

        binding.btnGotoS4.setOnClickListener {
            it.findNavController().navigate(R.id.action_thirdScreen_to_fourthScreen)
        }
    }

}