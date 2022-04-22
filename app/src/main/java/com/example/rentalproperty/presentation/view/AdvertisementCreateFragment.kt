package com.example.rentalproperty.presentation.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.rentalproperty.R
import com.example.rentalproperty.app.appComponent
import com.example.rentalproperty.databinding.AdvertisementCreateFragmentBinding
import com.example.rentalproperty.domain.model.Advertisement
import com.example.rentalproperty.presentation.viewmodel.AdvertisementCreateViewModel
import com.example.rentalproperty.presentation.viewmodel.factory.AdvertisementCreateViewModelFactory
import java.io.InputStream


class AdvertisementCreateFragment : Fragment(R.layout.advertisement_create_fragment) {

    private var binding: AdvertisementCreateFragmentBinding? = null
    private val viewModel: AdvertisementCreateViewModel by viewModels {
        AdvertisementCreateViewModelFactory(
            requireActivity().appComponent.advertisementInteractor
        )
    }

    private val imageStreams = mutableListOf<InputStream>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = AdvertisementCreateFragmentBinding.inflate(inflater).also {
        binding = it
        setButtonsListeners()

        startActivityForResult(
            Intent.createChooser(
                Intent()
                    .setType("image/*")
                    .putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
                    .setAction(Intent.ACTION_GET_CONTENT),
                SELECT_IMAGES
            ), PICK_MULTIPLY_IMAGES
        )

    }.root

    private fun setButtonsListeners() {
        binding?.publish?.setOnClickListener {
            viewModel.publishAdvertisement(
                Advertisement(
                    region = binding?.region?.text.toString(),
                    imagesStream = imageStreams
                )
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == PICK_MULTIPLY_IMAGES) {
            if (data != null) {
                when {
                    data.data == null -> {
                        data.clipData?.itemCount?.let { selectedImagesCount ->
                            for (it in 0 until selectedImagesCount) {
                                data.clipData?.getItemAt(it)?.uri?.let { uri ->
                                    requireContext().contentResolver.openInputStream(uri)?.let {
                                        imageStreams.add(it)
                                    }
                                }
                            }
                        }
                    }
                    data.clipData == null -> {
                        data.data?.let { uri ->
                            requireContext().contentResolver.openInputStream(uri)?.let {
                                imageStreams.add(it)
                            }
                        }
                    }
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    private companion object {

        private const val SELECT_IMAGES = "Select images"
        private const val PICK_MULTIPLY_IMAGES = 0
    }
}