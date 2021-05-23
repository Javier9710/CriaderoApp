package co.edu.ufps.criaderoapp

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

@Suppress("DEPRECATION")
class MyAdapter(

    var context:Context,
    fm: FragmentManager,
    var totalTabs : Int
): FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return totalTabs
    }


    override fun getItem(position: Int): Fragment {


        return when (position){
            0 -> {
                regEstanqueFragment()
            }
            1 -> {
                EstaditicaFragment()
            }
            2 ->{
                ActividadFragment()
            }

            else -> getItem(position);
        }
    }


}