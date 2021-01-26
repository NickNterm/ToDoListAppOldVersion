import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.*
import kotlinx.android.synthetic.main.monday.view.*


class Monday : Fragment() ,ItemAdapter.OnItemClickListener {
    var mainlist = emptyList<ListItem>()
    var MainMode = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var db = activity?.let { DatabaseAccess(it) }
        var list = db?.ReadData("Monday")
        if (list != null) {
            mainlist = list
        }
        mainlist = mainlist.sortedBy { it.DateStart }
        val view = inflater.inflate(R.layout.monday, container, false)
        view.MondayItems.layoutManager = LinearLayoutManager(activity)
        view.MondayItems.adapter = mainlist?.let { ItemAdapter(it, this) }
        if (list != null) {
            if(list.isNotEmpty()){
                view.CalendarImage.visibility = INVISIBLE
                view.NoEventText.visibility = INVISIBLE
            }
        }
        return view
    }

    override fun onItemClick(position: Int) {
        var ToDoActivity = Intent(context, AddTask::class.java)
        ToDoActivity.putExtra("TABLE_NAME", "Monday")
        ToDoActivity.putExtra("COLOR", mainlist[position].Color)
        ToDoActivity.putExtra("TITLE_GET", mainlist[position].Task)
        ToDoActivity.putExtra("NOTE_GET", mainlist[position].Note)
        ToDoActivity.putExtra("START_TIME", mainlist[position].DateStart)
        ToDoActivity.putExtra("END_TIME", mainlist[position].DateEnd)
        ToDoActivity.putExtra("ID", mainlist[position].id)
        ToDoActivity.putExtra("SET_BUTTON_STATE", mainlist[position].id)
        startActivity(ToDoActivity)
    }
}

