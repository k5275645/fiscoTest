<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>${summoner.name}님의 전적정보</title>
</head>
<body>
	<div>
		<div>
		<h1>${summoner.name}님</h1>
		</div>
		
		<div>
			<img alt="아이콘" src=${profileImgURL }>
		
		</div>
		
		<div>
			getName<p>${summoner.getName() }</p>
		</div>
		
		<div>
			<p>${summoner.getProfileIconId() }</p>
		</div>
		
		<div>
			<p>${summoner.getName() }</p>
		</div>
		
		<div>
			<p>${summoner.getPuuid() }</p>
		</div>
		
		<div>		
			<p>${summoner.getSummonerLevel()}</p>
		</div>
		
		<div>		
			<p>${summoner.getRevisionDate()}</p>
		</div>
		
		<div>		
			<p>${summoner.getId()}</p>
		</div>
		
		<div>		
			<p>${summoner.getAccountId()}</p>
		</div>
		
		<h2>
		LeagueInfo
		</h2>
		
		<div>
			<p>${ leagueInfo.getQueueType()}</p>
		</div>
		
		<div>
			<p>${ leagueInfo.getQueueType()}</p>
		</div>
		
		<div>
			<p>Wins : ${ leagueInfo.getWins()}</p>
		</div>
		
		<div>
			<p>Losses : ${ leagueInfo.getLosses()}</p>
		</div>
		
		<div>
			<p>LeagueId : ${ leagueInfo.getLeagueId()}</p>
		</div>
		
		<div>
			<p>Rank : ${ leagueInfo.getRank()}</p>
		</div>
		
		<div>
			<p>Tier : ${ leagueInfo.getTier()}</p>
		</div>
		
		<div>
			<p>LeaguePoints : ${ leagueInfo.getLeaguePoints()}</p>
		</div>
		<h2>
		Emblem
		</h2>
		
		
	</div>
</body>
</html>