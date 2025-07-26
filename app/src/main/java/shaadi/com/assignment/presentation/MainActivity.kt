package shaadi.com.assignment.presentation

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.ConnectivityManager.CONNECTIVITY_ACTION
import android.net.ConnectivityManager.NetworkCallback
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import shaadi.com.assignment.R
import shaadi.com.assignment.databinding.ActivityMainBinding
import shaadi.com.assignment.presentation.adapter.PersonListAdapter
import shaadi.com.assignment.presentation.viewmodel.PersonViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var networkReceiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate binding before setting the view
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Enable edge-to-edge AFTER setting content view
//        enableEdgeToEdge()

        // Set status bar color properly
        window.statusBarColor = ContextCompat.getColor(this, R.color.cyan500)

        // Optional: Ensure status bar icons are visible
        WindowCompat.getInsetsController(window, window.decorView)?.isAppearanceLightStatusBars = true

        // Recycler setup
        binding.allPeopleList.layoutManager = LinearLayoutManager(this)

        // Handle insets (this is good)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val viewmodel = ViewModelProvider(this)[PersonViewModel::class.java]
        val adapter = PersonListAdapter { status, id ->
            viewmodel.acceptOrReject(status, id ?: -1)
        }
        binding.allPeopleList.adapter = adapter

        viewmodel.personData.observe(this) {
            lifecycleScope.launch {
                adapter.submitData(it)
            }
        }

        networkReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                if (intent?.action == ConnectivityManager.CONNECTIVITY_ACTION) {
                    val connectivityManager = getSystemService(ConnectivityManager::class.java)
                    if (connectivityManager.isDefaultNetworkActive) {
                        adapter.refresh()
                    }
                }
            }
        }
        registerReceiver(networkReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(networkReceiver)
    }
}
