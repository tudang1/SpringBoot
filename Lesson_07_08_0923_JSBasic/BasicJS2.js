console.log("Bai 1");
function check(arr,number){
    for(let i =0; i < arr.length;i++){
        if(arr[i] == number){
            return true;
        }
        
    }
    return false;
}
//note
const checkelemenExist = (arr,num) => arr.includes(num)?true:false;
console.log(checkelemenExist([1,3,4],2));

let  arr = [1,2,3,3];
console.log(check(arr,3));
console.log("Bai 2");
function push(arrs,number){
    let temp = [];
    for(let i =0; i <arrs.length;i++){
        if(arrs[i] > number){
            temp.push(arrs[i]);
        }
    }
    return temp;
}
console.log(push(arr,1));

console.log("bai 3")
const random_hex_color_code = () => {
    let n = (Math.random() * 0xfffff * 1000000).toString(16);
    return '#' + n.slice(0, 6);
  };
console.log(random_hex_color_code());
  
console.log("bai 4");
const randomRGB = () =>{
    const random = () => Math.floor(Math.random()*255);
    return `rgb(${random()},${random()},${random()})`;
};
let student = {
    name: "Nguyễn Văn A",
    age: 19,
    email: "nguyenvana@gmail.com"
}
console.log(Object.keys(student));
console.log(Object.values(student));
// Ví dụ: In ra tất cả các giá trị (value) của lần lượt các thuộc tính (property) của Object user
let keys = Object.keys(student);
for (let i = 0; i < keys.length; i++) {
    console.log(student[keys[i]]);
}
let products = [
    {
        name: "Iphone 13 Pro Max", // Tên sản phẩm
        price: 3000000, // Giá mỗi sản phẩm
        brand: "Apple", // Thương hiệu
        count: 2, // Số lượng sản phẩm trong giỏ hàng
    },
    {
        name: "Samsung Galaxy Z Fold3",
        price: 41000000,
        brand: "Samsung",
        count: 1,
    },
    {
        name: "IPhone 11",
        price: 15500000,
        brand: "Apple",
        count: 1,
    },
    {
        name: "OPPO Find X3 Pro",
        price: 19500000,
        brand: "OPPO",
        count: 3,
    },

]

console.log("bai1");
function print(user){
    for (const key in user) {
        console.log(`${user[key].name} - ${user[key].price} - ${user[key].brand} - ${user[key].count}`);
    }
}
print(products);
console.log("bai2. Tính tổng tiền tất cả sản phẩm trong giỏ hàng");
function sum(user){
    let temp = 0;
    for (const key in user) {
        temp += user[key].price * user[key].count;
    }
    console.log(temp);
}
sum(products);

const grades = [
    {name: 'John', grade: 8, sex: 'M'},
    {name: 'Sarah', grade: 12, sex: 'F'},
    {name: 'Bob', grade: 16, sex: 'M'},
    {name: 'Johnny', grade: 2, sex: 'M'},
    {name: 'Ethan', grade: 4, sex: 'M'},
    {name: 'Paula', grade: 18, sex: 'F'},
    {name: 'Donald', grade: 5, sex: 'M'},
    {name: 'Jennifer', grade: 13, sex: 'F'},
    {name: 'Courtney', grade: 15, sex: 'F'},
    {name: 'Jane', grade: 9, sex: 'F'}
   ]
console.log();
console.log("bai 1");
function timtb(arr){
    let temp = 0;

    for (const key in arr) {
        temp += arr[key].grade;
    }
    let tb = temp / arr.length
    console.log(tb);
}
timtb(grades);
