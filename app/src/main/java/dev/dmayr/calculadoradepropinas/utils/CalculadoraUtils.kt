package dev.dmayr.calculadoradepropinas.utils

class CalculadoraUtils {
    fun calcularPropina(cuenta: Int, porcentaje: Int): Int {
        return if (cuenta > 0 && porcentaje > 0) {
            kotlin.math.round((cuenta * porcentaje / 100).toDouble()).toInt()
        } else 0
    }
}
