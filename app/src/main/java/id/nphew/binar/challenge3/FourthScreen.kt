package id.nphew.binar.challenge3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import androidx.navigation.findNavController
import id.nphew.binar.challenge3.databinding.FragmentFourthScreenBinding
import id.nphew.binar.challenge3.model.Person

class FourthScreen : Fragment() {
    private var _binding: FragmentFourthScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFourthScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBacktoS3.setOnClickListener {
            sendDataToS3(it)
        }
    }

    private fun sendDataToS3(it: View){
        val usia = binding.screen4Usia.text.toString().toInt()
        val alamat = binding.screen4Alamat.text.toString()
        val pekerjaan = binding.screen4Pekerjaan.text.toString()

        val person = Person(usia, alamat, pekerjaan)
        val mBundle = Bundle()
        mBundle.putParcelable("parcelPerson",  person)

        setFragmentResult("fromS4", mBundle)
        it.findNavController().popBackStack()
    }
}