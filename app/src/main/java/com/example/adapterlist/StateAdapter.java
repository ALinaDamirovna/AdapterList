package com.example.adapterlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StateAdapter extends ArrayAdapter<State> {

    private LayoutInflater inflater;
    private int layout;
    private List<State> states;

    public StateAdapter(Context context, int resource, List<State> states) {
        super(context, resource, states);
        this.states = states;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    /* public View getView(int position, View convertView, ViewGroup parent) {

         View view=inflater.inflate(this.layout, parent, false);

         ImageView flagView = view.findViewById(R.id.flag);
         TextView nameView = view.findViewById(R.id.name);
         TextView capitalView = view.findViewById(R.id.capital);

         State state = states.get(position);

         flagView.setImageResource(state.getFlagResource());
         nameView.setText(state.getName());
         capitalView.setText(state.getCapital());

         return view;
   } */
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        State state = states.get(position);

        viewHolder.imageView.setImageResource(state.getFlagResource());
        viewHolder.nameView.setText(state.getName());
        viewHolder.capitalView.setText(state.getCapital());

        return convertView;
    }

    /*В методе getView, если convertView равен null (то есть если ранее для объекта не создана разметка)
     создаем объект ViewHolder, который сохраняем в тег в convertView:
     Если же разметка для объекта в ListView уже ранее была создана, то обратно получаем ViewHolder из тега:
      viewHolder = (ViewHolder) convertView.getTag();
       Затем также для ImageView и TextView во ViewHolder устанавливаются значения из объекта State:*/
    private class ViewHolder {
        final ImageView imageView;
        final TextView nameView, capitalView;

        ViewHolder(View view) {
            imageView = view.findViewById(R.id.flag);
            nameView = view.findViewById(R.id.name);
            capitalView = view.findViewById(R.id.capital);
        }
    }
}