package com.fisco.apiProject.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fisco.apiProject.dto.LeagueEntrydto;
import com.fisco.apiProject.dto.Summoner;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Controller
public class SearchSummoner {

	final static String API_KEY = "RGAPI-9bf90fed-bfed-4ee7-a79a-548649f22f16";
	
	@RequestMapping(value ="/search", method=RequestMethod.GET)
	public String searchSummoner(Model model, HttpServletRequest httpServletRequest) {
		BufferedReader br = null;
		String SummonerName = httpServletRequest.getParameter("title");
		Summoner temp = null;
		LeagueEntrydto leagueInfo = null;
		try {
			String urlstr = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" +
						SummonerName	+ "?api_key="+API_KEY;
			URL url = new URL(urlstr);
			HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
			urlConnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
			String result = "";
			String line;
			while((line = br.readLine()) != null) { // 받아온 문자열을 계속 br에서 줄단위로 받고 출력하겠다.
				result = result + line;
			}
			
			JsonParser jsonParser = new JsonParser();
			JsonObject k = (JsonObject)jsonParser.parse(result);
			int profileIconId = k.get("profileIconId").getAsInt();
			String name = k.get("name").getAsString();
			String puuid = k.get("puuid").getAsString();
			long summonerLevel = k.get("summonerLevel").getAsLong();
			long revisionDate = k.get("revisionDate").getAsLong();
			String id = k.get("id").getAsString();
			String accountId = k.get("accountId").getAsString();
			temp = new Summoner(profileIconId, name, puuid, summonerLevel, revisionDate, id, accountId);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			String urlstr = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/"+
						temp.getId() +"?api_key="+API_KEY;
			URL url = new URL(urlstr);
			HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
			urlConnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
			String result = "";
			String line;
			while((line = br.readLine()) != null) {
				result = result + line;
			}
			JsonParser jsonParser = new JsonParser();
			JsonArray arr = (JsonArray)jsonParser.parse(result);
			JsonObject k = (JsonObject)arr.get(0);
			int wins = k.get("wins").getAsInt();
			int losses = k.get("losses").getAsInt();
			String rank = k.get("rank").getAsString();
			String tier = k.get("tier").getAsString();
			String queueType = k.get("queueType").getAsString();
			int leaguePoints = k.get("leaguePoints").getAsInt();
			String leagueId = k.get("leagueId").getAsString();
			leagueInfo = new LeagueEntrydto(queueType, wins, losses, leagueId, rank, tier, leaguePoints);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
			model.addAttribute("summoner", temp);
			model.addAttribute("imgURL","http://ddragon.leagueoflegends.com/cdn/10.18.1/img/profileicon/"+temp.getProfileIconId()+".png");
			model.addAttribute("profileImgURL","http://ddragon.leagueoflegends.com/cdn/10.18.1/img/profileicon/"+temp.getProfileIconId()+".png");
			model.addAttribute("leagueInfo",leagueInfo);
			model.addAttribute("tierImgURL","img/emblems/Emblem_"+leagueInfo.getTier()+".png");
		
		return "result";
	}
}