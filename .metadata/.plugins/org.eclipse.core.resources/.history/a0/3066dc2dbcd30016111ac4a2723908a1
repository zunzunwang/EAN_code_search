package org.zzw.testEAN;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

class EanTask implements Callable {
	private String url;
    private String taskName;
    private String taskEanCode;
     
    public EanTask(String productName, String url) {
        this.taskName = productName;
        this.url = url;
    }

	public JSONObject call() throws Exception {
		// TODO Auto-generated method stub
//        System.out.println("Start look up task: "+taskName+".");
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Finish task: "+taskName+".");
		String tempTaskName = taskName.replaceAll("\\d+"," ");
		tempTaskName = tempTaskName.replaceAll(" +", " ");
		tempTaskName = tempTaskName.replaceAll(" ", "+");
		tempTaskName = tempTaskName.replaceAll("/", "%2F");
		url = url.replace("productName", tempTaskName);
//		HttpRequestor httprequestor = new HttpRequestor();
//		String result = httprequestor.doGet(url);
		//System.out.println(url);
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            SAXParserHandle handle = new SAXParserHandle();
            parser.parse(url, handle);
            JSONObject jsonObj = new JSONObject();//create json objet.
            JSONArray jsonArr = handle.getJsonArray();
            jsonObj.put(taskName, jsonArr);
    		return jsonObj;
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return null;

		
	}
}
