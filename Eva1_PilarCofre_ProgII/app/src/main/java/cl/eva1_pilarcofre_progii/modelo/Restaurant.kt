package cl.eva1_pilarcofre_progii.modelo

import java.text.NumberFormat
import java.util.Locale

class Restaurant(val cantidadPastel: MutableList<Float> = mutableListOf<Float>(),
                 val cantidadCazuela: MutableList<Float> = mutableListOf<Float>())
{
    fun agregarCantidadPastel(cantPastel:Float){
        cantidadPastel.add(cantPastel)
    }
    fun agregarCantidadCazuela(cantCazuela:Float){
        cantidadCazuela.add(cantCazuela)
    }
    //calcular propina solo si esta activado
    fun calcularPropina(totalCompra: Float, porcentaje: Double = 10.0): Double {
        val tvpropinas = totalCompra * (porcentaje / 100)
        return tvpropinas
    }
    fun calcularValorPlatos(): Float {
        val precioCazuela = 10000
        val precioPastel = 12000
        val totalcazuela  = cantidadCazuela.sum()
        val totalpastel = cantidadPastel.sum()
        val totalCompra = (totalcazuela * precioCazuela) + (totalpastel * precioPastel)
        return totalCompra
    }
    fun calcularTotalPagoConPropina(): String {
        val totalCompra = calcularValorPlatos()
        val tvpropinas = calcularPropina(totalCompra)
        val totalFinal = totalCompra + tvpropinas

        val formatoCLP = NumberFormat.getCurrencyInstance(Locale("es", "CL"))
        formatoCLP.maximumFractionDigits = 0
        return formatoCLP.format(totalFinal)
    }
}


