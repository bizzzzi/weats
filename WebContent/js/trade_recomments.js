
var cBtn = document.querySelector(".re_comment_btn");
var rdBox = document.querySelector(".recomment_cont");
var rcBtn = document.querySelector(".re_comment_submit");
cBtn.addEventListener('click', () => {
		rdBox.style.display='block';
})


/*function alertRC(){
	alert("댓글달기")
}

rcBtn.addEventListener('click', alertRC)*/

var rcCont=$("textarea[name='trade_recomment']").val();
const user_id=$("input[name='re_user_id']").val();
const comment_id=$("input[name='trade_comment_id']").val();


	$(rcBtn).click(function(){
		$.ajax({
			url:"TradeReCommentWrite",
			type:"get",
			dataType:"text",
			data:{
				user_id:user_id,
				trade_comment:$("textarea[name='trade_recomment']").val(),
				trade_comment_id:comment_id
			},
			success:function(data){
				alert("완료");
				rdBox.style.display='none';
			},
			error:function(xhr,status,error){
				console.log($("textarea[name='trade_recomment']").val(),user_id,comment_id);
				alert('error');
			}
			
		});
		
		
	});
