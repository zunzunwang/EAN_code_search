package org.zzw.testEAN;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class SAXParserHandle extends DefaultHandler {
	private JSONArray jsonArr = new JSONArray();//json array.
	private JSONObject jsonObjArr = new JSONObject(); 
	private String temp_element;
	private String temp_element_value;
	private String temp_barcode;
	private String temp_barcode_value;
	private int index_product = 0;
	
    /*
     * begin Analysis.
     * @see org.xml.sax.helpers.DefaultHandler#startDocument()
     */
    @Override
    public void startDocument() throws SAXException {
        // TODO Auto-generated method stub
        super.startDocument();
        //System.out.println("----begin Analysis----");
    }

    /*
     * Analysis end.
     * @see org.xml.sax.helpers.DefaultHandler#endDocument()
     */
    @Override
    public void endDocument() throws SAXException {
        // TODO Auto-generated method stub
        super.endDocument();
        //System.out.println("----Analysis end----");
    }

    /*
     *Analyse XML elements.
     * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
     */
    @Override
    public void startElement(String arg0, String arg1, String name,
            Attributes attributes) throws SAXException {
        // TODO Auto-generated method stub
        super.startElement(arg0, arg1, name, attributes);
        if(name.equals("products")){     	
            //System.out.println("==========begin analyse a product==========");
            int length = attributes.getLength();
            for(int i=0;i<length;i++){
            	//System.out.print("attribute："+attributes.getQName(i));
                //System.out.println("---value:"+attributes.getValue(i));
                if(attributes.getQName(i).equals("id")){
                	temp_barcode = attributes.getQName(i);
                	temp_barcode_value = attributes.getValue(i);
                	jsonObjArr.put(temp_barcode,temp_barcode_value);
                	break;
                }
            }
        }else if(!name.equals("products") && !name.equals("opt")){
            //System.out.print("element："+ name);
            temp_element = name;
        }
    }

    @Override
    public void endElement(String arg0, String arg1, String name)
            throws SAXException {
        // TODO Auto-generated method stub
        super.endElement(arg0, arg1, name);
        if(name.equals("products")){
            //System.out.println("==========end of analysis product==========");
        	//save the last product.
        	jsonArr.put(index_product,jsonObjArr);
        	jsonObjArr = new JSONObject();
        	index_product++;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // TODO Auto-generated method stub
        super.characters(ch, start, length);
        String nodeValue = new String(ch, start, length);
        if(!nodeValue.trim().equals("")){
            //System.out.println("---value："+nodeValue);
            temp_element_value = nodeValue;
            jsonObjArr.put(temp_element,temp_element_value);
        }
    }
    public JSONArray getJsonArray(){
    	return jsonArr;
    }
}