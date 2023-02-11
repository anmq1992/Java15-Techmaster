// Bài 1. Viết function truyền vào mảng các chuỗi có độ dài bất kỳ. Kết quả trả về là 1 mảng các chuỗi có độ dài lớn nhất

//getStringHasMaxLength(['aba', 'aa', 'ad', 'c', 'vcd']) => ['aba', 'vcd'].

function getStringHasMaxLength (arr){
    let returnArray = [];
    let max = 0;
    for (const ele of arr){
        if (ele.length > max){
            max = ele.length;
        }
    }
    console.log(max);

    for (let i =0; i < arr.length; i++){
        if (arr[i].length == max){
            returnArray.push(arr[i]);
        }
    }
    return returnArray;
}

// Bai 2 . 
/*Viết function truyền vào 1 mảng các object user. Trả về mảng các user có age > 25 và isStatus = true
Viết function truyền vào 1 mảng các object user. Trả về mảng các user có age tăng dần*/ 

users = [
    {
        name: "Bùi Công Sơn",
        age: 30,
        isStatus: true
    },
    {
        name: "Nguyễn Thu Hằng",
        age: 27,
        isStatus: false
    },
    {
        name: "Phạm Văn Dũng",
        age: 20,
        isStatus: false
    }
]
function findUser1(users){
    let returnArr = [];
    for (const user of users){
        if (user.age > 25 && user.isStatus == true){
            returnArr.push(user); 
        }
    }
    return returnArr;
}

function findUser2(users){
    let user2 = users.sort(compareFn);
    return user2;
}

function compareFn (user1, user2){
    return user1.age - user2.age;
}

// Bài 3. Viết function truyền vào 1 mảng các chuỗi. Trả về Object hiển thị xem mỗi phần tử trong mảng xuất hiện bao nhiêu lần

function getCountElement(arr){
    let returnObj = {};
    let count = 0;  
    for (const ele of arr){
        if (returnObj.hasOwnProperty(ele) == true){
            returnObj[ele] = returnObj[ele] +1;
        }else{
            returnObj[ele] = 1;
        }
    }
    console.log('My object: ', returnObj);
    return returnObj;

}



console.log(getStringHasMaxLength(['aba', 'aa', 'ad', 'c', 'vcd']));
console.log(findUser1(users));
console.log(findUser2(users));
console.log(getCountElement(["one", "two", "three", "one", "one", "three"]));