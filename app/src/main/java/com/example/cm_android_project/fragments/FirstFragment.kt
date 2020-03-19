package com.example.cm_android_project.fragments

//import com.example.cm_android_project.FirstFragmentDirections
import android.os.Bundle
import android.view.*
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ListView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.cm_android_project.R
import com.example.cm_android_project.adapters.CustomList_Adapter
import com.example.cm_android_project.databinding.FragmentFirstBinding
import com.example.cm_android_project.entities.Nota

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    val arrayNota: ArrayList<Nota> = ArrayList();

    lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_first,
            container,
            false
        )

        binding.fabId.setOnClickListener {
            findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment())

        }

        fillLista()
        return binding.root
    }

    private fun fillLista() {
        val arrayItems: ArrayList<Nota> = ArrayList<Nota>()
        arrayItems.add(Nota("Nota1", "descricao2", "data"))
        arrayItems.add(Nota("Nota1", "descricao2", "data"))
        arrayItems.add(Nota("Nota1", "descricao2", "data"))
        val itemsAdapter = CustomList_Adapter(this.context, arrayItems)
        //layoutInflater.inflate(R.id.id_lista, ViewGroup, false)
        this.binding.idLista.adapter = itemsAdapter
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        //MenuInflater(this,R.menu.menu_context, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterContextMenuInfo
        val index = info.position
        val nota: Nota = arrayNota.get(index)
        when (item.itemId) {
            R.id.adicionar -> {
                Toast.makeText(this.context, "adicionado", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }
}
