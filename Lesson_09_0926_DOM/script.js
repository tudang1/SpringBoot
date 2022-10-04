//bai 1
const tu = document.getElementById("text");
tu.style.color = '#777';
tu.style.fontSize = '32px';
document.getElementById("text").innerHTML = "Tôi có thể làm bất cứ điều gì tôi muốn với JavaScript."
//bai 2
const tu1 = document.getElementsByTagName("li");
for(let i=0;i<tu1.length;i++){
    tu1[i].style.color = "blue";
}
//bai3
const tu2 = document.querySelector("#text1");
const tu3 = document.querySelector("#btn");
tu3.addEventListener('click',()=>{
    tu2.classList.toggle('hide');
    tu2.classList.contains('hide')?tu3.innerHTML='show':tu3.innerHTML='hide';
})
//bai 1
const tu4 = document.getElementById("heading");
tu4.style.color = "red";
document.getElementById("heading").innerHTML = tu4.innerHTML.toUpperCase();
//bai2
const tu5 = document.getElementsByClassName('para');
for(let i=0;i<tu5.length;i++){
    tu5[i].style.color = "blue";
    tu5[i].style.fontSize = '20px';
}
//bai3

