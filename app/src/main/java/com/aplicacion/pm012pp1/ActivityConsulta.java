package com.aplicacion.pm012pp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aplicacion.pm012pp1.Procesos.SQLiteConexion;
import com.aplicacion.pm012pp1.Procesos.Transacciones;

public class ActivityConsulta extends AppCompatActivity {


    SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDataBase,null,1);

    EditText id, nombres, apellidos, edad, correo, direccion;
    Button btnconsulta, btneliminar, btnactualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        init();

        btnconsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BuscarEmpleado();
            }
        });

        btnactualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditarContacto();
            }
        });

        btneliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarContacto();
            }
        });

    }

    private void BuscarEmpleado()
    {
        try
        {
            SQLiteDatabase db = conexion.getWritableDatabase();
            /* Parametros de BUSQUEDA de la sentencia SELECT*/
            String [] params = {id.getText().toString()};

            /* Campos a retornar  de la sentencia SELECT*/
            String [] fields = { Transacciones.nombres,
                    Transacciones.apellidos,
                    Transacciones.correo,
                    Transacciones.edad,
                    Transacciones.direccion};

            String WhereCondition = Transacciones.id + "=?";

            Cursor cdata = db.query(Transacciones.tablaEmpleados,
                    fields,
                    WhereCondition,params,null,null,null);

            cdata.moveToFirst();

            if(cdata.getCount() > 0 )
            {
                nombres.setText(cdata.getString(0));
                apellidos.setText(cdata.getString(1));
                correo.setText(cdata.getString(2));
                edad.setText(cdata.getString(3));
                direccion.setText(cdata.getString(4));

                Toast.makeText(getApplicationContext(),"Consultado con exito !!",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(),"No hay datos !!",Toast.LENGTH_LONG).show();
            }
        }
        catch (Exception ex)
        {
            Toast.makeText(getApplicationContext(),"ha ocurrido un inconveniente !!",Toast.LENGTH_LONG).show();
        }


    }




    private void EditarContacto() {
        //SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDatabase,null,1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        String ObjCodigo = id.getText().toString();

        ContentValues valores = new ContentValues();

        valores.put(Transacciones.nombres, nombres.getText().toString());
        valores.put(Transacciones.apellidos, apellidos.getText().toString());
        valores.put(Transacciones.edad, edad.getText().toString());
        valores.put(Transacciones.correo, correo.getText().toString());
        valores.put(Transacciones.direccion, direccion.getText().toString());

        try {
            db.update(Transacciones.tablaEmpleados,valores, Transacciones.id +" = "+ ObjCodigo, null);
            db.close();
            Toast.makeText(getApplicationContext(),"Se actualizo correctamente", Toast.LENGTH_SHORT).show();


        }catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"No se actualizo", Toast.LENGTH_SHORT).show();
        }


        ClearScreen();
    }


    private void Eliminar()
    {


    }

    private void init()
    {
        conexion = new SQLiteConexion(this, Transacciones.NameDataBase, null, 1);

        btnconsulta = (Button) findViewById(R.id.btnbuscar);
        btneliminar = (Button) findViewById(R.id.btneliminar);
        btnactualizar = (Button) findViewById(R.id.btnactualizar);

        id = (EditText) findViewById(R.id.txtcid);
        nombres = (EditText) findViewById(R.id.txtcnombres);
        apellidos = (EditText) findViewById(R.id.txtcapellidos);
        edad = (EditText) findViewById(R.id.txtcedad);
        correo = (EditText) findViewById(R.id.txtccorreo);
        direccion = (EditText) findViewById(R.id.txtcdireccion);

    }


    private void eliminarContacto() {
        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDataBase, null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();
        String obtenerCodigo = id.getText().toString();

        db.delete(Transacciones.tablaEmpleados,Transacciones.id +" = "+ obtenerCodigo, null);

        Toast.makeText(getApplicationContext(), "Registro eliminado con exito, Codigo " + obtenerCodigo
                ,Toast.LENGTH_LONG).show();
        db.close();
        ClearScreen();


    }

    private void ClearScreen()
    {
        id.setText("");
        nombres.setText("");
        apellidos.setText("");
        edad.setText("");
        correo.setText("");
        direccion.setText("");
    }
}