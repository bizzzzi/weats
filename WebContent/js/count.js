let upBtn = document.querySelectorAll('.js_upBtn');
let dwBtn = document.querySelectorAll('.js_dwBtn');
let pCount = document.querySelectorAll('.js_pCount');

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
	if (pCount[i].value > 0) {
		pCount[i].value -= x;
	}
};

let up = (i, x) => {
	let pCountValue = Number(pCount[i].value);
	if (pCount[i].value < Number(maxPerson[i].value)) {
		pCountValue += x;
		pCount[i].value = pCountValue;
	}
};
