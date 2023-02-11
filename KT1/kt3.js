let btn1 = document.querySelector("#btn-1");
let btn2 = document.querySelector("#btn-2");
let btn3 = document.querySelector("#btn-3");
let type = document.querySelector("#type");
let ul = document.querySelector("#list");

btn1.classList.add("background-red");
btn2.classList.remove("background-red");
btn3.classList.remove("background-red");
ul.replaceChildren();
type.innerText = "Type: Posts";

   fetch("https://jsonplaceholder.typicode.com/posts")
    .then((res) => {
        return res.json();
    })
    .then(data => {
        console.log(data[0]);
        for (let i  =0 ; i < data.length; i++){
            let li = document.createElement("li");
            li.innerText = data[i].title;
            ul.appendChild(li);
        }
    })
    .catch(err => {
        console.log(err);
    })

btn1.addEventListener("click", async () => {
    btn1.classList.add("background-red");
    btn2.classList.remove("background-red");
    btn3.classList.remove("background-red");
   ul.replaceChildren();
   type.innerText = "Type: Posts";

       fetch("https://jsonplaceholder.typicode.com/posts")
        .then((res) => {
            return res.json();
        })
        .then(data => {
            console.log(data[0]);
            for (let i  =0 ; i < data.length; i++){
                let li = document.createElement("li");
                li.innerText = data[i].title;
                ul.appendChild(li);
            }
        })
        .catch(err => {
            console.log(err);
        })
});

btn2.addEventListener("click", async () => {
    ul.replaceChildren();
    btn1.classList.remove("background-red");
    btn2.classList.add("background-red");
    btn3.classList.remove("background-red");
    type.innerText = "Type: Albums";
 
    fetch("https://jsonplaceholder.typicode.com/albums")
         .then((res) => {
             return res.json();
         })
         .then(data => {
             console.log(data[0]);
             for (let i  =0 ; i < data.length; i++){
                 let li = document.createElement("li");
                 li.innerText = data[i].title;
                 ul.appendChild(li);
             }
         })
         .catch(err => {
             console.log(err);
         })
 });


 btn3.addEventListener("click", async () => {
    ul.replaceChildren();
    btn1.classList.remove("background-red");
    btn2.classList.remove("background-red");
    btn3.classList.add("background-red");
    type.innerText = "Type: Photos";
    fetch("https://jsonplaceholder.typicode.com/photos")
         .then((res) => {
             return res.json();
         })
         .then(data => {
             console.log(data[0]);
             for (let i  =0 ; i < data.length; i++){
                 let li = document.createElement("li");
                 li.innerText = data[i].title;
                 ul.appendChild(li);
             }
         })
         .catch(err => {
             console.log(err);
         })
 });


