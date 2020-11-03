<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 class="main_title">파트너 등록</h1>
  <hr>

  <div class="partner_form" id="partner">
    <form action="/partners" method="post">
      <div class="box">
        <div class="title">상호 이름*</div>
        <div class="sub_box">
          <div>
            <input type="text" name="c_name" class="c_name" placeholder="상호 이름을 입력해주세요.">
          </div>
        </div>
      </div>
      <div class="box">
        <div class="title">연락처*</div>
        <div class="sub_box">
          <div>
            <input type="text" name="c_phone" class="c_phone" size="23" maxlength="11" placeholder="하이픈(-)은 빼고 입력해주세요.">
          </div>
          <div class="comment">
            상시 가능한 연락처를 입력해주세요.
          </div>
        </div>
      </div>
      <div class="box">
        <div class="title">주소*</div>
        <div class="sub_box">
          <div>
            <input type="text" name="c_postnum" id="sample4_postcode" placeholder="우편번호">
            <input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
            <input type="text" name="c_address" id="sample4_roadAddress" placeholder="도로명주소"><br>
            <input type="text" name="c_detail_address" id="c_detail_address" placeholder="상세주소 입력">
          </div>
        </div>
      </div>
      <div class="box">
        <div class="title">사업자 등록번호*</div>
        <div class="sub_box">
          <input type="text" name="partner_license_num" class="partner_license_num" size="23" maxlength="10"
            placeholder="하이픈(-)은 빼고 입력해주세요.">
        </div>
      </div>
      <div class="box">
        <div class="title">서류 제출*</div>
        <div class="sub_box">
          <div class="guide_img">
            <img src="profile.png" alt="서류 제출 가이드 사진">
            <input id="image_upload" class="image_inputType_file" name="partner_license_docs"
              placeholder="하이픈(-)은 빼고 입력해주세요." type="file" accept="img/*" required multiple>
            <!-- file형태와 image만 업로드하도록 설정 -->
          </div>
          <div class="comment">
            사업자 등록증 사진을 업로드해주세요.<br>
            이미지 규격은 '*'을 권장합니다.
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