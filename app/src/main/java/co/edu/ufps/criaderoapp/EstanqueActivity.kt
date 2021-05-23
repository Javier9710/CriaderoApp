package co.edu.ufps.criaderoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


class EstanqueActivity : AppCompatActivity() {

    lateinit var tabLayout : TabLayout;
    lateinit var viewPager : ViewPager;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estanque)
        tabLayout=findViewById(R.id.principal);
        viewPager=findViewById(R.id.viewpager);
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = MyAdapter(this, supportFragmentManager, tabLayout.tabCount)
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener( object : TabLayout.OnTabSelectedListener{

            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem= tab.position;
            }
            override fun onTabReselected(tab: TabLayout.Tab) {}

            override fun onTabUnselected(tab: TabLayout.Tab) {}


        })
    }
}