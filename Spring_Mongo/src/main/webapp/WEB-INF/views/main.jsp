<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/styles.css">
    <title>소상공인</title>
  </head>
  <body>
    <header>
        <nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand" href="#page-top">그래도</a>
                <button class="navbar-toggler text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="#contact">원본 데이터</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <!-- 포트폴리오 섹션 -->
    <section class="page-section portfolio" id="portfolio">
        <div class="container">
        	<br>
        	<br>
	       <div class="btn-group" role="group" aria-label="Button group with nested dropdown">
	  		<button type="button" class="btn btn-primary">연도 선택</button>
			  <div class="btn-group" role="group">
			    <button id="btnGroupDrop1" type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></button>
			    <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
			      <a class="dropdown-item" href="/mongo/main2014.do">2014</a>
			      <a class="dropdown-item" href="/mongo/main2015.do">2015</a>
			      <a class="dropdown-item" href="/mongo/main2016.do">2016</a>
			      <a class="dropdown-item" href="/mongo/main2017.do">2017</a>
			      <a class="dropdown-item" href="/mongo/main2018.do">2018</a>
			      <a class="dropdown-item" href="/mongo/main2019.do">2019</a>
			      <a class="dropdown-item" href="/mongo/main2020.do">2020</a>
			    </div>
			  </div>
			</div>          
        </div>
        <br>
        <br>
        <div class="container; overflow-scroll">
            <table class="table table-hover">
                <thead>
                    <tr class="table-success">
							<td>연도</td>
							<td>분기</td>
							<td>상권</td>
							<td>업종</td>
							<td>분기별 매출</td>
							<td>주중 매출</td>
							<td>주말 매출</td>
							<td>월요일 매출 금액</td>
							<td>화요일 매출 금액</td>
							<td>수요일 매출 금액</td>
							<td>목요일 매출 금액</td>
							<td>금요일 매출 금액</td>
							<td>토요일 매출 금액</td>
							<td>일요일 매출 금액</td>
							<td>00~06 시간대 매출 금액</td>
							<td>06~11 시간대 매출 금액</td>
							<td>11~14 시간대 매출 금액</td>
							<td>14~17 시간대 매출 금액</td>
							<td>17~21 시간대 매출 금액</td>
							<td>21~24 시간대 매출 금액</td>
							<td>점포수</td>
                     </tr>
                  </thead>
                  <tbody>           
                 	<c:forEach var="row" items="${map.items}">
						<tr class="table-active">
							<td>${row.year}</td>
							<td>${row.quarter}</td>
							<td>${row.commercial}</td>
							<td>${row.service}</td>
							<td>${row.quarter_sales}</td>
							<td>${row.weekday_sales}</td>
							<td>${row.weekend_sales}</td>							
							<td>${row.mon_sales}</td>
							<td>${row.tue_sales}</td>
							<td>${row.wed_sales}</td>
							<td>${row.thu_sales}</td>
							<td>${row.fri_sales}</td>
							<td>${row.sat_sales}</td>
							<td>${row.sun_sales}</td>
							<td>${row.sales_0006}</td>
							<td>${row.sales_0611}</td>
							<td>${row.sales_1114}</td>
							<td>${row.sales_1417}</td>
							<td>${row.sales_1721}</td>
							<td>${row.sales_2124}</td>
							<td>${row.store_count}</td>
						</tr>	
					</c:forEach>                   
            </table>
            </div>
        
    </section>  


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js@3.5.1/dist/chart.min.js"></script>
    <script src="css/scripts.js"></script>
  </body>
</html>