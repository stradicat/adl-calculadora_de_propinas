package dev.dmayr.calculadoradepropinas

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import dev.dmayr.calculadoradepropinas.databinding.ActivityMainBinding
import dev.dmayr.calculadoradepropinas.viewModel.CalculadoraViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val calcViewModel by viewModels<CalculadoraViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        /*-------------------------------------------------------------------*/
        val btn10 = binding.btnPropina10
        val btn15 = binding.btnPropina15
        val btn20 = binding.btnPropina20
        /*-------------------------------------------------------------------*/

        setContentView(view)

        setupObservers()
        setupListeners()

        btn10.setOnClickListener {
            binding.etPorcentajePropina.setText("10")
        }
        btn15.setOnClickListener {
            binding.etPorcentajePropina.setText("15")
        }
        btn20.setOnClickListener {
            binding.etPorcentajePropina.setText("20")
        }

        ViewCompat.setOnApplyWindowInsetsListener(view) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun setupListeners() {
        binding.etValorCuenta.addTextChangedListener { editable ->
            val valor = editable.toString().toIntOrNull() ?: 0
            calcViewModel.actualizarValorCuenta(valor)
        }

        binding.etPorcentajePropina.addTextChangedListener { editable ->
            val porcentaje = editable.toString().toIntOrNull() ?: 0
            calcViewModel.actualizarPorcentajePropina(porcentaje)
        }
    }

    private fun setupObservers() {
        calcViewModel.valorCuenta.observe(this) { valor ->
            val valorStr = valor?.toString() ?: ""
            if (binding.etValorCuenta.text.toString() != valorStr) {
                binding.etValorCuenta.setText(valorStr)
            }
        }
        calcViewModel.porcentajePropina.observe(this) { valor ->
            val valorStr = valor?.toString() ?: ""
            if (binding.etPorcentajePropina.text.toString() != valorStr) {
                binding.etPorcentajePropina.setText(valorStr)
            }
        }
        calcViewModel.totalPropina.observe(this) { valor ->
            val valorStr = valor?.toString() ?: ""
            if (binding.tvTotalPropina.text.toString() != valorStr) {
                binding.tvTotalPropina.text = valorStr
            }
        }
        calcViewModel.totalCuenta.observe(this) { valor ->
            val valorStr = valor?.toString() ?: ""
            if (binding.tvTotalCuenta.text.toString() != valorStr) {
                binding.tvTotalCuenta.text = valorStr
            }
        }

    }
}
