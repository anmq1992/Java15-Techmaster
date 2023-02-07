//Cau 1

let para = document.getElementById("text");
para.style.color = '#777';
para.style.fontSize = '2rem';
para.innerHTML = "Tôi có thể làm <em> bất cứ điều gì </em> tôi muốn với JavaScript.";

//Cau 2
const paras = document.querySelectorAll("li");

paras.forEach(ele => {
    ele.style.color = 'blue';
})


//Cau 3
let ul = document.getElementById("list");
console.log(ul);
let li = document.createElement("li");
li.appendChild(document.createTextNode("Item 8"));
li.style.color="blue";
ul.appendChild(li);

li = document.createElement("li");
li.appendChild(document.createTextNode("Item 9"));
li.style.color="blue";
ul.appendChild(li);

const li1 = document.querySelector("ul li:nth-child(1)");
li1.style.color = "red";

const li4 = document.querySelector("ul li:nth-child(4)");
ul.removeChild(li4);

let li4new = document.createElement("li");
li4new.appendChild(document.createTextNode("Item 4 new"));
ul.insertBefore(li4new, ul.children[3]);






// paraLi.insertAdjacentElement("beforeend", "<li>Item 7</li>");
// paraLi.insertAdjacentElement("beforeend", "<li>Item 8</li>");
// paraLi.insertAdjacentElement("beforeend", "<li>Item 9</li>");

