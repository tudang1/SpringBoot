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
 ];
function print(user){
    for (const key in user) {
        console.log(`${user[key].name} - ${user[key].grade} - ${user[key].sex}`);
    }
}
print(grades);

console.log("bai 1");
function timtb(arr){
    let temp = 0;

    for (const key in arr) {
        temp += arr[key].grade;
    }
    let tb = temp / arr.length;
    console.log(`Thứ hạng trung bình: ${tb}`);
}
timtb(grades);
console.log("bai 2");
function timNamtb(arr){
    let temp = 0;
    let count = 0;
    for (const key in arr) {
        if(arr[key].sex == "M" ){
            temp += arr[key].grade;
            count++;
        }
        
    }
    let tb = temp / count;
    console.log(`Thứ hạng trung bình của Nam: ${tb}`);
}
timNamtb(grades);
console.log("bai 3");
function timNutb(arr){
    let temp = 0;
    let count = 0;
    for (const key in arr) {
        if(arr[key].sex == "F" ){
            temp += arr[key].grade;
            count++;
        }
    }
    let tb = temp / count;
    console.log(`Thứ hạng trung bình của Nữ: ${tb}`);
}
timNutb(grades);
console.log("bai 4-5-6-7-8-9");
const filter1 = (arr,grade)=>{
    return arr.filter(item=>item.grade == grade);
}

function maxMin(arr){
    let Fmin = arr[1].grade;
    let Mmax = arr[0].grade;
    let Mmin = arr[0].grade;
    let Fmax = arr[1].grade;
    let min = arr[0].grade;
    let max = arr[0].grade;
    arr.forEach(item => {
        if(item.grade>Mmax && item.sex == "M") Mmax = item.grade;
        if(item.grade<Fmin && item.sex == "F") Fmin = item.grade;
        if(item.grade>Fmax && item.sex == "F") Fmax = item.grade;
        if(item.grade<Mmin && item.sex == "M") Mmin = item.grade;
        if(item.grade<min) min = item.grade;
        if(item.grade>max) max = item.grade;
    });
    console.log("Bạn Nam có thứ hạng cao nhất là:");
    console.log(filter1(arr,Mmax));
    console.log("Bạn Nam có thứ hạng thấp nhất là:");
    console.log(filter1(arr,Mmin));
    console.log("Bạn Nữ có thứ hạng thấp nhất là:");
    console.log(filter1(arr,Fmin));
    console.log("Bạn Nữ có thứ hạng cao nhất là:");
    console.log(filter1(arr,Fmax));
    console.log("Bạn có thứ hạng thấp nhất là:");
    console.log(filter1(arr,min));
    console.log("Bạn có thứ hạng cao nhất là:");
    console.log(filter1(arr,max));
}
maxMin(grades);
console.log("bai 10");
const filter2 = (arr,sex)=>{
    return arr.filter(item=>item.sex.includes(sex));
}
console.log(filter2(grades,'F'));
