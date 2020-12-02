package com.example.petfinder


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*


class MyListAdapter(val context: Context?, val objects: ArrayList<MyListItem>?) : BaseAdapter() {
    var lInflater: LayoutInflater? = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater?

    override fun getCount(): Int {
        return objects!!.size
    }

    override fun getItem(position: Int): Any {
        return objects!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var view: View? = convertView
        if (view == null) {
            view = lInflater?.inflate(R.layout.activity_my_list_item, parent, false)
        }
        val p: MyListItem = getList(position)

        (view?.findViewById(R.id.tvName) as TextView).text = p.name
        (view?.findViewById(R.id.tvAddress) as TextView).text = p.address
        (view.findViewById(R.id.ivPetImage) as ImageView).setImageResource(p.image)

        return view
    }

    private fun getList(position: Int): MyListItem {
        return getItem(position) as MyListItem
    }
}