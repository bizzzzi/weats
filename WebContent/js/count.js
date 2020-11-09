let upBtn = document.querySelectorAll('.js_upBtn');
let dwBtn = document.querySelectorAll('.js_dwBtn');
let pCount = document.querySelectorAll('.js_pCount');
let selectItem = document.querySelectorAll('.js_selectItem');
let selectItemPrice;
let totalAmount = document.querySelector(".js_total_amount");
let price = 0;

// 아이템 이름
let itemName = document.querySelectorAll('.js_itemName');
// 최대 인원
let maxPerson = document.querySelectorAll('.js_maxPerson');
// 아이템 가격
let itemPrice = document.querySelectorAll('.js_itemPrice');

for (let i = 0; i < dwBtn.length; i++) {
	dwBtn[i].addEventListener('click', () => down(i, 1));
    upBtn[i].addEventListener('click', () => up(i, 1));
}

let down = (i, x) => {
	if (pCount[i].value >= 1) {
		pCount[i].value -= x;
		selectItem[i].innerHTML = `<div class="select_items_option${[i]}">
		   	<div>${itemName[i].value}</div>
		   	<div>
		   		<div>${pCount[i].value} X ${itemPrice[i].value}원</div>
				<div class="select_item_price">${pCount[i].value * itemPrice[i].value}</div>
			</div>
		   </div>`;
		selectItemPrice = document.querySelectorAll('.select_item_price');
		price -= Number(itemPrice[i].value);
		totalAmount.innerText = price;
	} else {
        selectItem[i].innerHTML = "";
        totalAmount.innerText = "";
	}
	
};

let up = (i, x) => {
	let pCountValue = Number(pCount[i].value);
	if (pCount[i].value < Number(maxPerson[i].value)) {
		pCountValue += x;
		pCount[i].value = pCountValue;
		selectItem[i].innerHTML = `<div class="select_items_option${[i]}">
		   							<div>${itemName[i].value}</div>
		   							<div>
		   								<div>${pCount[i].value} X ${itemPrice[i].value}원</div>
										<div class="select_item_price">${pCount[i].value * itemPrice[i].value}</div>
									</div>
								   </div>`;
		selectItemPrice = document.querySelectorAll('.select_item_price');
		price += Number(itemPrice[i].value);
		totalAmount.innerText = price;
	}
};

