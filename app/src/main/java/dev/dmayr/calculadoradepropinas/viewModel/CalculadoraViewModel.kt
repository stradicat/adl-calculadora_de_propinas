package dev.dmayr.calculadoradepropinas.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.dmayr.calculadoradepropinas.utils.CalculadoraUtils

class CalculadoraViewModel : ViewModel() {

    private val calcUtils: CalculadoraUtils = CalculadoraUtils()

    private val _valorCuenta = MutableLiveData<Int>()
    val valorCuenta: LiveData<Int> = _valorCuenta

    private val _porcentajePropina = MutableLiveData<Int>()
    val porcentajePropina: LiveData<Int> = _porcentajePropina

    private val _totalPropina = MutableLiveData<Int>()
    val totalPropina: LiveData<Int> = _totalPropina

    private val _totalCuenta = MutableLiveData<Int>()
    val totalCuenta: LiveData<Int> = _totalCuenta


    fun actualizarValorCuenta(valor: Int) {
        _valorCuenta.value = valor
        recalcular()
    }

    fun actualizarPorcentajePropina(porcentaje: Int) {
        _porcentajePropina.value = porcentaje
        recalcular()
    }

    private fun recalcular() {
        val valor: Int = _valorCuenta.value ?: 0
        val porcentaje: Int = _porcentajePropina.value ?: 0

        val propina = if (valor > 0 && porcentaje > 0) {
            calcUtils.calcularPropina(valor, porcentaje)
        } else 0

        _totalPropina.value = propina
        _totalCuenta.value = valor + propina
    }
}
