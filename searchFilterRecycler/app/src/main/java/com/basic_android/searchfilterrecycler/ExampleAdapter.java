package com.basic_android.searchfilterrecycler;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import android.widget.Toast;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>
{
    private ArrayList<ExampleItem> mExampleList;
    public static class ExampleViewHolder extends RecyclerView.ViewHolder
    {
        public TextView mTextView1;
        //public EditText mEditText2nd;


        public ExampleViewHolder(View itemView) {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.textView);
            TextView tv1 = mTextView1;
            //mEditText2nd = itemView.findViewById(R.id.edittext);
            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    System.out.println("yeet "+ tv1.getText().toString());
                    Toast.makeText(view.getContext(),"yeet "+ tv1.getText().toString() + " uhu",Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
    public ExampleAdapter(ArrayList<ExampleItem> exampleList)
    {
        mExampleList = exampleList;
    }
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item,
                parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }
    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position)
    {
        ExampleItem currentItem = mExampleList.get(position);
        holder.mTextView1.setText(currentItem.getText1());
        //holder.mEditText2nd.getText().toString(); # tak jadi

    }
    @Override
    public int getItemCount()
    {
        return mExampleList.size();
    }
    public void filterList(ArrayList<ExampleItem> filteredList) {
        mExampleList = filteredList;
        notifyDataSetChanged();
    }
}
