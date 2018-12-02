$(document).ready(function () {

    //extract whatever is inside of the script tag with an id of product-modal-template
    var source = $("#product_modal_template").html();

    var product_modal_template = Handlebars.compile(source);

    var productResourceURI= "http://localhost:8081/employeeservice/employee"//needs product uri

    //retrieve all the products from server then display them on the homepage
    // if server doesn't return any products for some reason, the homepage will not have a list of products displayed.
    $.getJSON(productResourceURI, function (products) {

        for (var i = 0; i < products.length; i++) {

            var productData = {
                productID: ""+produdcts[i].gid,
                Name: ""+products[i].name,
                cost: +products[i].cost
                //deletelink: empoloyees[1].link.href for deletes
                //use cookies to save metadata between pages
            };

            //replace all the variables within the compiled script tag above with each value of product data.
            var productElementToAppend = product_modal_template(productData);

            //embed the html element which contains product information into the html div tag with id 'content'
            $("#content").append(productElementToAppend);

        }

    });




    //submit the add employee form to the server
    // $('form').submit(function (event) {
    //
    //     /**
    //      * salary and privilege are not sent to the server since there is no endpoint that accepts those parameters
    //      * @type {{firstName: *, lastName: *}}
    //      */
    //     var formData = {
    //         'firstName': getFirstName(),
    //         'lastName': getLastName()
    //     };
    //
    //     $.ajax({
    //         method: 'POST',
    //         headers: {
    //             'Accept': 'application/json',
    //             'Content-Type': 'application/json'
    //         },
    //         url: employeeResourceURI,
    //         data: JSON.stringify(formData),
    //         dataType: 'json',
    //         encode: true
    //     }).done(function(returnedData){
    //
    //         alert("Employee has been added");
    //
    //     });
    //     event.preventDefault(); // waits for a response from server before proceeding with the rest of the code
    //
    // });
    //
    //
    // function getFirstName() {
    //     var fullName = getFullName();
    //     return fullName.split(" ")[0];
    //
    // }
    //
    // function getLastName() {
    //     var fullName = getFullName();
    //     return fullName.split(" ")[1];
    //
    // }
    // function getFullName(){
    //     return $("input[name=newFullName]").val();
    //
    // }
    //
    // function getSalary(){
    //     return $("input[name=newSalary]").val();
    //
    //
    // }
    //
    // function getPrivileges(){
    //     return $("input[name=newPrivileges]").val();
    // }




});
