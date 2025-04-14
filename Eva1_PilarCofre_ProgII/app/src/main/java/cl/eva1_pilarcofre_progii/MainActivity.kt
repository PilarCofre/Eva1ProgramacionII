package cl.eva1_pilarcofre_progii

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import cl.eva1_pilarcofre_progii.modelo.Restaurant

class MainActivity : AppCompatActivity() {
    //private var Total_a_Pagar: TextView? = null
    private var tvTotalCompras: TextView? = null //cantidad de platos
    private var tvtotal: TextView? = null //total en pesos de los platos comprados
    private var tvpropina: TextView?= null
    private var switchCalcularPropina: Switch? = null
    private var botonCalcularTotalPlatos: Button? = null
    private var etCantidadCazuela: EditText? = null // cantidad plato cazuela
    private var etCantPastel: EditText? = null // cantidad plato choclo
    private var calcularPropinaSwitch = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        /*  ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
              val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
              v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
              insets
          }*/
        switchCalcularPropina = findViewById<Switch>(R.id.switchCalcularPropina)
        botonCalcularTotalPlatos = findViewById<Button>(R.id.btnCalcularTotalPlatos)
        etCantidadCazuela = findViewById<EditText>(R.id.etCantCazuela)
        etCantPastel = findViewById<EditText>(R.id.etCantPastel)
        tvpropina = findViewById<TextView>(R.id.tvpropina)
        val tvTotalCompras = findViewById<TextView>(R.id.tvTotalCompras)
        val tvtotal = findViewById<TextView>(R.id.tvtotal)
        val tvpropina = findViewById<TextView>(R.id.tvpropina)
        //val Total_a_Pagar = findViewById<TextView>(R.id.tvtotal)
       // switchCalcularPropina?.setOnCheckedChangeListener { buttonView, isChecked ->tvpropina.text = isChecked.toString() }
        switchCalcularPropina?.setOnCheckedChangeListener { buttonView, isChecked ->calcularPropinaSwitch = isChecked }

        botonCalcularTotalPlatos?.setOnClickListener{

            val restaurant = Restaurant()
            val porcentaje: Double = 10.0
           val cantCazuela = etCantidadCazuela?.text.toString().toFloatOrNull() ?: 1.0f
            val cantPastel = etCantPastel?.text.toString().toFloatOrNull() ?: 7.0f
            restaurant.agregarCantidadCazuela(cantCazuela)
            restaurant.agregarCantidadPastel(cantPastel)
           val totalPago = restaurant.calcularValorPlatos()

           val totalPagoConPropina = restaurant.calcularTotalPagoConPropina()
            val totalcompra = restaurant.calcularValorPlatos()
            val tvpropinas = restaurant.calcularPropina(totalcompra, porcentaje)
            tvTotalCompras?.setText(totalPagoConPropina.toString())
            tvtotal?.setText(totalPago.toString()) /*// muestra el total en $ de los platos*/
            tvpropina.setText(tvpropinas.toString())

       }
    }
}


