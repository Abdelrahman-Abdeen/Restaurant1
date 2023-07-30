package com.example.shop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val thirdFragment = ThirdFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.FLfragment,thirdFragment)
            commit()
        }
    }

    val firstFragment = FirstFragment()
    val secondFragment = SecondFragment()
    val dialog_var = CustomDialogclass()
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var inflater = menuInflater
        inflater.inflate(R.menu.my_first_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item1 -> supportFragmentManager.beginTransaction().apply {
                replace(R.id.FLfragment,firstFragment)
                commit()
            }
            R.id.item2 -> supportFragmentManager.beginTransaction().apply {
                replace(R.id.FLfragment,secondFragment)
                commit()

            }
            R.id.item3 ->  supportFragmentManager.beginTransaction().apply {
                replace(R.id.FLfragment,thirdFragment)
                commit()
            }
            R.id.item4 -> dialog_var.show(supportFragmentManager,"Custom Dialog")
            R.id.item5 -> Toast.makeText(this,"There is no offers",Toast.LENGTH_SHORT).show()

            // R.id.subitem1 -> Toast.makeText(this, "Sub-item 1 selected", Toast.LENGTH_SHORT).show()
        }
        return true;
    }
    fun receiveFeedback(feedback: String){
        Toast.makeText(this,feedback,Toast.LENGTH_SHORT).show()
     }

}