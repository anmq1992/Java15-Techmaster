// Truy cập vào thẻ h1 có id=“heading” thay đổi màu chữ thành ‘red’, và in hoa nội dung của thẻ đó
// Thay đổi màu chữ của tất cả thẻ có class “para” thành màu “blue” và có font-size = “20px”
// Thêm thẻ a link đến trang ‘facebook’ ở đằng sau thẻ có class “para-3”
// Thay đổi nội dung của thẻ có id=“title” thành “Đây là thẻ tiêu đề”
// Thêm class “text-bold” vào thẻ có class=“description” (định nghĩa class “text-bold” có tác dụng in đậm chữ)
// Thay thế thẻ có class=“para-3” thành thẻ button có nội dung là “Click me”
// Copy thẻ có class=“para-2” và hiển thị ngay đằng sau thẻ đó
// Xóa thẻ có class=“para-1”

const heading = document.getElementById('heading');
heading.style.color = 'red';
heading.style.textTransform = 'uppercase';

const paras = document.querySelectorAll("p");
paras.forEach(ele => {
    ele.style.color = 'blue';
});

Array.from(paras).map(ele => {
    ele.style.fontSize = "20px";
})


// Thêm thẻ a link đến trang ‘facebook’ ở đằng sau thẻ có class “para-3”
let para3 = document.querySelector(".para-3");
para3.insertAdjacentHTML("afterend", "<a href='https://www.facebook.com/'>Facebook</a>");

// Thay đổi nội dung của thẻ có id=“title” thành “Đây là thẻ tiêu đề”
let title = document.getElementById('title');
title.textContent = "Day la the tieu de";

// Thêm class “text-bold” vào thẻ có class=“description” (định nghĩa class “text-bold” có tác dụng in đậm chữ)
let description = document.getElementsByClassName('description');
heading.classList.add("text-bold");

// Thay thế thẻ có class=“para-3” thành thẻ button có nội dung là “Click me”
const btn = document.createElement("button");
btn.innerText = "Click me";
para3.parentNode.replaceChild(btn, para3);

// Copy thẻ có class=“para-2” và hiển thị ngay đằng sau thẻ đó
let para2 = document.querySelector(".para-3");
let clonePara2 = para2.cloneNode(true);
para2.insertAdjacentHTML("afterend", clonePara2);

// Xóa thẻ có class=“para-1”
let para1 = document.querySelector(".para-1");
document.body.removeChild(para1);

