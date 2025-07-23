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
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        enableEdgeToEdge()
        setContentView(view)

        setupObservers()
        setupListeners()

        ViewCompat.setOnApplyWindowInsetsListener(view) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun setupListeners() {
        binding.btnPropina10.setOnClickListener {
            binding.etPorcentajePropina.setText(10.toString())
        }
        binding.btnPropina15.setOnClickListener {
            binding.etPorcentajePropina.setText(15.toString())
        }
        binding.btnPropina20.setOnClickListener {
            binding.etPorcentajePropina.setText(20.toString())
        }
        binding.btnBorrarTodo.setOnClickListener {
            binding.etPorcentajePropina.setText("")
            binding.etValorCuenta.setText("")
        }

        binding.etValorCuenta.addTextChangedListener { editableCuenta ->
            val valor = editableCuenta.toString().toIntOrNull() ?: 0
            calcViewModel.actualizarValorCuenta(valor)
        }

        binding.etPorcentajePropina.addTextChangedListener { editablePorcPropina ->
            val porcentaje = editablePorcPropina.toString().toIntOrNull() ?: 0
            calcViewModel.actualizarPorcentajePropina(porcentaje)
        }
    }

    private fun setupObservers() {
        calcViewModel.valorCuenta.observe(this) { valorCuenta ->
            val valorStr = if (valorCuenta == 0) "" else valorCuenta.toString()
            if (binding.etValorCuenta.text.toString() != valorStr) {
                binding.etValorCuenta.setText(valorStr)
            }
        }
        calcViewModel.porcentajePropina.observe(this) { valorPorcentajePropina ->
            val valorStr =
                if (valorPorcentajePropina == 0) "" else valorPorcentajePropina.toString()
            if (binding.etPorcentajePropina.text.toString() != valorStr) {
                binding.etPorcentajePropina.setText(valorStr)
            }
        }
        calcViewModel.totalPropina.observe(this) { valorTotalPropina ->
            val valorStr = if (valorTotalPropina == 0) "" else "$ $valorTotalPropina"
            binding.tvTotalPropina.text = valorStr
        }
        calcViewModel.totalCuenta.observe(this) { valorTotalCuenta ->
            val valorStr = if (valorTotalCuenta == 0) "" else "$ $valorTotalCuenta"
            binding.tvTotalCuenta.text = valorStr
        }
    }
}
