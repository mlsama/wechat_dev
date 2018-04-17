package com.mlsama.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * desc:文本消息对象
 * author：mlsama
 * dataTime:2018/4/1514:32
 */
@Getter
@Setter
@Data
public class TextMessage extends Message {
    /**
     * @XStreamAlias
     *      指定这个属性在xml中的元素名称,XStream默认不会读取这个注解
     *      需要使用processAnnotations(Class class)方法声名从那个类去读
     */
    //文本消息内容
    @XStreamAlias("Content")
    private String content;



}
