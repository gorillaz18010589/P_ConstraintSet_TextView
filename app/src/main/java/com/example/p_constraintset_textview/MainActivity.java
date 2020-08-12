package com.example.p_constraintset_textview;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Build;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout conItem1Bar;
    private ImageView img;
    private TextView tvMsg;
    private String msg ="让球盘：\n" +
            "\n" +
            "1. 根据盘口让球信息预测最终获得胜利的球队。\n" +
            "\n" +
            "2. 投注的结算皆以球赛所规定的完场时间90分钟为准。\n" +
            "\n" +
            "3. 如果赛事在90分钟结束前取消或中断，那已有明确结果并且之后没有任何显著会影响赛事结果的注单将会结算，其他所有注单将会被视为无效。 足球滚球让球盘：";
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conItem1Bar = findViewById(R.id.conItem1Bar);
        img = findViewById(R.id.img);
        tvMsg = findViewById(R.id.tvMsg);
        tvMsg.setText(msg);

//        Test();
//        setBalanceView(ConstraintSetUtils.NO_OFFER_DISMISS_TYPE);

        conItem1Bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    Log.v("hank","onClick");
                    setBalanceView(ConstraintSetUtils.NO_OFFER_DISMISS_TYPE);
                }
            }
        });
        img = findViewById(R.id.img);
    }

    private void test() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(conItem1Bar);
        constraintSet.constrainPercentHeight(R.id.ConItem1,0.8f);
        constraintSet.applyTo(conItem1Bar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(conItem1Bar);
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void setBalanceToggle(float heightPercent, int changeImgId, int visibilityType) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(conItem1Bar);
        img.setImageDrawable(getResources().getDrawable(changeImgId));
        constraintSet.constrainPercentHeight(R.id.ConItem1, heightPercent);
        constraintSet.applyTo(conItem1Bar);
        TransitionManager.beginDelayedTransition(conItem1Bar);


    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void setBalanceView(int type) {
        switch (type) {
            case ConstraintSetUtils.NO_OFFER_DISMISS_TYPE:
                //沒有優惠的關閉效果
                setBalanceToggle(0.68f, R.drawable.ic_launcher_background, View.VISIBLE);
                break;
            case ConstraintSetUtils.NO_OFFER_SHOW_TYPE:
                //沒有優惠的展開效果
                setBalanceToggle(0.1f, R.drawable.ic_launcher_background, View.GONE);
                break;

            case ConstraintSetUtils.OFFER_DISMISS_TYPE:
                //有優惠的關閉效果
                setBalanceToggle(0.5f, R.drawable.ic_launcher_background, View.VISIBLE);
                break;

            case ConstraintSetUtils.OFFER_SHOW_TYPE:
                //有優惠的展開效果
                setBalanceToggle(0.1f, R.drawable.ic_launcher_background, View.GONE);
                break;


        }
    }

    public void tests(View view) {
        test();
    }
}
