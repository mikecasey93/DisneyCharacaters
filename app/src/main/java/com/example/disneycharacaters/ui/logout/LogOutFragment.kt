package com.example.disneycharacaters.ui.logout

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.disneycharacaters.LoginActivity
import com.example.disneycharacaters.R
import com.google.firebase.auth.FirebaseAuth

class LogOutFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseAuth.getInstance().signOut()
        startActivity(Intent(activity, LoginActivity::class.java)).also { activity?.finish()
        }
    }


}