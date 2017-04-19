package com.yaoc.inclassassignment11_yaoc;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by YaoChen on 4/14/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<MathQuiz> mDataset;
    private int success, fail;
    private TextView count;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {


        // each data item is just a string in this case
        public TextView mQuiz;
        public EditText mResult;
        public ImageView mOperator;
        public Button mSubmit;
        private String mAnswer;

        public ViewHolder(View v) {
            super(v);
            mQuiz = (TextView)v.findViewById(R.id.quiz);
            mResult = (EditText) v.findViewById(R.id.answer);
            mOperator = (ImageView) v.findViewById(R.id.operator);
            mSubmit = (Button) v.findViewById(R.id.submit);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<MathQuiz> myDataset, TextView count) {
        success = fail = 0;
        this.count = count;
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mQuiz.setText(mDataset.get(position).toQuiz());
        //holder.mAnswer.setText(mDataset.get(position).toReadableTime());
        if(mDataset.get(position).getOperater().equals("+")){
            holder.mOperator.setImageResource(R.drawable.plus);
        } else if(mDataset.get(position).getOperater().equals("-")){
            holder.mOperator.setImageResource(R.drawable.minus);
        }else if(mDataset.get(position).getOperater().equals("*")) {
            holder.mOperator.setImageResource(R.drawable.multiply);
        }
        holder.mAnswer = mDataset.get(position).getAnswer();
        holder.mResult.setText("");

        holder.mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.mResult.getText().toString().equals(holder.mAnswer)) {
                    //Success
                    ++ success;
                    Toast.makeText(v.getContext(), "Congratulation!", Toast.LENGTH_SHORT).show();
                    mDataset.remove(holder.getAdapterPosition());
                    notifyDataSetChanged();
                } else {
                    //Fail
                    ++ fail;
                    Toast.makeText(v.getContext(), "Booooooo~ Wrong answer!", Toast.LENGTH_SHORT).show();
                }
                count.setText("Success: " + success + ", Fail: " + fail);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
