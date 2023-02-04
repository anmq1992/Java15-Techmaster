// Danh sách các sản phẩm có trong giỏ hàng
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

// 6. Thêm 1 sản phẩm bất kỳ vào trong mảng product
products.push({
    name: "Samsung Galaxy S20",
    price: 15000000,
    brand: "Samsung",
    count: 2,
})

// 7. Xóa tất cả sản phẩm của thương hiệu "Samsung" trong giỏ hàng
products = products.filter(product => product.brand != "Samsung");
console.log(products);

// 8. Sắp xếp giỏ hàng theo price tăng dần
products.sort((a,b) => a.price > b.price ? 1 : -1);
console.log(products);


// 9. Sắp xếp giỏ hàng theo count giảm dần
products.sort((a,b) => a.count < b.count ? 1 : -1);

// 10. Lấy ra 2 sản phẩm bất kỳ trong giỏ hàng
function getRandomEle (arr){
    let result = [];
    for (let i = 0; i < 2; i++){
        let randomIndex = Math.floor(Math.random() * arr.length);
        result.push(arr[randomIndex]);
    }
    return result;
}

console.log(getRandomEle(products));
