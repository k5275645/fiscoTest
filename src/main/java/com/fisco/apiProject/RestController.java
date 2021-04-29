package com.fisco.apiProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fisco.apiProject.dto.Covid19ItemDTO;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest/*")
public class RestController {

	@RequestMapping(value = "findCovidArea", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	public Object callAPIGetResult(HttpServletRequest request)
			throws IOException, SAXException, ParserConfigurationException, XPathExpressionException {
		String area = request.getParameter("area");
		String startDt = request.getParameter("startDt");
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// namespace 지원하도록 설정
		factory.setNamespaceAware(true);
		DocumentBuilder builder;
		Document document = null;
		StringBuilder urlBuilder = new StringBuilder(
				"http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson");
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8")
				+ "=sFe%2FxcyFTT5LpFdPa42JrJS%2BBtLBwaydmLJ82Uu55dUnn%2B2euY2SQ8e9i6nFiiRovNiHs0wBKhMNzgHuuTCpOA%3D%3D"); //서비스키
		urlBuilder.append("&" + URLEncoder.encode("ServiceKey", "UTF-8") + "="
				+ URLEncoder.encode("sFe/xcyFTT5LpFdPa42JrJS+BtLBwaydmLJ82Uu55dUnn+2euY2SQ8e9i6nFiiRovNiHs0wBKhMNzgHuuTCpOA==","UTF-8")); /* 공공데이터포털에서 받은 인증키 */
		urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 페이지번호 */
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
				+ URLEncoder.encode("100", "UTF-8")); /* 한 페이지 결과 수 */
		urlBuilder.append("&" + URLEncoder.encode("startCreateDt", "UTF-8") + "="
				+ URLEncoder.encode(startDt, "UTF-8")); /* 검색할 생성일 범위의 시작 */
		urlBuilder.append("&" + URLEncoder.encode("endCreateDt", "UTF-8") + "="
				+ URLEncoder.encode(startDt, "UTF-8")); /* 검색할 생성일 범위의 종료 */
		URL url = new URL(urlBuilder.toString());
		// api 받아옴
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		
		
		BufferedReader br;
		Covid19ItemDTO resDTO = new Covid19ItemDTO();

		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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
		try {
			XPathExpression expression = xPath.compile("//items/item[gubun='" + area + "']");
			NodeList nodeList = (NodeList) expression.evaluate(document, XPathConstants.NODESET);
			NodeList child = nodeList.item(0).getChildNodes();
			for (int j = 0; j < child.getLength(); j++) {
				Node node = child.item(j);
				String nodeName = node.getNodeName();
				switch (nodeName) {
				case "createDt":
					resDTO.setCreateDt(node.getTextContent());
					break;
				case "deathCnt":
					resDTO.setDeathCnt(Integer.parseInt(node.getTextContent()));
					break;
				case "defCnt":
					resDTO.setDefCnt(Integer.parseInt(node.getTextContent()));
					break;
				case "gubun":
					resDTO.setGubun(node.getTextContent());
					break;
				case "gubunCn":
					resDTO.setGubunCn(node.getTextContent());
					break;
				case "gubunEn":
					resDTO.setGubunEn(node.getTextContent());
					break;
				case "incDec":
					resDTO.setIncDec(Integer.parseInt(node.getTextContent()));
					break;
				case "isolClearCnt":
					resDTO.setIsolClearCnt(Integer.parseInt(node.getTextContent()));
					break;
				case "isolIngCnt":
					resDTO.setIsolIngCnt(Integer.parseInt(node.getTextContent()));
					break;
				case "localOccCnt":
					resDTO.setLocalOccCnt(Integer.parseInt(node.getTextContent()));
					break;
				case "overFlowCnt":
					resDTO.setOverFlowCnt(Integer.parseInt(node.getTextContent()));
					break;
				case "qurRate":
					try {
						resDTO.setQurRate(Double.parseDouble(node.getTextContent()));
					} catch (Exception e) {
						resDTO.setQurRate(0);
					}
					break;
				case "seq":
					resDTO.setSeq(Integer.parseInt(node.getTextContent()));
					break;
				case "stdDay":
					resDTO.setStdDay(node.getTextContent());
					break;
				case "updateDt":
					resDTO.setUpdateDt(node.getTextContent());
					break;
				}
			}
		} catch (NullPointerException e) {
			System.out.println(e);
			return null;
		} 
		
		ObjectMapper obm = new ObjectMapper();
		return obm.writeValueAsString(resDTO);
	}
}
