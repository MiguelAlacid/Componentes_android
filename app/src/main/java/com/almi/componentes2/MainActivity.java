package com.almi.componentes2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton radCurso1;
    RadioButton radCurso2;
    RadioButton radCurso3;

    RadioButton radTurno1;
    RadioButton radTurno2;
    RadioButton radTurno3;
    Switch stwIVA;
    TextView lblTotal;
    EditText nombreAlumno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radCurso1 = findViewById(R.id.radFormaPago1);
        radCurso2 = findViewById(R.id.radFormaPago2);
        radCurso3 = findViewById(R.id.radFormaPago3);

        radTurno1 = findViewById(R.id.turno1);
        radTurno2 = findViewById(R.id.turno2);
        radTurno3 = findViewById(R.id.turno3);

	    nombreAlumno = findViewById(R.id.nombreAlumno);
        lblTotal = findViewById(R.id.lblTotal);
        stwIVA = findViewById(R.id.stwIVA);

    }


    public void sumaTotal(View v){
 	String sNombreAlumno = nombreAlumno.getText().toString();
	    if(sNombreAlumno.isEmpty()){
            Toast.makeText(this, "introduce un nombre para continuar", Toast.LENGTH_LONG).show();
        }else {
            final double precioCurso[] = {1000, 1200, 750};
            final double precioTurno[] = {600, 400, 200};
            final double iva = 1.21;

            double precioxCurso = 0.0;
            double precioxTotal = 0.0;
            double precioxIVA = 0.0;
            double precioxTurno = 0.0;
            if (stwIVA.isChecked()) precioxIVA = iva;
            else precioxIVA = 1.0;

            if (radCurso1.isChecked()) precioxCurso = precioCurso[0];
            if (radCurso2.isChecked()) precioxCurso = precioCurso[1];
            if (radCurso3.isChecked()) precioxCurso = precioCurso[2];
            if (radTurno1.isChecked()) precioxTurno = precioTurno[0];
            if (radTurno2.isChecked()) precioxTurno = precioTurno[1];
            if (radTurno3.isChecked()) precioxTurno = precioTurno[2];


            precioxTotal = (precioxCurso + precioxTurno) * precioxIVA;
            lblTotal.setText("" + precioxTotal + " €");
        }
	}
}