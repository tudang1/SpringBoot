console.log("bai 1");
function giaithua(number){
    let temp = 1;
    for(let i =1;i<= number;i++){
        temp = i*temp;
    }
    console.log(temp);
    console.log();
}
giaithua(5);

console.log("bai 2");
function daochuoi(arr){
    let temp =[];
    for(let i = arr.length - 1;i >=0;i--){
        temp += arr[i];
    }
    console.log(temp);
    console.log();
}
let arr ="hello";
daochuoi(arr);

console.log("bai 3");
function maquocgia(arr){
    switch(arr){
        case "VN":{
            console.log("Xin Chào");
            break;
        }
        case "EN":{
            console.log("Hello");
            break;
        }
        case "CH":{
            console.log("Nihao");
            break;
        }
        default :{
            console.log("Sai r");
            break;
        }
    }
}
maquocgia("CH");
console.log();
console.log("Bai 4");
function catchuoi(arr){
    if(arr.length >= 15){
        let temp = [];
        for(let i = 0;i<10;i++){
            temp += arr[i];
        }
        temp = `${temp}...`;
        console.log(temp);
        console.log();
    }else{
        console.log("độ dài chuỗi chưa đủ");
        console.log();
    }
}
catchuoi("xinchaocacbandenvoidanghongtu");
console.log("Bai 5");
function game(){
    var tu = ["Búa","Kéo","Bao"];
    let player = tu[Math.floor(Math.random()*3)];
    let computer = tu[Math.floor(Math.random()*3)];
    console.log(`player: ${player}`);
    console.log(`computer: ${computer}`);
    if(player == "Búa" && computer == "Kéo" ||
        player == "Kéo" && computer == "Bao" ||
        player == "Bao" && computer == "Búa" ){
            console.log("Player: Win");
    }else if(player == computer){
        console.log("Hòa");
    }else{
        console.log("Player: Lose");
    }
}
game();