package com.lxf.parser;

import lombok.Data;
import org.apache.ibatis.builder.xml.XMLMapperEntityResolver;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.parsing.XNode;
import org.apache.ibatis.parsing.XPathParser;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: lxf
 * @create: 2021-01-18 11:18
 * @description: mybaties 解析模块代码分析
 */
@Data
public class MybatiesParse {
    public static void main(String[] args) {
        String resource="mybatis-config.xml";
        try {
            InputStream in = Resources.getResourceAsStream(resource);
            XPathParser  parser= new XPathParser(in, true, null, new XMLMapperEntityResolver());
            XNode xNode=parser.evalNode("/configuration");
            XNode chldren= xNode.evalNode("settings");
            System.out.println(chldren);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
