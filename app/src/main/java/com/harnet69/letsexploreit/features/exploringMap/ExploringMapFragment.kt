package com.harnet69.letsexploreit.features.exploringMap

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context.LOCATION_SERVICE
import android.content.pm.PackageManager
import android.location.Criteria
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.coroutineScope
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.material.snackbar.Snackbar
import com.google.maps.android.ktx.awaitMap
import com.harnet69.letsexploreit.R
import com.harnet69.letsexploreit.databinding.FragmentExploringMapBinding
import javax.inject.Inject


class ExploringMapFragment @Inject constructor() : Fragment(R.layout.fragment_exploring_map) {

    private lateinit var homeViewModel: ExploringMapViewModel
    private var _binding: FragmentExploringMapBinding? = null
    private val binding get() = _binding!!

    var myPosition: LatLng? = null

    @SuppressLint("MissingPermission")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(this).get(ExploringMapViewModel::class.java)

        _binding = FragmentExploringMapBinding.inflate(inflater, container, false)

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?

        lifecycle.coroutineScope.launchWhenCreated {
            val googleMap = mapFragment?.awaitMap()
            if (checkPermission()) {
                googleMap?.isMyLocationEnabled = true

                val locationManager = activity?.getSystemService(LOCATION_SERVICE) as LocationManager?
                val criteria = Criteria()
                val provider = locationManager?.getBestProvider(criteria, true)
                val location: Location? = provider?.let { locationManager.getLastKnownLocation(it) }

                if (location != null) {
                    val latitude: Double = location.latitude
                    val longitude: Double = location.longitude
                    myPosition = LatLng(latitude, longitude)
                    val coordinate = LatLng(latitude, longitude)
                    val yourLocation = CameraUpdateFactory.newLatLngZoom(coordinate, 15f)
                    googleMap?.animateCamera(yourLocation)
                }
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.fabAddPOI.setOnClickListener { fab ->
            Snackbar.make(view, "Add a new POI", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    // Check for permission to access Location
    private fun checkPermission(): Boolean {
        // Ask for permission if it wasn't granted yet
        return (activity?.let {
            ContextCompat.checkSelfPermission(
                it,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        }
                == PackageManager.PERMISSION_GRANTED)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}