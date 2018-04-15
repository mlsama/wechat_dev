package com.mlsama.utils;

import com.mlsama.pojo.TextMessage;
import com.thoughtworks.xstream.XStream;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * desc:消息工具类
 * author：mlsama
 * dataTime:2018/4/1511:37
 */
@Slf4j
public class MessageUtil {
    /**
     * 把xml转为map
     * @param request
     * @return
     */
    public static Map<String,String> xml2Map(HttpServletRequest request){
        Map<String,String> map = new HashMap<>();
        try {
            SAXReader saxReader = new SAXReader();
            //从request中读取输入流
            Document document = saxReader.read(request.getInputStream());
            //获取根节点
            Element root = document.getRootElement();
            //获取所有节点
            List<Element> elements = root.elements();
            //遍历
            for (Element element : elements){
                map.put(element.getName(),element.getText());
            }
        }catch (Exception e){
            log.error("读取xml异常,e={}",e);
        }
        return map;
    }

    public static String object2Xml(Object object){
        if (object == null){
            log.info("转换的对象为空");
            return null;
        }
        XStream xStream = new XStream();
        //设置根标签名称
        xStream.alias("xml",object.getClass());
        //声明@XStreamAlias注解来源
        xStream.processAnnotations(object.getClass());
       return xStream.toXML(object);
    }

    public static void main(String[] args) {
        TextMessage textMessage = new TextMessage();
        textMessage.setToUserName("a");
        textMessage.setFromUserName("d");
        textMessage.setCreateTime(new Date().getTime());
        textMessage.setMsgType("u");
        textMessage.setMsgId("i");
        textMessage.setContent("您发是消息是");
        System.out.println(object2Xml(textMessage));
    }
}
