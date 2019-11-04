package com.example.documentos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DocumentAdaptapter extends RecyclerView.Adapter<DocumentAdaptapter.DocumentoViewHolder> {

    private Context mCtx;
    private List<Documento> documentoList;

    public DocumentAdaptapter(Context mCtx, List<Documento>documentoList){
        this.mCtx=mCtx;
        this.documentoList=documentoList;
    }

    @Override
    public DocumentoViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.documento_list, null);
        return new DocumentoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DocumentoViewHolder holder, int position) {
        Documento documento = documentoList.get(position);

        holder.textViewTitle.setText(documento.getNombre());

    }


    @Override
    public int getItemCount(){return documentoList.size();}

    class DocumentoViewHolder extends RecyclerView.ViewHolder{
        TextView textViewTitle;
        public DocumentoViewHolder(View itemView){
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
        }
    }
}
