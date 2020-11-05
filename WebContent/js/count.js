const test = document.getElementById('js_pCount');
let count = 1;

function up() {
	if (Number(test.value) > 0) {
		count += 1;
		test.value = count;
	}
};

function down() {
	if (Number(test.value) > 1) {
		count -= 1;
		test.value = count;
	}
};