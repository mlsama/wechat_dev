package com.mlsama.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * desc:消息实体类父类
 * author：mlsama
 * dataTime:2018/4/1723:17
 */
@Getter
@Setter
@Data
public class Message implements Serializable {

    /**
     * @XStreamAlias
     *      指定这个属性在xml中的元素名称,XStream默认不会读取这个注解
     *      需要使用processAnnotations(Class class)方法声名从那个类去读
     */
    @XStreamAlias("ToUserName")
    //开发者微信号
    private String toUserName;

    //发送方帐号
    @XStreamAlias("FromUserName")
    private String fromUserName;

    //消息创建时间 （整型）
    @XStreamAlias("CreateTime")
    private Long createTime;

    //文本消息类型
    @XStreamAlias("MsgType")
    private String msgType;

    //消息id，64位整型
    @XStreamAlias("MsgId")
    private String msgId;
}
