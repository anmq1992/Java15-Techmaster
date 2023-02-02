// Ex1
function findMax(a){
    let max = a[0];
    for (let i = 0; i < a.length; i++){
        if (max < a[i]){
            max = a[i];
        }
    }
    return max;
}

// Ex2
function findMin(a){
    let min = a[0];
    for (let i = 0; i < a.length; i++){
        if (min > a[i]){
            min = a[i];
        }
    }
    return min;
}

// Ex3
function remainderArray(a){
    let b = [];
    for (let i = 0; i < a.length; i++){
        b.push(a[i] %2);
    }
    return b;
}

// Ex4
function repeatString(str){
    
    let b = [];
    let returnStr = "";
    for (let i = 0; i < 10; i++){
        b.push(a[i]);
    }
    for (let i = 0; i < b.length; i++){
        str += b[i];
    }
}

// Ex5
function repeatString2(str){
    
    let b = [];
    let returnStr = "";
    for (let i = 0; i < 9; i++){
        b.push(a[i] + "-");
    }
    b.push(a[i]);
    for (let i = 0; i < b.length; i++){
        str += b[i];
    }
}

// Array Exercise2
// Ex1
function checkElementExist(arr,e){
    for (let i = 0; i < arr.length; i++){
        if (arr[i] === e){
            return true;
        }
    }
    return false;    
}

// Ex2
function checkElementGreater(arr,b){
    let returnArr = [];
    for (let i = 0; i < arr.length; i++){
        if (arr[i] > b){
            returnArr.push(arr[i]);
        }
    }
    return returnArr;    
}
function randomHexCode(){
    let randomNumber = Math.random().toString(16);
    let randomString = "#" + randomNumber.slice(2, 10);
    return randomString;
}

// Ex3

console.log(randomHexCode());
// console.log("BT1");
// console.log("BT2");
// console.log("BT3");
// console.log("BT4");
// console.log("BT5");
// console.log("BT6");
// console.log("BT7");
// console.log("BT8");
// console.log("BT9");
