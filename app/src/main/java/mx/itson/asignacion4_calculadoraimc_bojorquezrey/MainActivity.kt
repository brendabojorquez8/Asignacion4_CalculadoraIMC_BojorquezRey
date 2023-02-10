package mx.itson.asignacion4_calculadoraimc_bojorquezrey

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val weight: EditText = findViewById<EditText>(R.id.weight)
    val height: EditText = findViewById<EditText>(R.id.height)
    val calcular: Button = findViewById<Button>(R.id.calcularIMC)
    val iMC: TextView = findViewById<TextView>(R.id.iMC)
    val estado: TextView = findViewById<TextView>(R.id.estado)

    override fun onCreate(savedInstanceState: Bundle?) {

            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            calcular.setOnClickListener {
                if(weight.text.toString().isEmpty() || height.text.toString().isEmpty()){
                    estado.text = "Ingresa los valores"
                    estado.setBackgroundResource(R.color.colorRed)
                }else{
                    if(calcularIMC() <18.5){
                        iMC.text = calcularIMC().toString()
                        estado.text = "Bajo peso"
                        estado.setBackgroundResource(R.color.colorGreenish)
                    } else if(calcularIMC() <25){
                        iMC.text = calcularIMC().toString()
                        estado.text = "Normal"
                        estado.setBackgroundResource(R.color.colorGreen)
                    } else if(calcularIMC() <30){
                        iMC.text = calcularIMC().toString()
                        estado.text = "Sobrepeso"
                        estado.setBackgroundResource(R.color.colorBrown)
                    }else if(calcularIMC() <35){
                        iMC.text = calcularIMC().toString()
                        estado.text = "Obesidad grado 1"
                        estado.setBackgroundResource(R.color.colorYellow)
                    }else if(calcularIMC() <40){
                        iMC.text = calcularIMC().toString()
                        estado.text = "Obesidad grado 2"
                        estado.setBackgroundResource(R.color.colorOrange)
                    }else if(calcularIMC() >=40){
                        iMC.text = calcularIMC().toString()
                        estado.text = "Obesidad grado 3"
                        estado.setBackgroundResource(R.color.colorRed)
                    }
                }
            }
    }
    fun calcularIMC():Float{
        return (weight.text.toString().toFloat()/Math.pow(height.text.toString().toDouble(),2.0)).toFloat()
    }
}