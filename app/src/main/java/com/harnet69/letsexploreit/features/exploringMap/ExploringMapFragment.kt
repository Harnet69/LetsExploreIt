package com.harnet69.letsexploreit.features.exploringMap

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.snackbar.Snackbar
import com.harnet69.letsexploreit.R
import com.harnet69.letsexploreit.databinding.ExploringMapBinding

class ExploringMapFragment : Fragment() {

    private lateinit var homeViewModel: ExploringMapViewModel
    private var _binding: ExploringMapBinding? = null

    @SuppressLint("MissingPermission")
    private val callback = OnMapReadyCallback { googleMap ->
        val sydney = LatLng(-34.0, 151.0)
        if (context?.let { ContextCompat.checkSelfPermission(it, Manifest.permission.ACCESS_FINE_LOCATION) } == PackageManager.PERMISSION_GRANTED) {
            googleMap.setMyLocationEnabled(true)
        } else {
            // Show rationale and request permission.
        }
        googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        homeViewModel = ViewModelProvider(this).get(ExploringMapViewModel::class.java)

        _binding = ExploringMapBinding.inflate(inflater, container, false)

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.fabAddPOI.setOnClickListener { fab ->
            Snackbar.make(view, "Add a new POI", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}