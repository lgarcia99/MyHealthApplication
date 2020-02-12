package garcia.luis.myhealthapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.roundToInt

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
            var p:Float = peso.text.toString().toFloat()
            var a:Float = altura.text.toString().toFloat()

            val m: Float = p / (a * a)
            imc.setText(""+m)

            /*if (m < 0) {
                rango.setText("")
            }*/

            when (m) {
                in 0.0..18.5 -> rango.setBackgroundResource(R.color.lime)
                in 18.5..24.9 -> rango.setBackgroundResource(R.color.green)
                in 25.0..29.9 -> rango.setBackgroundResource(R.color.yellow)
                in 30.0..39.9 -> rango.setBackgroundResource(R.color.orange)
                else -> rango.setBackgroundResource(R.color.red)
            }
        }
    }
}
