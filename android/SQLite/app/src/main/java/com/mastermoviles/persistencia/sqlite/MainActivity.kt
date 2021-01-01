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
import com.mastermoviles.persistencia.sqlite.Models.Users
import com.mastermoviles.persistencia.sqlite.UserManagement.ManagementActivity
import com.mastermoviles.persistencia.sqlite.UserManagement.UserActivity

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
            this.login()
        }

        close?.setOnClickListener{
            finish()
        }
    }

    private fun login(): Boolean {
        val name = userName?.text.toString()
        val pass = password?.text.toString()
        if (name.isEmpty() || pass.isEmpty()) {
            Toast.makeText(this, "Debes introducir el nombre de usuario y la contraseña", Toast.LENGTH_SHORT).show()
            return false
        }
        val database = Database(this)
        val user: Users? = database.login(name)
        return when {
            user == null -> {
                Toast.makeText(this, "No existe ningún usuario con ese nombre", Toast.LENGTH_SHORT).show()
                false
            }
            user.password != pass -> {
                Toast.makeText(this, "La contraseña no es correcta", Toast.LENGTH_SHORT).show()
                false
            }
            else -> {
                val intent = Intent(this, UserActivity::class.java)
                intent.putExtra("fullName", user.nombre_completo)
                intent.putExtra("userName", user.nombre_usuario)
                startActivity(intent)
                true
            }
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