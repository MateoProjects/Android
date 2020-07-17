package com.example.jediproject.fragments

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Criteria
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.example.jediproject.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.Circle
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_maps.*


class MapsFragment : Fragment(), OnMapReadyCallback {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_maps, container, false)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        return view
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        var map = googleMap
        val locationManager = context!!.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val criteria = Criteria()
        val provider = locationManager.getBestProvider(criteria, true)
        if (ActivityCompat.checkSelfPermission(
                activity!!,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                activity!!,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION), 123)
            return
        }
        val pos = getLocation()
        val latlng = LatLng(pos!!.latitude, pos.longitude)
        map?.addMarker(MarkerOptions().position(latlng))
            setListeners(map , latlng)
    }





    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 123 && grantResults.isNotEmpty()) {
            getLocation()
        }
    }

    @SuppressLint("MissingPermission")
    private fun getLocation(): Location? {
        val locationManager = context!!.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val criteria = Criteria()
        val provider = locationManager.getBestProvider(criteria, true)
        val myLocation: Location? = locationManager.getLastKnownLocation(provider!!)
        return myLocation
    }

    fun setListeners(map: GoogleMap? , latlng:LatLng) {
        val circleOptions = CircleOptions()
        circleOptions.center(latlng)
        circleOptions.fillColor(Color.RED)
        circleOptions.strokeColor(Color.RED)
        circleOptions.strokeWidth(4f)
        circleOptions.radius(0.0)
        var mapCircle : Circle = map!!.addCircle(circleOptions)
        button1km.setOnClickListener {
            mapCircle.remove()
            circleOptions.radius(1000.0)
            mapCircle = map.addCircle(circleOptions)
        }

        button10km.setOnClickListener {
            mapCircle.remove()
            circleOptions.radius(10000.0)
            mapCircle = map.addCircle(circleOptions)
        }

        button100km.setOnClickListener {
            mapCircle.remove()
            circleOptions.radius(100000.0)
            mapCircle = map.addCircle(circleOptions)
        }

        buttoncircleDelete.setOnClickListener {
            mapCircle.remove()
            circleOptions.radius(0.0)
            mapCircle = map.addCircle(circleOptions)

        }
    }



}



