package com.example.motivation.userinterface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.motivation.data.Mock
import com.example.motivation.data.Phrase
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecurityPreferences
import com.example.motivation.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var categoryId = MotivationConstants.FILTER.INFINITY

    //Criando a variavel binding
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Instancia do View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)

        //Para utilizar na view
        setContentView(binding.root)

        //PARA RETIRAR A BARRA DE NOME DO APLICATIVO
        supportActionBar?.hide()

        //AO ABIR O APP O SOFTWARE JOGA A FUNÇÃO AO IMAGE INFINITY
        handleFilter(com.example.motivation.R.id.image_infinity)

        //PARA ADICIONAR O NOME DO USUARIO NA ACTIVITY
        handleUserName()

        //AO ABRIR O APP BUSCAR AS FRASES
        handleNextPhrase()

        //EVENTOS DE CLICK
        binding.buttonNew1.setOnClickListener(this)
        binding.imageChild.setOnClickListener(this)
        binding.imageInfinity.setOnClickListener(this)
        binding.imageSun.setOnClickListener(this)

    }


    //IMPLEMENTO DA CLASSE VIEW
    override fun onClick(view: View) {
        when (view.id) {
            com.example.motivation.R.id.button_new1 -> {
                handleNextPhrase()
            }

            in listOf(
                com.example.motivation.R.id.image_child, com.example.motivation.R.id.image_infinity,
                com.example.motivation.R.id.image_sun
            ) -> {
                handleFilter(view.id)
            }
        }
    }

    private fun handleNextPhrase() {
        Locale.getDefault().language
        binding.textTextmmm.text = Mock().getPhrase(categoryId)
    }

    //PARA OS IMAGE VIEW MUDAR A COR SE E CLICADO
    private fun handleFilter(id: Int) {

        binding.imageInfinity.setColorFilter(
            ContextCompat.getColor(
                this,
                com.example.motivation.R.color.black
            )
        )
        binding.imageSun.setColorFilter(
            ContextCompat.getColor(
                this,
                com.example.motivation.R.color.black
            )
        )
        binding.imageChild.setColorFilter(
            ContextCompat.getColor(
                this,
                com.example.motivation.R.color.black
            )
        )


        when (id) {
            com.example.motivation.R.id.image_infinity -> {
                binding.imageInfinity.setColorFilter(
                    ContextCompat.getColor(
                        this,
                        com.example.motivation.R.color.white
                    )
                )

            }

            com.example.motivation.R.id.image_sun -> {
                binding.imageSun.setColorFilter(
                    ContextCompat.getColor(
                        this,
                        com.example.motivation.R.color.white
                    )
                )
            }

            com.example.motivation.R.id.image_child -> {
                binding.imageChild.setColorFilter(
                    ContextCompat.getColor(
                        this,
                        com.example.motivation.R.color.white
                    )
                )
            }
        }
    }


    //O TEXTO QUE O USUARIO ISERIR  APARECERAR AQUI NESTA ACTIVITY
    private fun handleUserName() {
        val nomeUser = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        "Olá, $nomeUser!".also { binding.textHello.text = it }

    }


}