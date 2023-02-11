let btn = document.querySelector("#btn");

btn.addEventListener("click", function () {

    //generate a random number rand from 1-4 for quiz 1
    let rand1 = Math.floor(Math.random()* 3) +1;

    //select the radio button with the index rand, set it to check
    let quiz1 = document.querySelector(".quiz-container .quiz-item:nth-child(1)"); 
    let answer1 =  quiz1.querySelectorAll('input[type="radio"]');
    answer1[rand1].checked = true;


    //generate a random number from 1-4 for quiz 2
    let quiz2 = document.querySelector(".quiz-container .quiz-item:nth-child(2)"); 
    let rand2 = Math.floor(Math.random()* 3) +1;
    let answer2 =  quiz2.querySelectorAll('input[type="radio"]');
    answer2[rand2].checked = true;
});


