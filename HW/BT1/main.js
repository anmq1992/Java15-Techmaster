// B1
function calculateFactorial(num){
    let result = 1;
    for(let i = 1; i <= num; i++){
        result *= i
    }
    return result;
}

//B2
function reverseString(str){
    let result = '';
    for(let i = str.length -1 ; i >= 0; i--){
        result += str[i];
    }
    return result;x
}

//B3
function translate(country){
    switch (country){
        case 'VN':{
            console.log("Xin Chao");
            break;
        }
        case 'EN':{
            console.log("Hello");
            break;
        }
        case 'SP':{
            console.log("Hola");
            break;
        }
        case 'DE': {
            console.log("Halo");
            break;
        }
        case 'JP': {
            console.log("Konichiwa");
            break;
        }
        default: {
            console.log("Hello");
            break;
        }
    }
}

function subString(str){
    return (str.slice(0,10) + "...");
}



console.log(calculateFactorial(5));
console.log(reverseString("hello"));
translate("VN");
translate("JP");
console.log(subString("xinchaocacbandenvoiTechmaster"));