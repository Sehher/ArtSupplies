const req = new XMLHttpRequest();
req.open('GET', 'http://localhost:9000/products');
req.onload = () => {
    const data = JSON.parse(req.response);
    console.log(data)
    document.getElementById("Name").innerHTML = data[0].name;
    document.getElementById("Category").innerHTML = data[0].category;
    document.getElementById("Description").innerHTML = data[0].description;

}
req.send();