package com.mlsama.utils;

import com.mlsama.pojo.Constant;
import com.mlsama.pojo.TextMessage;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * desc:消息对象转换为xml
 * author：mlsama
 * dataTime:2018/4/1723:37
 */
@Component
public class MessageConvert {

    public TextMessage getTextMessage(Map<String,String> map){
        //创建文本消息对象
        TextMessage textMessage = new TextMessage();
        textMessage.setToUserName(map.get("FromUserName"));
        textMessage.setFromUserName(map.get("ToUserName"));
        textMessage.setCreateTime(new Date().getTime());
        textMessage.setMsgType(Constant.MSGTYPE_TEXT);
        //回复的消息
        StringBuilder sb = new StringBuilder();
        if (Constant.MSG_1.equals(map.get("Content"))){
            sb.append("这是Java微信开发资料-~-");
        }
        else if (Constant.MSG_2.equals(map.get("Content"))){
            sb.append("这是python微信开发资料-~-");
        }
        else {
            sb.append("感谢您的关注!一起学习微信开发吧.\n")
            .append("1.Java微信开发资料\n")
            .append("2.python微信开发资料");
        }
        textMessage.setContent(sb.toString());
        textMessage.setMsgId(map.get("MsgId"));
        return textMessage;
    }
}
