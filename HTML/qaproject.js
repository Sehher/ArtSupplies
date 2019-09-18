// const req = new XMLHttpRequest();
// req.open('GET', 'http://localhost:9000/products');
// req.onload = () => {
//const data = JSON.parse(req.response);
// console.log(data)
// document.getElementById("Name").innerHTML = data[0].name;
// document.getElementById("Category").innerHTML = data[0].category;
// document.getElementById("Description").innerHTML = data[0].description;

// function newProductEntries(table) {
//     let row = document.createElement("tr");
//     for (let i = 1; i < arguments.length; i++) {
//         let box = document.createElement("td");
//         box.innerHTML = arguments[i];
//         row.append(box);
//     }
//     table.append(row)
// }

// function load() {
//     const req = new XMLHttpRequest();
//     req.open('GET', 'http://localhost:9000/products');
//     req.onload = () => {
//         const data = JSON.parse(req.response);
//         console.log(data);
//         for (let i = 0; i < data.length; i++) {
//             let temp = data[i];
//             newproductEntries(table, temp["name"], temp["category"], temp["description"]);
//         }
//     }
//     req.send();
// }

function httpRequest(method, URL, callback, headers, body) {
    let request = new XMLHttpRequest();
    request.open(method, URL);
    request.onload = () => {
        callback(request);
    }
    for(let key in headers) {
        request.setRequestHeader(key, headers[key]);
    }    
    body ? request.send(body) : request.send(); 
}

function printCard(request) {
    let products = JSON.parse(request.response);
    let list = document.getElementById("cardList");
    list.innerHTML="";
    for(let product of products){
        let productElement = document.createElement("div");
        productElement.setAttribute("className", "card");

        let horizontalCard = document.createElement("div");
        horizontalCard.setAttribute("className","card-horizontal");

        let imageWrapper = document.createElement("div");
        imageWrapper.setAttribute("className","img-square-wrapper");

        let image = document.createElement("img");
        image.src = product.imageUrl;

        imageWrapper.appendChild(image)

        let cardBody = document.createElement("div");
        cardBody.setAttribute("className","card-body");

        let cardTitle = document.createElement("h4");
        cardTitle.innerText = product.name;

        let itemDescriptions = document.createElement("ul");
        itemDescriptions.setAttribute("className", "list-group");

        let category = document.createElement("li");
        category.setAttribute("class", "list-group-item");
        category.innerText = product.category;

        let description = document.createElement("li");
        description.setAttribute("class", "list-group-item");
        description.innerText = product.description;

        itemDescriptions.appendChild(category);
        itemDescriptions.appendChild(description);

        cardBody.appendChild(cardTitle);
        cardBody.appendChild(itemDescriptions);


        horizontalCard.appendChild(imageWrapper);
        horizontalCard.appendChild(cardBody);



        let cardFooter = document.createElement("div");
        cardFooter.setAttribute("className","card-footer");
        let button = document.createElement("button");
        button.type = "button";
        button.setAttribute("className", "btn-success");
        button.setAttribute("onclick", "deleteProduct("+product.id+")")

        let header5 = document.createElement("h5");
        header5.setAttribute("className", "added")
        header5.innerText = "-";

        button.appendChild(header5);
        cardFooter.appendChild(button);


        productElement.appendChild(horizontalCard);
        productElement.appendChild(cardFooter);
        list.appendChild(productElement);
    }
}

function getProducts(){
    let method = "GET";
    let URL = "http://localhost:9000/products";
    let callback = printCard;
    let headers = {
        "Content-Type": "application/json"
    }
    httpRequest(method, URL, callback, headers);
}

function deleteProduct(id){
    let method = "DELETE";
    let URL = "http://localhost:9000/products/"+id;
    let callback = getProducts;
    let headers = {
        "Content-Type": "application/json"
    }
    httpRequest(method, URL, callback, headers);
}

getProducts();
// comment
