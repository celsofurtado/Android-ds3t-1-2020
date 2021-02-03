package com.example.app.fragments

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.adapter.ConsoleRecyclerAdapter
import com.example.app.data.ConsoleRepository
import com.example.app.model.Console

class ConsolesFragment : Fragment(), View.OnClickListener {

    private lateinit var buttonConsoleAdd: ImageButton
    private lateinit var buttonSave: ImageButton
    private lateinit var buttonCancel: ImageButton

    private lateinit var consolesRecyclerView: RecyclerView
    private val consoleAdapter = ConsoleRecyclerAdapter()

    private lateinit var editTextConsoleName: EditText
    private lateinit var editTextConsoleMaker: EditText
    private lateinit var editTextConsoleReleaseDate: EditText

    private lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true) // Isso que vai permitir colocar o menu na toolbar do fragment
        // Inflate the layout for this fragment

        Log.i("sql", "CreateViewConsole")

        val view = inflater.inflate(R.layout.fragment_consoles, container, false)

        // *** Preencher o RecyclerView
        consolesRecyclerView = view.findViewById(R.id.recycler_view_consoles)
        consolesRecyclerView.layoutManager = LinearLayoutManager(view.context)
        consolesRecyclerView.adapter = consoleAdapter

        atualizarRecyclerView(view.context)

        buttonConsoleAdd = view.findViewById(R.id.button_console_add)
        buttonConsoleAdd.setOnClickListener(this)

        return view
    }

    private fun atualizarRecyclerView(context: Context) {
        val mConsoleRepository = ConsoleRepository(context)
        val consoleList = mConsoleRepository.getConsoles(context)
        consoleAdapter.updateConsoleList(consoleList)
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
                saveConsole(v.context)
            }
            R.id.button_cancel -> {
                dialog.dismiss()
            }

        }

    }

    private fun saveConsole(context: Context) {

        if (editTextConsoleName.text.isEmpty()) {
            editTextConsoleName.setError("Obrigatório!")
        } else if(editTextConsoleMaker.text.isEmpty()) {
            editTextConsoleMaker.setError("Obrigatório!")
        } else if(editTextConsoleReleaseDate.text.isEmpty()) {
            editTextConsoleReleaseDate.setError("Obrigatório!")
        }else {
            val mConsoleRepository = ConsoleRepository(context)
            val console = Console().apply {
                id = 0
                consoleName = editTextConsoleName.text.toString()
                maker = editTextConsoleMaker.text.toString()
                releaseDate = editTextConsoleReleaseDate.text.toString()
            }

            mConsoleRepository.saveConsole(console)

            atualizarRecyclerView(context)

            dialog.dismiss()
        }

    }

    private fun abrirDialogConsoleAdd() {
        val alertDialog = AlertDialog.Builder(view!!.context)
        val inflater = layoutInflater
        val view = inflater.inflate(R.layout.console_dialog_layout, null)

        editTextConsoleMaker = view.findViewById(R.id.edit_text_console_maker_name)
        editTextConsoleName = view.findViewById(R.id.edit_text_console_name)
        editTextConsoleReleaseDate = view.findViewById(R.id.edit_text_console_release_date)

        buttonSave = view.findViewById(R.id.button_save)
        buttonSave.setOnClickListener(this)

        buttonCancel = view.findViewById(R.id.button_cancel)
        buttonCancel.setOnClickListener(this)

        alertDialog.setView(view)

        dialog = alertDialog.create()
        dialog.setCancelable(false)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }

}