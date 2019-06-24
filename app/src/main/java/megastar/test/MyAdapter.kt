package megastar.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_item.view.*

class MyAdapter(val onClick: (ImageView)-> (Unit) ) : RecyclerView.Adapter<MyAdapter.MyHolder>() {

    val mutableList = mutableListOf<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_item, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return mutableList.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.imageView.transitionName = position.toString()
        holder.imageView.setOnClickListener { onClick(holder.imageView) }

    }

    inner class MyHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView = view.imageView as ImageView
    }
}