<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
    <h2>레포츠 리스트 페이지</h2>
    <a href="#">레포츠</a>
    
    
    
    <div>
        <ul>
            <li><a href="#">전체</a></li>
            <li><a href="#">지상</a></li>
            <li><a href="#">수상</a></li>
            <li><a href="#">항공</a></li>
            <li><a href="#">실내</a></li>
        </ul>
    </div>

    <div>
        <ul>
            <li><a href="#">전체</a></li>
            <li><a href="#">서울</a></li>
            <li><a href="#">인천</a></li>
            <li><a href="#">경기</a></li>
            <li><a href="#">강원</a></li>
            <li><a href="#">충청</a></li>
            <li><a href="#">경상</a></li>
            <li><a href="#">부산</a></li>
            <li><a href="#">전라</a></li>
            <li><a href="#">기타</a></li>
        </ul>
    </div>

    <div>
        <select>
            <option>기본순</option>
            <option>가격 높은 순</option>
            <option>낮은 순</option>
            <option>리뷰 순</option>
        </select>
    </div>
     
    <div>
        <!-- list for문 돌려서 반복 출력 -->
        <a href="#">
           <div>
               <img src="#">
            </div>
            <div>
                <ul>
                    <li>상품 이름</li>
                    <li>한줄 설명</li>
                    <li>지역 </li>
                    <li>가격</li>
                </ul>
            </div>
        </a>
    </div>

</body>
</html>