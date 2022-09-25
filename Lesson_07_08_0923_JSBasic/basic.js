let number = 10;
console.log(typeof number); 

function sayHello() {
    console.log("Xin chào các bạn");
}

sayHello();

console.log("bài 1");
let mark = 10;
if(mark >= 85){
    console.log("A");
}else if(70 <= mark && mark < 85){
    console.log("B");
}else if(mark >= 40 && mark <70){
    console.log("C");
}else {
    console.log("D");
}

console.log("bài 2");
let number1 = 2;
let number2 = 4;
if(number1 < number2){
    console.log(number2);
}else{
    console.log(number1);
}

console.log("bài 3")
function sosanh(number3){
    if(number3 < 0){
        console.log(`${number3} là số âm`);
    }else if(number3 >0){
        console.log(`${number3} là số dương`);
    }else {
        console.log(`${number3} là số 0`);
    }
}
sosanh(10);

console.log("Switch-case");
console.log("Bài 1");
function day(day){
    switch (day) {
        case 0: {
            console.log("Hôm nay là chủ nhật");
            break;
        }
        case 1: {
            console.log("Hôm nay là thứ 2");
            break;
        }
        case 2: {
            console.log("Hôm nay là thứ 3");
            break;
        }
        case 3: {
            console.log("Hôm nay là thứ 4");
            break;
        }
        case 4: {
            console.log("Hôm nay là thứ 5");
            break;
        }
        case 5: {
            console.log("Hôm nay là thứ 6");
            break;
        }
        case 6: {
            console.log("Hôm nay là thứ 7");
            break;
        }
        default: {
            console.log("dữ liêu k hợp lệ");
            break;
        }
    }
}
day(1);

console.log("Bài 2");
function month(number){
    let temp = (number - 1  ) / 3;
    switch (temp) {
        case 0: {
            console.log("Mùa Xuân");
            break;
        }
        case 1: {
            console.log("Mùa Hạ");
            break;
        }
        case 2: {
            console.log("Mùa Thu");
            break;
        }
        case 3: {
            console.log("Mùa Đông");
            break;
        }
        default: {
            console.log("dữ liêu k hợp lệ");
            break;
        }
    }
}
console.log(1/3);
console.log("For----")
console.log("bài 4")
function sum(){
    let temp = 0;
    for(let day = 0;day <= 100;day = day +1){
        if(day % 5 == 0){
            temp += day;
        }
    }
    console.log(temp);
    return temp;
}
sum();
console.log("bài 3")
function dupli(arr,numb){
    let chuoi = "";
    for(let i = 0; i < numb; i = i+1){
        chuoi += arr;
        if(i != numb -1){
            chuoi += `-`;
        }
    }
    console.log(chuoi);
}
dupli("tu",3);
console.log("bài 8")
function check(numbers){
    let temp = 0;
    for(let i = 2; i<= numbers; i++){
        for(let j = 2;j <= i; j++){
            if(i % j == 0){
                continue;
            }
            console.log(i);
            temp +=i;
        }
        
    }
    console.log(temp);
    return temp;
}
console.log("bài 2")
function arr(chuoi){

}
