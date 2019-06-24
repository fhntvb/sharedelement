package megastar.test

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment: Fragment() {
    private val adapter = MyAdapter(this::onItemClick).apply {
    mutableList.add("Объект 1")
    mutableList.add("Объект 2")
    mutableList.add("Объект 3")
    mutableList.add("Объект 4")
    mutableList.add("Объект 5")
    mutableList.add("Объект 6")
    mutableList.add("Объект 7")
}
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_first,container,false)
    }

    private fun onItemClick(imageView: ImageView) {
        val intent = Intent(activity, SecondActivity::class.java)
        intent.putExtra("transitionName",imageView.transitionName)
        val options = ActivityOptions
            .makeSceneTransitionAnimation(activity, imageView, imageView.transitionName)
        startActivity(intent, options.toBundle())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.adapter = adapter
    }
}