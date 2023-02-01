// Ex1
function repeatString(s){
    return s.repeat(10);
}

// Ex2
function repeatStringDash(s){
    let sDash = s;
    sDash += '-';
    console.log(sDash);
    let sReturn =  sDash.repeat(9);
    sReturn = sReturn + s;
    return sReturn;
}

// Ex3
function repeatStringDash(s,n){
    let sDash = s + '-';
    let sReturn =  sDash.repeat(n-1);
    sReturn = sReturn + s;
    return sReturn;
}

// Ex4
function sum5(){
    let sum = 0;
    for (let i =  0; i <= 100; i++){
        if (i % 5 == 0){
            sum += i ;
        }
    }
    return sum;
}

// Ex5
function sphereVolume(r){
    return 4/3 * Math.PI * Math.pow(r,3);
}

//Ex6
function sum(a,b){
    if (a >= b){
        return 0
    }
    let sum = 0 ;
    for (let i = a+1; i < b; i++){
        sum +=i;
    }
    return sum;
}

//Ex7
function isPrime(a){
    if (a <= 1 ) {
        return false;
    }
    if ( a == 2){
        return true;
    }
    let count = 0;
    for (let i = 2; i <= a/2; i++){
        if (a % i == 0){
            count += 1;
        } 
    }
    if (count == 0) {
        return true;
    }
    return false;
}

//Ex8
function primeSum(a){
    let sum  = 0;
    for (let i = 0; i <= a ; i++){
        if (isPrime(i) == true){
            // console.log(i);
            sum += i;
        }
    }
    return sum;
}

//Ex9
function sumProduct(a){
    let sum  = 0;
    for (let i = 0; i <= a;i++ ){
        if (a %i == 0){
            sum += i;
        }
    }
    return sum;
}
console.log("BT1");
console.log(repeatString("a"));
console.log("BT2");
console.log(repeatStringDash("a"));
console.log("BT3");
console.log(repeatStringDash("a",5));
console.log("BT4");
console.log(sum5());
console.log("BT5");
console.log(sphereVolume(3));
console.log("BT6");
console.log(sum(3,8));
console.log("BT7");
console.log(isPrime(17));
console.log(isPrime(15));
console.log("BT8");
console.log(primeSum(10));
console.log("BT9");
console.log(sumProduct(5));
