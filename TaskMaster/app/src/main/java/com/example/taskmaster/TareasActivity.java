package com.example.taskmaster;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TareasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tareas);

        // Configurar Spinner
        Spinner spinnerEstado = findViewById(R.id.spinnerEstado);

        String[] estados = {
                "Pendiente",
                "En progreso",
                "Completada"
        };

        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                estados
        );

        adapterSpinner.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spinnerEstado.setAdapter(adapterSpinner);


        // Configurar RecyclerView
        RecyclerView recyclerTareas =
                findViewById(R.id.recyclerTareas);

        recyclerTareas.setLayoutManager(
                new LinearLayoutManager(this)
        );


        // Crear lista de tareas
        List<Tarea> tareas = new ArrayList<>();

        tareas.add(
                new Tarea(
                        "Estudiar Android",
                        "Pendiente"
                )
        );

        tareas.add(
                new Tarea(
                        "Hacer informe",
                        "En progreso"
                )
        );

        tareas.add(
                new Tarea(
                        "Preparar presentación",
                        "Completada"
                )
        );


        // Crear Adapter
        TareaAdapter adapterTareas =
                new TareaAdapter(tareas);

        recyclerTareas.setAdapter(adapterTareas);
    }
}
