package com.lxf;

import com.lxf.entity.Person;
import lombok.Data;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: lxf
 * @create: 2021-01-05 14:23
 * @description: xml读取相关demo
 */
@Data
class PersonHandle  extends DefaultHandler {
    private List<Person> list;
    private String tag;
    private  Person person=null;

    public List<Person> getList() {
        return list;
    }

    public void startDocument ()
            throws SAXException
    {
        super.startDocument();
        System.out.println("开始解析文档");
        list=new ArrayList<>();
    }
    public void endDocument ()
            throws SAXException
    {
        super.endDocument();
        System.out.println("结束解析文档.....");
    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
     if("person".equals(qName)){
         person=new Person();
     }
     tag=qName;
    }
    //每一个标签结束时调用
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if ("person".equals(qName)){
            list.add(person);
        }
        tag=null;
    }
    //当解析到标签中的内容的时候调用(换行也是文本内容)
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if(tag!=null){
            if ("name".equals(tag)){
                person.setName(new String(ch,start,length));
            }
            if ("age".equals(tag)){
                person.setAge(new Integer(new String(ch,start,length)));
            }
        }
    }
}
public class XMLdemo {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        xmlTest();
    }

    private static void xmlTest() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory sAXParserFactory=SAXParserFactory.newInstance();
        SAXParser parser = sAXParserFactory.newSAXParser();
        PersonHandle personHandle = new PersonHandle();
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("person.xml");
        parser.parse(resourceAsStream,personHandle);
        List<Person> persons = personHandle.getList();
        for(Person p:persons){
            System.out.println(p+",p");
        }
    }
}
