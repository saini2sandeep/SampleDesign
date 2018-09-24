package com.example.sandeepsaini.multitaskapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

public class XyzActivity extends AppCompatActivity {

    TextView textView;
    TextView moreTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xyz);
        textView = findViewById(R.id.textView2);
        moreTv = findViewById(R.id.more_tv);
        setUpUI();
    }

    private void setUpUI() {


        //  makeTextViewResizable(textView, 3, "More", true);
        makeTextMoreVisible(textView, 3, "More", true);

    }


    public void makeTextMoreVisible(final TextView textView, final int maxLine, final String expandText, final boolean viewMore) {
//      final  String text = "Please be aware that the school is operating under an early release schedule due to threat of inclement weather. School will be closing 4 hrs early " +
//                "so school will be over at 11:00 AM. If you pick you child up, please be prepared to be at school no later Lorem ipsum dolor sit amet, consectetur adipiscing " +
//                "elit. Mauris pretium sed orci vitae consequat. Nam vitae odio non nibh lobortis egestas ac volutpat quam. Pellentesque pulvinar diam at";

      //  final int maxLine;

//        final String text = "Sandeep Saini Sandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep Saini" +
//                "Sandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep Saini" +
//                "Sandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep SainiSandeep Saini";

        final String text = "Sandeep";
        textView.setText(text);



        ViewTreeObserver vto = textView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int lineEndIndex;
                ViewTreeObserver obs = textView.getViewTreeObserver();
                  obs.removeGlobalOnLayoutListener(this);
//                if (maxLine == 0) {
                lineEndIndex = textView.getLayout().getLineEnd(0);
                Log.d("Sandy", "line end index : " + lineEndIndex);
                int textLength = text.length();
                Log.d("Sandy", "length: " + textLength);
                int totalLines = textLength/lineEndIndex;
                Log.d("Sandy", "totalLines : " + totalLines);
                int lineCount = textView.getLineCount();
                Log.d("Sandy", "line count : " + lineCount);
                if (totalLines >= 4) {
                    Log.d("Sandy", "if lineCount : " + totalLines);

                    moreTv.setVisibility(View.VISIBLE);
                } else {
                    Log.d("Sandy", "else lineCount : " + totalLines);

                    moreTv.setVisibility(View.GONE);
                }
                // text = textView.getText().subSequence(0, lineEndIndex - expandText.length() + 1) + " ";// + expandText;
//                } else if (maxLine > 0 && textView.getLineCount() >= maxLine) {

//                    lineEndIndex = textView.getLayout().getLineEnd(maxLine - 1);
//                    text = textView.getText().subSequence(0, lineEndIndex - expandText.length() + 1) + " " + expandText;

//                }
            }
        });


    }


    public static void makeTextViewResizable(final TextView tv, final int maxLine, final String expandText, final boolean viewMore) {

        if (tv.getTag() == null) {
            tv.setTag(tv.getText());
        }
        ViewTreeObserver vto = tv.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @SuppressWarnings("deprecation")
            @Override
            public void onGlobalLayout() {
                String text;
                int lineEndIndex;
                ViewTreeObserver obs = tv.getViewTreeObserver();
                obs.removeGlobalOnLayoutListener(this);
                Log.d("Sandy", "Max Lines : " + maxLine);
                if (maxLine == 0) {
                    lineEndIndex = tv.getLayout().getLineEnd(0);
                    Log.d("Sandy", "line end index : " + lineEndIndex);
                    text = tv.getText().subSequence(0, lineEndIndex - expandText.length() + 1) + " " + expandText;
                } else if (maxLine > 0 && tv.getLineCount() >= maxLine) {
                    Log.d("Sandy", "max lines : " + maxLine);
                    Log.d("Sandy", "line count : " + tv.getLineCount());

                    lineEndIndex = tv.getLayout().getLineEnd(maxLine - 1);
                    text = tv.getText().subSequence(0, lineEndIndex - expandText.length() + 1) + " " + expandText;
                } else {
                    lineEndIndex = tv.getLayout().getLineEnd(tv.getLayout().getLineCount() - 1);
                    text = tv.getText().subSequence(0, lineEndIndex) + " " + expandText;
                }
                tv.setText(text);
                tv.setMovementMethod(LinkMovementMethod.getInstance());
                tv.setText(
                        addClickablePartTextViewResizable(Html.fromHtml(tv.getText().toString()), tv, lineEndIndex, expandText,
                                viewMore), TextView.BufferType.SPANNABLE);
            }
        });

    }

    private static SpannableStringBuilder addClickablePartTextViewResizable(final Spanned strSpanned, final TextView tv,
                                                                            final int maxLine, final String spanableText, final boolean viewMore) {
        String str = strSpanned.toString();
        SpannableStringBuilder ssb = new SpannableStringBuilder(strSpanned);

        if (str.contains(spanableText)) {
            ssb.setSpan(new ClickableSpan() {

                @Override
                public void onClick(View widget) {
                    tv.setLayoutParams(tv.getLayoutParams());
                    tv.setText(tv.getTag().toString(), TextView.BufferType.SPANNABLE);
                    tv.invalidate();
                    if (viewMore) {
                        makeTextViewResizable(tv, -1, "View Less", false);
                    } else {
                        makeTextViewResizable(tv, 3, "View More", true);
                    }

                }
            }, str.indexOf(spanableText), str.indexOf(spanableText) + spanableText.length(), 0);

        }
        return ssb;

    }

}
