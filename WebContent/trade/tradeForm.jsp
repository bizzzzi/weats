<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="#">
        <div class="radio">
            <label for="판매">판매</label>
            <input type="radio" name="trade_type" value="판매">
            <label for="대여">대여</label> 
            <input type="radio" name="trade_type" value="대여">
        </div>	
    
        <div id="img_preview"><img alt="" src="fff.png"></div>	
            
                
            <input type="file" name="trade_main_img" accept="image/*" multiple>
                <ul>
                    <li>
                        <label for="상품제목">상품제목</label>
                        <input type="text" name="trade_title">
                    </li>
                    <li>	
                        <label for="가격">가격</label>
                        <input type="text" name="trade_price">
                    </li>
                    <li>	
                        <label for="상품설명">상품설명</label>
                        <textarea rows="10" cols="50" name="trade_contents"></textarea>
                    </li>
                    <li>	
                        <label for="거래지역">거래지역</label>
                        <input type="text" name="trade_loc">
                    </li>
                    <li>	
                        <label for="연락처">연락처</label>
                        <input type="text" name="trade_phone">
                    </li>
                </ul>
            <input type="submit" value="상품등록">
        
    </form>	
</body>
</html>