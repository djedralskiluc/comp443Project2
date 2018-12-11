$(document).ready(function () {

    //extract whatever is inside of the script tag with an id of product-modal-template
    var source = $("#product-modal-template").html();

    var product_modal_template = Handlebars.compile(source);

    var productResourceURI= "http://localhost:8081/productservice/product"//needs product uri

    //retrieve all the products from server then display them on the homepage
    // if server doesn't return any products for some reason, the homepage will not have a list of products displayed.
    $.getJSON(productResourceURI, function (products) {

        for (var i = 0; i < products.length; i++) {

            var productData = {
                productID: ""+produdcts[i].productId,
                name: ""+products[i].name,
                details: ""+products[i].details,
                partner: ""+productData[i].partnerId,
                cost: ""+products[i].cost,
                deletelink: empoloyees[1].link.url, //for deletes
                updatelink: empoloyees[0].link.url //for edits
                //use cookies to save metadata between pages
            };

            //replace all the variables within the compiled script tag above with each value of product data.
            var productElementToAppend = product_modal_template(productData);

            //embed the html element which contains product information into the html div tag with id 'content'
            $("#content").append(productElementToAppend);

        }

    });




    //submit the add employee form to the server
    $('form').submit(function (event) {
    

    
        $.ajax({
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            url: productResourceURI,
            data: JSON.stringify(formData),
            dataType: 'json',
            encode: true
        }).done(function(returnedData){
    
            alert("Product has been added");
    
        });
        event.preventDefault(); // waits for a response from server before proceeding with the rest of the code
    
    });
    
    

    
    function getPartnerId(){
        return $("input[name=newPartnerId]").val();
    
    
    }
    function getName(){
        return $("input[name=newName]").val();
    
    
    }
    function getDetails(){
        return $("input[name=newDetails]").val();    
    
    }
    function getCost(){
        return $("input[name=newCost]").val();   
    
    }





});
