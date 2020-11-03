<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
    *{
        padding: 0;margin: 0;
        box-sizing: border-box;
    }
    body{
        width: 100%;
        min-height: 100vh;

    }
    section{
        width: fit-content;
        margin: 40px auto;
    }
    .products_info{
        width: 80%;
        display: flex;
        align-items: center;
        border: 2px solid rgb(201, 225, 235);
        border-radius: 50px;
        position: relative;
        margin: auto;
    }
    .imgframe{
        width: 300px;
        height: 300px;
        margin: 30px 50px;
        overflow: hidden;
    }
    .trade_img{
        display: flex;
    }
    .trade_img li{
        list-style: none;
    }
    .text_info{
        width: 50%;
        margin: inherit;
    }
    .text_info ul{
        width: fit-content;

    }
    .text_info li{
        list-style: none;
        padding: 30px;
    }
    .comment{
       width: 100%;
       text-align: center;
       margin-top: 10%;

    }
    .contentsdiv{
        width: 50%;
        position: relative;
        top: 40px;
        left: 15%;
        

    }

</style>
</head>


<body>
	

    <section>
        <!-- 상품상세정보 -->
        <div class="products_info">
            <div class="imgframe">
                <ul class="trade_img">
                    <li><img class="trade_main_img" src="fff.png"></li>
                    <li><img class="trade_sub_img1" src="fff.png"></li>
                    <li><img class="trade_sub_img2" src="fff.png"></li>
                    <li><img class="trade_sub_img3" src="fff.png"></li>
                    <li><img class="trade_sub_img4" src="fff.png"></li>
                </ul>
            </div>
            <div class="text_info">
                <ul>
                    <li>trade_regidate</li>
                    <li>title</li>
                    <li>price</li>
                    <li>phone</li>
                    <li>username</li>
                </ul>
            </div>
        </div>
        <div class="contentsdiv">
            <h2>상품설명</h2><br>
            <p class="trade_contents">Lorem ipsum dolor, sit amet consectetur adipisic
                ing elit. Consectetur optio ad unde alias eaque quaerat, lib
                ero ratione minus officiis hic laboriosam repellat, quidem cum solut
                a eveniet. Laudantium tempora quae maiores.
            </p>
        </div>  

        <!-- 댓글 -->
        <div class="comment">
            <textarea name="trade_comment" cols="100" rows="5"></textarea>
            <input type="button" value="댓글입력">  
        </div>
        <div class="trade_comment_list"></div> 
    </section>
</body>
</html>