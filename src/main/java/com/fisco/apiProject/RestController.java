package com.fisco.apiProject;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathException;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest/*")
public class RestController {
	
	@RequestMapping("findCovidArea")
	public String callAPIGetResult(HttpServletRequest request) throws IOException, SAXException, ParserConfigurationException, XPathExpressionException {
		String area = request.getParameter("area");
		String startDt = request.getParameter("startDt");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		factory.setNamespaceAware(true);
		
		DocumentBuilder builder;
		Document document = null;
		
		StringBuilder urlBuilder = new StringBuilder("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson");
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=sFe%2FxcyFTT5LpFdPa42JrJS%2BBtLBwaydmLJ82Uu55dUnn%2B2euY2SQ8e9i6nFiiRovNiHs0wBKhMNzgHuuTCpOA%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("sFe/xcyFTT5LpFdPa42JrJS+BtLBwaydmLJ82Uu55dUnn+2euY2SQ8e9i6nFiiRovNiHs0wBKhMNzgHuuTCpOA=="
        		, "UTF-8")); /*공공데이터포털에서 받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("startCreateDt","UTF-8") + "=" + URLEncoder.encode(startDt, "UTF-8")); /*검색할 생성일 범위의 시작*/
        urlBuilder.append("&" + URLEncoder.encode("endCreateDt","UTF-8") + "=" + URLEncoder.encode(startDt, "UTF-8")); /*검색할 생성일 범위의 종료*/
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("response code: "+conn.getResponseCode());
		BufferedReader br;
		 if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			 	br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	        	br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = br.readLine()) != null) {
	            sb.append(line);
	        }
	        br.close();
	        conn.disconnect();
	        
	        InputSource is = new InputSource(new StringReader(sb.toString()));
	        builder = factory.newDocumentBuilder();
	        document = builder.parse(is);
	        XPathFactory xPathFactory = XPathFactory.newInstance();
	        XPath xPath = xPathFactory.newXPath();
	        XPathExpression expression = xPath.compile("//items/item");
	        NodeList nodeList = (NodeList) expression.evaluate(document,XPathConstants.NODESET);
	        for (int i = 0; i < nodeList.getLength(); i++) {
                NodeList child = nodeList.item(i).getChildNodes();
                for (int j = 0; j < child.getLength(); j++) {
                    Node node = child.item(j);
                    System.out.println("현재 노드 이름 : " + node.getNodeName());
                    System.out.println("현재 노드 타입 : " + node.getNodeType());
                    System.out.println("현재 노드 값 : " + node.getTextContent());
                    System.out.println("현재 노드 네임스페이스 : " + node.getPrefix());
                    System.out.println("현재 노드의 다음 노드 : " + node.getNextSibling());
                    System.out.println("");
                }
            }


        return "hello";
	}
}
