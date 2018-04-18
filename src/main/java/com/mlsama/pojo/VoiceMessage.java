package com.mlsama.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * desc:语音类实体类
 * author：mlsama
 * dataTime:2018/4/18 23:37
 */
@Getter
@Setter
@Data
public class VoiceMessage extends Message {

    //MediaId	图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
    @XStreamAlias("MediaId")
    private String mediaId;

    //Format	语音格式，如amr，speex等
    @XStreamAlias("Format")
    private String format;
}
