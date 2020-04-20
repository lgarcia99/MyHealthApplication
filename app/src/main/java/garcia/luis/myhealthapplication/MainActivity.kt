package garcia.luis.myhealthapplication

import android.R.attr.data
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val peso: EditText = findViewById(R.id.weight) as EditText
        val altura: EditText = findViewById(R.id.height) as EditText
        val calcular: Button = findViewById(R.id.calculate) as Button
        val imc: TextView = findViewById(R.id.imc) as TextView
        val rango: TextView = findViewById(R.id.range) as TextView

        calcular.setOnClickListener {
            try {
                var p:Float = peso.text.toString().toFloat()
                var a:Float = altura.text.toString().toFloat()

                val m: Float = (p / ((a * a) / 100)) * 100
                imc.setText("IMC: $m")

                when (m) {
                    in 0.0..18.5 -> {
                        rango.setBackgroundResource(R.color.lime)
                        rango.setText("Infrapeso")
                    }
                    in 18.5..24.9 -> {
                        rango.setBackgroundResource(R.color.green)
                        rango.setText("Peso normal")
                    }
                    in 25.0..29.9 -> {
                        rango.setBackgroundResource(R.color.yellow)
                        rango.setText("Sobrepeso")
                    }
                    in 30.0..39.9 -> {
                        rango.setBackgroundResource(R.color.orange)
                        rango.setText("Obesidad")
                    }
                    else -> {
                        rango.setBackgroundResource(R.color.red)
                        rango.setText("Hiperobesidad")
                    }
                }
            } catch (e: Throwable) {
                Toast.makeText(
                    getBaseContext(), "Error: Ingrese bien sus cantidades antes de continuar",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
