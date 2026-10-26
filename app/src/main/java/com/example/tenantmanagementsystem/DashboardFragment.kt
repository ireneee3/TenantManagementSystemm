
package com.example.tenantmanagementsystem

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tenantmanagementsystem.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    // Called when the Fragment object is created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TENANT_LIFECYCLE", "DashboardFragment: onCreate")
    }

    // Builds the Fragment's view from the XML layout
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("TENANT_LIFECYCLE", "DashboardFragment: onCreateView")

        _binding = FragmentDashboardBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    // Called when the view is ready to use
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TENANT_LIFECYCLE", "DashboardFragment: onViewCreated")

        // Display the number of tenants and total rent
        val tenantCount = TenantRepository.tenants.size
        val totalRent = TenantRepository.totalRent()

        binding.tenantCountTextView.text = "Tenants\n$tenantCount"
        binding.totalRentTextView.text =
            "Total rent\nKSh %,.0f".format(totalRent)

        // Navigate to Add Tenant
        binding.addTenantButton.setOnClickListener {
            val action = DashboardFragmentDirections
                .actionDashboardFragmentToAddTenantFragment()

            findNavController().navigate(action)
        }

        // Navigate to View Tenants
        binding.viewTenantsButton.setOnClickListener {
            val action = DashboardFragmentDirections
                .actionDashboardFragmentToViewTenantsFragment()

            findNavController().navigate(action)
        }
    }

    // Fragment becomes visible
    override fun onStart() {
        super.onStart()
        Log.d("TENANT_LIFECYCLE", "DashboardFragment: onStart")
    }

    // Fragment is in the foreground and interactive
    override fun onResume() {
        super.onResume()
        Log.d("TENANT_LIFECYCLE", "DashboardFragment: onResume")
    }

    // Fragment is losing the foreground
    override fun onPause() {
        super.onPause()
        Log.d("TENANT_LIFECYCLE", "DashboardFragment: onPause")
    }

    // Fragment is no longer visible
    override fun onStop() {
        super.onStop()
        Log.d("TENANT_LIFECYCLE", "DashboardFragment: onStop")
    }

    // The view is destroyed; clear its binding
    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("TENANT_LIFECYCLE", "DashboardFragment: onDestroyView")
        _binding = null
    }

    // Fragment object is destroyed
    override fun onDestroy() {
        super.onDestroy()
        Log.d("TENANT_LIFECYCLE", "DashboardFragment: onDestroy")
    }
}
