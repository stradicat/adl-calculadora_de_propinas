package dev.dmayr.calculadoradepropinas.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.dmayr.calculadoradepropinas.utils.CalculadoraUtils

class CalculadoraViewModel : ViewModel() {

    private val calcUtils: CalculadoraUtils = CalculadoraUtils()

    private val _valorCuenta = MutableLiveData<Double>()
    val valorCuenta: LiveData<Double> = _valorCuenta

    private val _porcentajePropina = MutableLiveData<Double>()
    private val porcentajePropina: LiveData<Double> = _porcentajePropina

    private val _totalCuenta = MutableLiveData<Double>()
    private val totalCuenta: LiveData<Double> = _totalCuenta


    private fun actualizarDatos(valCuenta: Double, porcPropina: Double, totCuenta: Double) {
        _valorCuenta.value = valCuenta
        _porcentajePropina.value = porcPropina
        _totalCuenta.value = calcUtils.calcularPropina(
            totCuenta,
            porcPropina
        )
    }
}
