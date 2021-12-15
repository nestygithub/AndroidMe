package com.chiki.androidme.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chiki.androidme.R

class AndroidMeActivity : AppCompatActivity() {

    //Lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val twoPane = findViewById<ConstraintLayout>(R.id.two_pane_constraint_layout)!=null     //If it can be found it means there are two panes

        if(twoPane){
            val button = findViewById<Button>(R.id.show_button)
            button.visibility = View.GONE                                                       //Hide the button

            val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)                   //Only two columns
            (recyclerView.layoutManager as GridLayoutManager).spanCount = 2
        }
    }
}