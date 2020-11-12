
let cBtn  = document.querySelectorAll(".re_comment_btn");
let cCont = document.querySelectorAll(".comment_cont");
let rdBox = document.querySelector(".recomment_cont");
let rcBtn = document.querySelector(".re_comment_submit");
let rcCont=$("textarea[name='trade_recomment']").val();
var user_id=$("input[name='re_user_id']").val();
var comment_id;
const trade_depth=$("input[name='re_trade_depth']").val();
const trade_id=$("input[name='trade_id']").val();

function reply(){
	$.ajax({
			url:"TradeCommentWrite",
			type:"post",
			dataType:"text",
			data:{
				user_id:user_id,
				trade_comment:$("textarea[name='trade_recomment']").val(),
				trade_comment_id:comment_id,
				trade_depth:$("input[name='re_trade_depth']").val(),
				trade_id:trade_id
			},
			success:function(data){
			},
			error:function(xhr,status,error){
				alert(error);
			}
		});
}


for(const x in cBtn){
	cBtn[x].addEventListener('click',function(){
		comment_id=cBtn[x].value;
		console.log(comment_id);
		cBtn[x].insertAdjacentHTML('afterend',getHtml(trade_id,comment_id,user_id));
		/*getHtml(trade_id,comment_id,user_id)*/
		
	})
}

function getHtml(trade_id,comment_id,user_id){
  var result = '';
  result += "<form class='recomment_cont' method='post' style='maring-left:20px;' >"+
	        		"<input type='hidden' name='re_trade_id' value='"+trade_id+"'>"+
	        		"<input type='hidden' name='re_trade_depth' value=1>"+
	        		"<input type='hidden' name='re_trade_comment_id' value='"+comment_id+"'>"+
	        		"<input type='hidden' name='re_user_id' value='"+user_id+"'>"+
	        		"<textarea name='trade_recomment' rows='5' cols='100'></textarea>"+
	        		"<button class='re_comment_submit' onclick='reply()'>답글2</button>"+
	        	"</form>";
 return result;
}


