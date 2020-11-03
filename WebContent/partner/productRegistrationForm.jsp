<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 class="main_title">상품 등록</h1>
  <hr>

  <div class="partner_registration_form">
    <form action="/partners" method="post">
      <div class="box">
        <div class="title">상품 이름</div>
        <div class="sub_box">
          <div>
            <input type="text" name="leports_title" class="leports_title" placeholder="ex) 서핑강습 2시간">
          </div>
        </div>
      </div>
      <div class="box">
        <div class="title">한줄 요약</div>
        <div class="sub_box">
          <div>
            <input type="text" name="leports_summary" class="leports_summary" placeholder="ex) 강습시간: 9:30~11:30">
          </div>
        </div>
      </div>
      <div class="box">
        <div class="title">상품 소개</div>
        <div class="sub_box">
          <div>
            <textarea name="leports_content" class="leports_content" cols="30" rows="10"></textarea>
          </div>
        </div>
      </div>

      <div class="box">
        <div class="title">대표 사진</div>
        <div class="sub_box">
          <div>
            <input class="leports_main_img" name="leports_main_img" type="file" accept="img/*" required multiple>
          </div>
        </div>
      </div>
      <div class="box">
        <div class="title">서브 사진</div>
        <div class="sub_box">
          <div>
            <input class="leports_sub_img1" name="leports_sub_img1" type="file" accept="img/*" required multiple>
          </div>
          <div>
            <input class="leports_sub_img2" name="leports_sub_img2" type="file" accept="img/*" required multiple>
          </div>
          <div>
            <input class="leports_sub_img3" name="leports_sub_img3" type="file" accept="img/*" required multiple>
          </div>
        </div>
      </div>
      <div class="box">
        <div class="title">지역 카테고리</div>
        <div class="sub_box">
          <div>
            <select name="leports_loc" class="leports_loc">
              <option value="서울">서울</option>
              <option value="부산">부산</option>
              <option value="인천">인천</option>
              <option value="경기">경기</option>
              <option value="강원">강원</option>
              <option value="충청">충청</option>
              <option value="전라도">전라도</option>
              <option value="경상도">경상도</option>
              <option value="기타">기타</option>
            </select>
          </div>
        </div>
      </div>
      <div class="box">
        <div class="title">레포츠 카테고리</div>
        <div class="sub_box">
          <div>
            <select name="leports_type" class="leports_type">
              <option value="지상 레포츠">지상 레포츠</option>
              <option value="수상 레포츠">수상 레포츠</option>
              <option value="항공 레포츠">항공 레포츠</option>
              <option value="실내 레포츠">실내 레포츠</option>
            </select>
          </div>
        </div>
      </div>
      <div class="box">
        <div class="title">가격(원)</div>
        <div class="sub_box">
          <div>
            <input type="text" name="leports_price" class="leports_price" placeholder="숫자만 입력해주세요.">
          </div>
        </div>
      </div>
      <div class="box">
        <div class="title">최대 수용 인원</div>
        <div class="sub_box">
          <div>
            <input type="number" name="leports_max_capacity" class="leports_max_capacity" placeholder="숫자만 입력해주세요.">
          </div>
        </div>
      </div>
      <div>아래 버튼을 선택하면 개인정보 동의 및 파트너 약관에 동의하는 것입니다.</div>
      <div class="Btn">
        <button class="submitBtn" type="submit">확인 및 제출</button>
      </div>
    </form>
  </div>
</body>
</html>