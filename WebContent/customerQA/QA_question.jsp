<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrap">
    <div>
        <ul>
            <li><a href="#"><span>이용방법</span></a></li>
            <li><a href="#"><span>자주묻는질문</span></a></li>
            <li><a href="#"><span>파트너 등록 / 문의</span></a></li>
            <li><a href="#"><span>결제 / 취소 문의</span></a></li>
            <li><a href="#"><span>기타문의</span></a></li>
            <li><a href="#"><span>나의 문의 </span></a></li>
        </ul>
    </div>

    <section>
        <h2>1:1 문의하기</h2>
        <div>
            <form action="#" method="post">
                <ul>
                    <li>
                        <ul>
                            <li><strong>문의 유형</strong></li>
                            <li>
                                <select>
                                    <option>이용방법</option>
                                    <option>자주 묻는 질문</option>
                                    <option>파트너 등록 문의</option>
                                    <option>결제 취소 문의</option>
                                    <option>기타문의</option>
                                </select>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <ul class="question_input">
                            <li><strong>이메일 주소</strong></li>
                            <li><input type="text" name="user_email"/></li>
                        </ul>
                    </li>
                    <li>
                        <ul class="question_input">
                            <li><strong>제목</strong></li>
                            <li><input type="text" name="q_title"/></li>
                        </ul>
                    </li>
                    <li>
                        <ul class="question_input">
                            <li><strong>이름</strong></li>
                            <li><input type="text" name="user_name"/></li>
                        </ul>
                    </li>
                    <li>
                        <ul class="question_input">
                            <li><strong>전화번호</strong></li>
                            <li><input type="text" name="q_phone"/></li>
                        </ul>
                    </li>
                    <li>
                        <ul class="question_input">
                            <li><strong>예약번호</strong></li>
                            <li><input type="text" name="q_reservation_id"/></li>
                        </ul>
                    </li>
                    <li>
                        <ul class="question_input detail">
                            <li><strong>세부내용</strong></li>
                            <li><textarea name="q_content"></textarea></li>
                        </ul>
                    </li>
                </ul>
                <div class="qa_submit">
                    <input type="submit" value="문의하기">
                    <input type="reset" value="취소하기">
                </div>
            </form>
        </div>
    </section>
</div>
</body>
</html>