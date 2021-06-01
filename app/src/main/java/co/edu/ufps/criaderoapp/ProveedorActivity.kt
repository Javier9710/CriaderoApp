package co.edu.ufps.criaderoapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class ProveedorActivity : AppCompatActivity() {

    lateinit var tabLayout1 : TabLayout;
    lateinit var viewPager1 : ViewPager;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proveedor)
        tabLayout1 = findViewById(R.id.otra);
        viewPager1 = findViewById(R.id.otracosa);
        tabLayout1.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = MyAdapterProveedor(this, supportFragmentManager, tabLayout1.tabCount)
        viewPager1.adapter = adapter
        viewPager1.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout1))
        tabLayout1.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager1.currentItem = tab.position;
            }

            override fun onTabReselected(tab: TabLayout.Tab) {}

            override fun onTabUnselected(tab: TabLayout.Tab) {}


        })

    }

    fun regProveedor(view: View) {
        val intent = Intent(this, regProveedorActivity::class.java);
        startActivity(intent);
    }

}