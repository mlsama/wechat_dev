package com.mlsama.controller;

import com.mlsama.pojo.Constant;
import com.mlsama.pojo.TextMessage;
import com.mlsama.utils.EncryptUtil;
import com.mlsama.utils.MessageConvert;
import com.mlsama.utils.MessageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * desc:微信开发
 * author：mlsama
 * dataTime:2018/4/14 22:56
 */
@Controller
@Slf4j
@RequestMapping("/weixin_dev")
public class WeiXinDev {
    @Autowired
    private MessageConvert messageConvert;

    /**
     * 接受到微信后台通过get传来的数据,连接微信后台
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @ResponseBody
    @GetMapping
    public String connectWX(String signature,String timestamp,String nonce,String echostr){
        log.info("接受到微信后台传来的数据:signature={}",signature);
        String[] strings = {Constant.TOKEN,timestamp,nonce};
        //字典排序
        Arrays.sort(strings);
        //三个参数字符串拼接成一个字符串进行sha1加密
        StringBuilder sb = new StringBuilder();
        for (String s : strings){
            sb.append(s);
        }
        String sign = EncryptUtil.getSha1(sb.toString());
        if (signature.equals(sign)){
            log.info("校验成功.");
            return echostr;
        }
        return null;
    }

    /**
     * 接收微信后台通过post方式传过来的信息,并进行回复
     * @param request
     * @param response
     * @throws Exception
     */
    @PostMapping
    public void msgRecAndSend(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //从request中获取用户发来的XML消息
        Map<String, String> map = MessageUtil.xml2Map(request);
        log.info("用户发来的消息是:类型是:{},内容为:{}",map.get("MsgType"),map.get("Content"));
        //判断是否是文本消息
        if (Constant.MSGTYPE_TEXT.equals(map.get("MsgType"))){
            //返回消息给用户
            TextMessage textMessage = messageConvert.getTextMessage(map);
            //转为xml
            String send = MessageUtil.object2Xml(textMessage);
            log.info("返回的信息是:{}",send);
            //将信息写出
            PrintWriter out = response.getWriter();
            out.write(send);
        }else {

        }
    }

}
