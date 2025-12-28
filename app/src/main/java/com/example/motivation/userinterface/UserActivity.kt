package com.example.motivation.userinterface

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecurityPreferences
import com.example.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        //EVENTO DE CLIQUE
        binding.buttonNew10.setOnClickListener { handleSave() }

        //VERIFICAR SE O USUARIO JA TEM O NOME E MANTER O NOME NO APP
        verifyUserName()

    }


    //FUNÇÃO DO EVENTO DE CLIQUE
    private fun handleSave() {
        //TRANSFORMANDO O TEXTO DO USUARIO EM STRING
        val nome = binding.editNome.text.toString()
        //VALIDAÇÃO PARA NÃO RECEBER STRING FAZIA
        if (nome != "") {

            //Salvar o nome de usuario para usaar em outra activity
            val security =
                SecurityPreferences(this).storeString(MotivationConstants.KEY.USER_NAME, nome)

            startActivity(Intent(this, MainActivity::class.java))

            //PARA NÃO VOLTAR PARA ACTIVITY
            finish()

            //MENSAGEM SE RECEBER STRING FAZIA
        } else {
            Toast.makeText(this, "Por favor informe seu nome!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun verifyUserName() {
        val nomeUser = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        if (nomeUser != "") {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }

}