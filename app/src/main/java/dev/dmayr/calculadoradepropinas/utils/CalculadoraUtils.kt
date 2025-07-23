package dev.dmayr.calculadoradepropinas.utils

class CalculadoraUtils {
    fun calcularPropina(cuenta: Double, porcentaje: Double): Double {
        return kotlin.math.round((porcentaje / 100) * cuenta)
    }
}
