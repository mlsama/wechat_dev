package com.mlsama.utils;

import com.mlsama.pojo.Constant;
import com.mlsama.pojo.TextMessage;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * desc:消息对象转换为xml
 * author：mlsama
 * dataTime:2018/4/1723:37
 */
@Component
public class MessageConvert {

    public TextMessage getTextMessage(String fromUserName,String toUserName,
                                       String msgId,String content){
        //创建文本消息对象
        TextMessage textMessage = new TextMessage();
        textMessage.setToUserName(fromUserName);
        textMessage.setFromUserName(toUserName);
        textMessage.setCreateTime(new Date().getTime());
        textMessage.setMsgType(Constant.MSGTYPE_TEXT);
        //回复的消息
        StringBuilder sb = new StringBuilder();
        if (Constant.MSG_1.equals(content)){
            sb.append("这是Java开发资料");
        }
        else if (Constant.MSG_2.equals(content)){
            sb.append("这是python开发资料");
        }
        else {
            sb.append("感谢您的关注!一起学习微信开发吧.\n")
            .append("1.Java开发资料\n")
            .append("2.python开发资料");
        }
        textMessage.setContent(sb.toString());
        textMessage.setMsgId(msgId);
        return textMessage;
    }
}
