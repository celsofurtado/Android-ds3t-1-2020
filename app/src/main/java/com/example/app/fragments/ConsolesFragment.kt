package com.example.app.fragments

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.app.R
import com.example.app.adapter.ConsoleRecyclerAdapter
import com.example.app.data.AppDataBase
import com.example.app.data.ConsoleDataSource
import com.example.app.model.Console

class ConsolesFragment : Fragment(), View.OnClickListener {

    private lateinit var buttonConsoleAdd: ImageButton
    private lateinit var buttonSave: Button

    private lateinit var consolesRecyclerView: RecyclerView
    private val consoleAdapter = ConsoleRecyclerAdapter()
    private var consoleList = listOf<Console>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true) // Isso que vai permitir colocar o menu na toolbar do fragment
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_consoles, container, false)

        // *** Preencher o RecyclerView
        consolesRecyclerView = view.findViewById(R.id.recycler_view_consoles)
        consolesRecyclerView.layoutManager = LinearLayoutManager(view.context)
        consolesRecyclerView.adapter = consoleAdapter
        consoleList = ConsoleDataSource.getConsoles(view.context)
        consoleAdapter.updateConsoleList(consoleList)


            buttonConsoleAdd = view.findViewById(R.id.button_console_add)
        buttonConsoleAdd.setOnClickListener(this)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_bottom_navigation_view, menu)
    }

    override fun onClick(v: View) {
        val id = v.id

        when (id) {
            R.id.button_console_add -> {
                abrirDialogConsoleAdd()
            }
            R.id.button_save -> {
                Toast.makeText(context, "Salvar console", Toast.LENGTH_SHORT).show()
                saveConsole()
            }

        }

    }

    private fun saveConsole() {
        //val db = Room.databaseBuilder(context!!, AppDataBase::class.java, "games").build()
    }

    private fun abrirDialogConsoleAdd() {
        val alertDialog = AlertDialog.Builder(view!!.context)
        val inflater = layoutInflater
        val view = inflater.inflate(R.layout.console_dialog_layout, null)

        buttonSave = view.findViewById(R.id.button_save)
        buttonSave.setOnClickListener(this)

        alertDialog.setView(view)

        val dialog = alertDialog.create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }

}