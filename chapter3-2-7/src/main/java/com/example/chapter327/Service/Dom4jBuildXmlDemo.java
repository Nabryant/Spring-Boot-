package com.example.chapter327.Service;

import com.example.chapter327.mapper.FeedChannelMapper;
import com.example.chapter327.mapper.FeedMapper;
import com.example.chapter327.model.FeedChannelEntity;
import com.example.chapter327.model.FeedEntity;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

/**
 * Author  : Nabryant
 * E-mail  :
 * Time    : 2018/3/12
 * Function:
 */

@Service
public class Dom4jBuildXmlDemo extends TimerTask{

    private static final String ROOT_ELEMENT = "urlset";
    private static final String URL_ELEMENT = "url";
    private static final String LOC_ELEMENT = "loc";
    private static final String LASTMOD_ELEMENT = "lastmod";
    private static final String CHANGEFREQ_ELEMENT = "changefreq";
    private static final String PRIORITY_ELEMENT = "priority";

    private String changeFrequ = "daily";
    private String homePriority = "1.0";
    private String channelPriority = "1.0";
    private String detailPriority = "0.8";

    @Autowired
    FeedMapper feedMapper;

    @Autowired
    FeedChannelMapper feedChannelMapper;

    @Override
    public void run() {
        buildXml();
    }

    public List <String> generateDetailURL () {

        List<String> urlList = new ArrayList<>();
        List<FeedEntity> feedList = feedMapper.findByReview((short)0);
        System.out.println(feedList.size());

        for (FeedEntity feed : feedList) {
            String url = "live.sohu.com/zhidao/" +  feed.getId() + ".html";
            urlList.add(url);
        }
        System.out.println("url num:" + urlList.size());
        return urlList;
    }

    public List<String> generateFeedChannelURL () {

        List<String> urlList = new ArrayList<>();
        List<FeedChannelEntity> feedChannelList = feedChannelMapper.findByStatus((short) 0);
        for (FeedChannelEntity feedChannel : feedChannelList) {

            String url = "live.sohu.com/zhidao/index/" + feedChannel.getId() + ".html";
            urlList.add(url);

        }

        return urlList;

    }

    public String generateHomeURL () {

        return "live.sohu.com/zhidao/index";

    }

    public void formatXMLFile (OutputFormat format) {

        //设置编码格式
        format.setEncoding("UTF-8");
        //是否产生xml文件头
        //outputFormat.setSuppressDeclaration(true);
        //是否设置换行
        format.setIndent(true);
        format.setIndent("    ");
        //设置换行
        format.setNewlines(true);


    }

    public void buildXml() {

        try {

            //创建Document
            Document document = DocumentHelper.createDocument();
            //添加节点信息
            Element rootElement = document.addElement(ROOT_ELEMENT, "http://www.sitemaps.org/schemas/sitemap/0.9");

            //可以继续添加子节点 也可指定内容

            Element urlElement = rootElement.addElement(URL_ELEMENT);

            String homeUrl = generateHomeURL();
            Element loc = urlElement.addElement(LOC_ELEMENT);
            loc.setText(homeUrl);

            Date dateMod = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Element lastMod = urlElement.addElement(LASTMOD_ELEMENT);
            lastMod.setText(simpleDateFormat.format(dateMod));

            Element changeFreq = urlElement.addElement(CHANGEFREQ_ELEMENT);
            changeFreq.setText(changeFrequ);

            Element priority = urlElement.addElement(PRIORITY_ELEMENT);
            priority.setText(homePriority);

            List<String> feedChannelUrlList = generateFeedChannelURL();
            for (String channelUrl :feedChannelUrlList) {

                Element element = rootElement.addElement(URL_ELEMENT);

                Element locElement = element.addElement(LOC_ELEMENT);
                locElement.setText(channelUrl);

                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Element lastModElement = element.addElement(LASTMOD_ELEMENT);
                lastModElement.setText(sdf.format(date));

                Element changeFreqElement = element.addElement(CHANGEFREQ_ELEMENT);
                changeFreqElement.setText(changeFrequ);

                Element priorityElement = element.addElement(PRIORITY_ELEMENT);
                priorityElement.setText(channelPriority);

            }

            List<String> detailUrlList = generateDetailURL();
            for (String detailUrl : detailUrlList) {

                Element element = rootElement.addElement(URL_ELEMENT);

                Element locElement = element.addElement(LOC_ELEMENT);
                locElement.setText(detailUrl);

                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Element lastModElement = element.addElement(LASTMOD_ELEMENT);
                lastModElement.setText(sdf.format(date));

                Element changeFreqElement = element.addElement(CHANGEFREQ_ELEMENT);
                changeFreqElement.setText(changeFrequ);

                Element priorityElement = element.addElement(PRIORITY_ELEMENT);
                priorityElement.setText("0.8");
            }

            //设置xml文件格式
            OutputFormat outputFormat = OutputFormat.createPrettyPrint();
            formatXMLFile(outputFormat);

            Writer fileWriter = new FileWriter("d:\\Nabryant\\module.xml");
            //专门写入文件的对象xmlwriter
            XMLWriter xmlWriter = new XMLWriter(fileWriter, outputFormat);
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();
            System.out.println("xml文档生成成功");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
