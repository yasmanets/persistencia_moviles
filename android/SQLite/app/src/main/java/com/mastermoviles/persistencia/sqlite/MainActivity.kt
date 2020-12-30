package com.mastermoviles.persistencia.sqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.mastermoviles.persistencia.sqlite.Data.Database
import com.mastermoviles.persistencia.sqlite.UserManagement.ManagementActivity

class MainActivity : AppCompatActivity() {

    var userName: EditText? = null
    var password: EditText? = null
    var login: Button? = null
    var close: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.setUIContent()
    }

    private fun setUIContent() {
        userName = findViewById(R.id.userName)
        password = findViewById(R.id.password)
        login = findViewById(R.id.login)
        close = findViewById(R.id.close)

        login?.setOnClickListener{

        }

        close?.setOnClickListener{
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.backup -> Toast.makeText(this, "Backup", Toast.LENGTH_SHORT).show()
            R.id.restore -> Toast.makeText(this, "Restore", Toast.LENGTH_SHORT).show()
            R.id.users -> {
                val intent = Intent(this, ManagementActivity::class.java)
                startActivity(intent)
            }
            else -> Toast.makeText(this, "No existe la opción seleccionada", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}