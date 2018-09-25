package com.example.jonat.personalhealthrecord;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TextView;

public class BasicEntry extends ConstraintLayout {
    public BasicEntry(Context context) {
        super(context);
    }
    public BasicEntry(Context context, AttributeSet attrs, int defStyles) {
        super(context, attrs, defStyles);
        new BasicEntry(context, attrs);
    }
    public BasicEntry(Context context, AttributeSet attrs) {
        super(context, attrs);

        inflate(context, R.layout.entry_view, this);

        Button date = (Button) findViewById(R.id.date_item);
        TextView name = (TextView) findViewById(R.id.entry_name);
        TextView value = (TextView) findViewById(R.id.entry_value);
        TextView author = (TextView) findViewById(R.id.entry_author);

        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.BasicEntry);

        date.setText(attributes.getText(R.styleable.BasicEntry_entryDate));
        name.setText(attributes.getText(R.styleable.BasicEntry_entryName));
        value.setText(attributes.getText(R.styleable.BasicEntry_entryValue));
        author.setText(attributes.getText(R.styleable.BasicEntry_entryAuthor));

        attributes.recycle();
    }
}
