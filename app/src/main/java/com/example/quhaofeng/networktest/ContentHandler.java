package com.example.quhaofeng.networktest;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Quhaofeng on 2016-3-24-0024.
 */
public class ContentHandler extends DefaultHandler {

    private String nodeName;

    private StringBuilder id;

    private StringBuilder name;

    private StringBuilder version;

    @Override
    public void startDocument() throws SAXException {
        id = new StringBuilder();
        name = new StringBuilder();
        version = new StringBuilder();
    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //记录当前的节点名
        nodeName = localName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("app".equals(localName)){
            Log.w("ContentHandler", "id is " + id.toString().trim());//trim()用来清除回车或者换行符之类的
            Log.w("ContentHandler", "name is " + name.toString().trim());
            Log.w("ContentHandler", "version is " + version.toString());
            //最后要将StringBulider清空掉
            id.setLength(0);
            name.setLength(0);
            version.setLength(0);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //根据当前的节点名进判断将内容添加到哪一个StringBuilder对象中
        if ("id".equals(nodeName)){
            id.append(ch, start, length);
        }else if("name".equals(nodeName)){
            name.append(ch, start, length);
        }else if("version".equals(nodeName)){
            version.append(ch, start, length);
        }
    }
}
