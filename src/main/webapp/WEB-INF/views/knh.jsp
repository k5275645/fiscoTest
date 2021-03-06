<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Upbit API Practice</title>
    <link rel="stylesheet" href="resources/css/knh.css" />
    <script
      src="https://use.fontawesome.com/releases/v5.15.3/js/all.js"
      data-auto-a11y="true"
    ></script>
  </head>
  <body>
    <div class="container">
        <nav class = "navbar">
          <div class="navbar__logo">
            <a href = "#">Upbit Api</a>
            <i class="fas fa-level-up-alt"></i>
          </div>
          <ul class="navbar__menu">
              <li><button class="KRW" id="btn">KRW</button></li>
              <li><button class="BTC" id="btn">BTC</button></li>
              <li><button class="USDT" id="btn">USDT</button></li>
          </ul>
          <ul class="navbar__icons">
            <li><a href="https://upbit.com/"><i class="fas fa-arrow-up"></i></a></li>
            <li><a href="https://kimp.ga/"><i class="fab fa-korvue"></i></a></li>
          </ul>
        </nav>
      <table class="interest-table">
        <thead>
          <tr>
            <th>관심</th>
            <th>korean_name</th>
            <th>시가</th>
            <th>고가</th>
            <th>저가</th>
            <th>현재가</th>
            <th>전일대비</th>
            <th>거래대금(일)</th>
          </tr>
        </thead>
        <tbody></tbody>
      </table>
      <table class="market-table">
        <thead>
          <tr>
            <th>관심</th>
            <th>korean_name</th>
            <th>시가</th>
            <th>고가</th>
            <th>저가</th>
            <th>현재가</th>
            <th>전일대비</th>
            <th>거래대금(일)</th>
          </tr>
        </thead>
        <tbody></tbody>
      </table>
    </div>
  </body>
  <script src="resources/js/knh.js"></script>
</html>



