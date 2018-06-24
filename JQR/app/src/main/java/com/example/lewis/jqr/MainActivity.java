package com.example.lewis.jqr;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_head;
    private RecyclerView recycler;
    private EditText et;
    private Button bt;
    private List<MesBean> list=new ArrayList<>();
    private ComAdapter<MesBean> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tv_head = (TextView) findViewById(R.id.tv_head);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        et = (EditText) findViewById(R.id.et);
        bt = (Button) findViewById(R.id.bt);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ComAdapter<>(list, R.layout.item, new ComAdapter.ConVert<MesBean>() {
            @Override
            public void convert(ComAdapter.ViewHolder holder, MesBean mesBean, int position) {
                LinearLayout ll_jq = (LinearLayout) holder.getView(R.id.ll_jq);
                LinearLayout ll_me = (LinearLayout) holder.getView(R.id.ll_me);
                TextView tv_jq = (TextView) holder.getView(R.id.tv_jq);
                TextView tv_me = (TextView) holder.getView(R.id.tv_me);

                if (mesBean.getType()==0){
                    ll_me.setVisibility(View.GONE);
                    tv_jq.setText(mesBean.getMes());
                }else {
                    ll_jq.setVisibility(View.GONE);
                    tv_me.setText(mesBean.getMes());
                }
            }
        });
        recycler.setAdapter(adapter);
        bt.setOnClickListener(this);
        tv_head.setText("旺旺客服");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String etString = et.getText().toString().trim();
        if (TextUtils.isEmpty(etString)) {
            Toast.makeText(this, "etString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

       send(etString);
        et.setText("");

    }

    private void send(String s) {
        if(s.contains("你好")){
            list.add(new MesBean(s,1));
            list.add(new MesBean("你好，欢迎光临",0));

        }else if (s.contains("包邮")){
            list.add(new MesBean(s,1));
            list.add(new MesBean("亲，对不起，不包邮的",0));
        }else if (s.contains("快递")){
            list.add(new MesBean(s,1));
            list.add(new MesBean("亲，我们仓库较多，具体发货地点根据您购买商品的实际库存地点来定，为您选择最佳的仓库发货哦；目前合作快递包括：百世快递、韵达、邮政、申通，活动期间不支持指定快递哦，还请您谅解呢。\n",0));
        }else if (s.contains("发货")){
            list.add(new MesBean(s,1));
            list.add(new MesBean("亲亲，6月1日0点-6月20日23:59当天17点前付款的订单正常情况下当天发出，超过的一般延后至次日发出，一般都会在72小时内按照付款顺序发出的哦！\n",0));
        }else if (s.contains("便宜")){
            list.add(new MesBean(s,1));
            list.add(new MesBean("1.天猫购物津贴300-30，可和店铺优惠券叠加使用，可跨店（需下单商品购物津贴满减金额一致），上不封顶；\n" +
                    "2.店铺下单满78-3  99-5  199-10 （需领券下单）；\n" +
                    "http://t.cn/R18sgEf\n" +
                    "\n" +
                    "（78-3）\n" +
                    "http://t.cn/R1Rvh1R\n" +
                    "\n" +
                    "（99-5）\n" +
                    "http://t.cn/R1Rvcoc\n" +
                    "\n" +
                    "（199-10）",0));
        }else if (s.contains("正品")){
            list.add(new MesBean(s,1));
            list.add(new MesBean("亲，所有东西正品保障",0));
        }else if (s.contains("售后")){
            list.add(new MesBean(s,1));
            list.add(new MesBean("7天无理由退换",0));
        }else if (s.contains("再见")){
            list.add(new MesBean(s,1));
            list.add(new MesBean("欢迎下次再来",0));
        }else if (s.contains("指定")){
            list.add(new MesBean(s,1));
            list.add(new MesBean("亲亲，如需果您需要指定快递或者不发哪个快递可以在买家留言进行留言或者联系人工客服进行备注，符合仓库发货规则会按照指定快递进行发货，无买家留言无客服备注的仓库按照收货地址随机快递发货哦\n",0));
        }else if (s.contains("链接")){
            list.add(new MesBean(s,1));
            list.add(new MesBean("https://detail.tmall.com/item.htm?spm=a1z10.10022-b-s.204.98.474b704cdLKxsT&id=562624516462",0));
        }else if (s.contains("时间")){
            list.add(new MesBean(s,1));
            list.add(new MesBean("发货后开始计算，一般是1-2天，江浙沪2-3天，其他地区5-7天，此时间仅供参考，具体到货时间请以当地快递情况而定！\n" +
                    "注：大促期间的订单将于72小时内安排发出\n",0));
        }else {
            list.add(new MesBean(s,1));
            list.add(new MesBean("亲，你的问题不在回答范围，请转人工客服，电话4000023",0));
        }
        adapter.notifyDataSetChanged();
    }
}
