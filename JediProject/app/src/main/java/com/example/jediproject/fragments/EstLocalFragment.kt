import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jediproject.R
import com.example.jediproject.classes.Record
import com.example.jediproject.classes.RecordAdapter
import com.example.jediproject.classes.estadistiquesDb
import io.realm.Realm

class EstadistiquesFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var  adapter : RecordAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val realm: Realm = Realm.getDefaultInstance()

        adapter = RecordAdapter(context!!)
        val view =  inflater.inflate(R.layout.fragment_est_local, container, false)
        super.onCreate(savedInstanceState)
        recyclerView = view!!.findViewById(R.id.recyclerViewTest)
        recyclerView.layoutManager = LinearLayoutManager(context!!)
        recyclerView.addItemDecoration(DividerItemDecoration(context!!, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = adapter
        adapter.setData(estadistiquesDb.getAll())
        val text = view.findViewById<TextView>(R.id.text_estadistiques_buides)
        val image = view.findViewById<ImageView>(R.id.no_estadistiques)
        if(estadistiquesDb.getAll().isEmpty()) {
            text.visibility = View.VISIBLE
            image.visibility = View.VISIBLE
        }

        else {
            text.visibility = View.INVISIBLE
            image.visibility = View.INVISIBLE
        }
        realm.where(Record::class.java)
            .findAllAsync()
            .addChangeListener { record ->
                println(record)
            }
        return view
    }


}