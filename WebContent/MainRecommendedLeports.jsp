<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8" />
    <title>추천 레포츠</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />

    <!-- Link Swiper's CSS -->
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.css" />

    <style>
      .swiper-container {
        width: 100%;
        height: 300px;
      }

      .swiper-slide {
        text-align: center;
        font-size: 18px;
        background: grey;

        /* Center slide text vertically */
        display: -webkit-box;
        display: -ms-flexbox;
        display: -webkit-flex;
        display: flex;
        -webkit-box-pack: center;
        -ms-flex-pack: center;
        -webkit-justify-content: center;
        justify-content: center;
        -webkit-box-align: center;
        -ms-flex-align: center;
        -webkit-align-items: center;
        align-items: center;
      }

      .swiper-button-prev:after,
      .swiper-button-next:after {
        color: black;
      }

      .swiper-pagination-bullet-active {
        background-color: black;
      }
    </style>
  </head>

  <body>
    <div class="RECOMMENDED_LEPORTS_LIST">
      <div class="swiper-container">
        <div class="swiper-wrapper">
          <div class="swiper-slide">
            <a href="#"><img src="" />1</a>
          </div>
          <div class="swiper-slide">
            <a href="#"><img src="" />2</a>
          </div>
          <div class="swiper-slide">
            <a href="#"><img src="" />3</a>
          </div>
          <div class="swiper-slide">
            <a href="#"><img src="" />4</a>
          </div>
          <div class="swiper-slide">
            <a href="#"><img src="" />5</a>
          </div>
          <div class="swiper-slide">
            <a href="#"><img src="" />6</a>
          </div>
          <div class="swiper-slide">
            <a href="#"><img src="" />7</a>
          </div>
          <div class="swiper-slide">
            <a href="#"><img src="" />8</a>
          </div>
          <div class="swiper-slide">
            <a href="#"><img src="" />9</a>
          </div>
        </div>
        <div class="swiper-pagination"></div>
        <div class="swiper-button-next"></div>
        <div class="swiper-button-prev"></div>
      </div>
    </div>

    <script src="https://unpkg.com/swiper/swiper-bundle.js"></script>
    <script>
      var swiper = new Swiper('.swiper-container', {
        slidesPerView: 4,
        spaceBetween: 25,
        slidesPerGroup: 4,
        loop: true,
        loopFillGroupWithBlank: true,
        speed: 900,
        pagination: {
          el: '.swiper-pagination',
          clickable: true,
        },
        navigation: {
          nextEl: '.swiper-button-next',
          prevEl: '.swiper-button-prev',
        },
        autoplay: {
          delay: 3000,
        },
      });
    </script>
  </body>
</html>
