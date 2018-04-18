package com.mlsama.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * desc:图片类实体类
 * author：mlsama
 * dataTime:2018/4/18 23:27
 */
@Getter
@Setter
@Data
public class ImageMessage extends Message {

    //PicUrl	图片链接（由系统生成）
    @XStreamAlias("PicUrl")
    private String picUrl;

    //MediaId	图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
    @XStreamAlias("MediaId")
    private String mediaId;
}
