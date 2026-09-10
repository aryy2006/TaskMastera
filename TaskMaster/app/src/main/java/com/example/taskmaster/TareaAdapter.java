package com.example.taskmaster;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TareaAdapter extends RecyclerView.Adapter<TareaAdapter.TareaViewHolder> {

    private List<Tarea> listaTareas;

    public TareaAdapter(List<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }

    @NonNull
    @Override
    public TareaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tarea, parent, false);

        return new TareaViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull TareaViewHolder holder, int position) {

        Tarea tarea = listaTareas.get(position);

        holder.tvTarea.setText(tarea.getNombre());
        holder.tvEstado.setText(tarea.getEstado());
    }

    @Override
    public int getItemCount() {
        return listaTareas.size();
    }

    public static class TareaViewHolder extends RecyclerView.ViewHolder {

        TextView tvTarea;
        TextView tvEstado;

        public TareaViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTarea = itemView.findViewById(R.id.tvTarea);
            tvEstado = itemView.findViewById(R.id.tvEstado);
        }
    }
}
