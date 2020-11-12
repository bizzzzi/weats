
var cBtn = document.querySelector(".re_comment_btn");
var rdBox = document.querySelector(".recomment_cont");
var rcBtn = document.querySelector(".re_comment_submit");
var rcCont=$("textarea[name='trade_recomment']").val();
const user_id=$("input[name='re_user_id']").val();
const comment_id=$("input[name='re_trade_comment_id']").val();
const trade_depth=$("input[name='re_trade_depth']").val();
const trade_id=$("input[name='re_trade_id']").val();

cBtn.addEventListener('click', () => {
		rdBox.style.display='block';
})


/*function alertRC(){
	alert("댓글달기")
}

rcBtn.addEventListener('click', alertRC)*/



	$(rcBtn).click(function(){
		$.ajax({
			url:"TradeCommentWrite",
			type:"get",
			dataType:"text",
			data:{
				user_id:user_id,
				trade_comment:$("textarea[name='trade_recomment']").val(),
				trade_comment_id:comment_id,
				trade_depth:trade_depth,
				trade_id:trade_id
			},
			success:function(data){
				console.log($("textarea[name='trade_recomment']").val(),user_id,comment_id,trade_depth);
				/*rdBox.style.display='none';*/
				/*return false;*/
				listReply()
			},
			error:function(xhr,status,error){
				console.log($("textarea[name='trade_recomment']").val(),user_id,comment_id,trade_depth);
				alert('error');
			}
		});
	});
	
	function listReply(){
    $.ajax({
        type: "get", //get방식으로 자료를 전달한다
        url: "${path}/reply/list.do?bno=${dto.bno}", //컨트롤러에 있는 list.do로 맵핑하고 게시판 번호도 같이 보낸다.
        success: function(result){ //자료를 보내는것이 성  공했을때 출력되는 메시지
            //result : responseText 응답텍스트(html)
            $("#listReply").html(result);
        }
    });
}

