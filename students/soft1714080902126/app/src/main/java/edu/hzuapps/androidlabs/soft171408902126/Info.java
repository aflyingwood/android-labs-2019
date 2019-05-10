package edu.hzuapps.androidlabs.soft171408902126;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;




import java.util.ArrayList;
import java.util.List;

public class Info extends AppCompatActivity {
    private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);
        initMsgs();//初始化消息数据
        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        msgRecyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cotent = inputText.getText().toString();
                if (!"".equals(cotent)){
                    Msg msg = new Msg(cotent,Msg.TYPE_SENT);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size() - 1);//当有新消息时，刷新RecyclerView中的显示
                    msgRecyclerView.scrollToPosition(msgList.size() - 1);//将RecyclerView定位到最后一行
                    inputText.setText("");//清空输入框
                }
            }
        });

    }
    private void initMsgs(){
        Msg msg1 = new Msg("您好，欢迎来到我们饭馆" , Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("宫保鸡丁味道有点咸了" , Msg.TYPE_SENT);
        msgList.add(msg2);
        Msg msg3 = new Msg("不好意思，我们会改进的" , Msg.TYPE_RECEIVED);
        msgList.add(msg3);
        Msg msg4 = new Msg("感谢您为我们提出的宝贵建议" , Msg.TYPE_RECEIVED);
        msgList.add(msg4);

    }
}