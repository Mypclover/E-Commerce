<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	  <div id="myCarousel" class="carousel slide">
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="" contenteditable="false"></li>
        <li data-target="#myCarousel" data-slide-to="1" class="active" contenteditable="false"></li>
        <li data-target="#myCarousel" data-slide-to="2" class="" contenteditable="false"></li>
    </ol>
    <div class="carousel-inner">
        <div class="item" style="">
             <img src="<c:url value="/resources/images/1.jpg" />" alt="Image 1">
            <!-- <div class="carousel-caption">
                <h4 class="">First Slide Title</h4>
                <p class="">
                   Description for First Slide, this First Slide.
                </p>
            </div> -->
        </div>
        <div class="item active">
            <img src="<c:url value="/resources/images/2.jpg" />" alt="Image 1">
            <!-- <div class="carousel-caption">
                <h4 class="">Second Slide Title</h4>

                <p class="">
                   Description for Second Slide, this is Second Slide.
                </p>
            </div> -->
        </div>
        <div class="item" style="">
            <img src="<c:url value="/resources/images/3.jpg" />" alt="Image 1">
           <!--  <div class="carousel-caption">
                <h4 class="">Third Slide Title</h4>

                            <p class="">
                   Description for Third Slide, this is Third Slide.
                </p>
            </div> -->
        </div>
    </div>    

    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left"></span>
    </a>

    <a class="right carousel-control" href="#myCarousel" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right"></span>
    </a>


</div>
</body>
</html>