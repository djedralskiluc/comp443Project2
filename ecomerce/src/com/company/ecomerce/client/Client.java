package com.company.ecomerce.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.xml.ws.Response;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
//import org.apache.cxf.interceptor.LoggingInInterceptor;
//import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.client.WebClient;


import com.company.ecomerce.client.*;
import com.company.ecomerce.customer.Address;
import com.company.ecomerce.customer.Customer;
import com.company.ecomerce.customer.CustomerManager;
import com.company.ecomerce.order.OrderManager;
import com.company.ecomerce.partner.PartnerManager;
import com.company.ecomerce.product.ProductManager;

public final class Client {
	private Client() {
    } 
	
	
    public static void main(String args[]) throws Exception {

    	List<Object> providers = new ArrayList<Object>();
        //JacksonJsonProvider provider = new JacksonJsonProvider();
        //provider.addUntouchable(Response.class);
        //providers.add(provider);
        
        /*****************************************************************************************
         * GET METHOD invoke
//         *****************************************************************************************/
//        System.out.println("GET METHOD .........................................................");
//        WebClient getClient = WebClient.create("http://localhost:8081", providers);
//        
//        //Configuring the CXF logging interceptor for the outgoing message
//        WebClient.getConfig(getClient).getOutInterceptors().add(new LoggingOutInterceptor());
//      //Configuring the CXF logging interceptor for the incoming response
//        WebClient.getConfig(getClient).getInInterceptors().add(new LoggingInInterceptor());
//        
//        // change application/xml  to get in xml format
//        getClient = getClient.accept("application/json").type("application/json").path("/employeeservice/employee/XY1111");
//        
//        //The following lines are to show how to log messages without the CXF interceptors
//        String getRequestURI = getClient.getCurrentURI().toString();
//        System.out.println("Client GET METHOD Request URI:  " + getRequestURI);
//        String getRequestHeaders = getClient.getHeaders().toString();
//        System.out.println("Client GET METHOD Request Headers:  " + getRequestHeaders);
//        
//        //to see as raw XML/json
//        String response = getClient.get(String.class);
//        System.out.println("GET METHOD Response: ...." + response);
//        
//       //to get the response as object of Employee class
//       //Employee employee = client.get(Employee.class);
//       //System.out.println("Name:" + employee.getFirstName());
//       //System.out.println("privileges:" + employee.getPrivileges());
//       
//       /*****************************************************************************************
//        * POST METHOD invoke
//       *****************************************************************************************/
//       System.out.println("POST METHOD .........................................................");
//       //WebClient postClient = WebClient.create("http://localhost:8081", providers);
//       //WebClient.getConfig(postClient).getOutInterceptors().add(new LoggingOutInterceptor());
//       //WebClient.getConfig(postClient).getInInterceptors().add(new LoggingInInterceptor());
//                
//       // change application/xml  to application/json get in json format
//       //postClient = postClient.accept("application/xml").type("application/json").path("/employeeservice/employee");
//    	
//       //String postRequestURI = postClient.getCurrentURI().toString();
//       System.out.println("Client POST METHOD Request URI:  " + postRequestURI);
//       String postRequestHeaders = postClient.getHeaders().toString();
//       System.out.println("Client POST METHOD Request Headers:  " + postRequestHeaders);
//       Customer customer = new Customer();
//       //customer.addCustomer().setFirstName("Michael");
//       Address addr  = new Address();
//       addr.setAddr1("123 Sesame St");
//       addr.setCity("New York");
//       addr.setState("NY");
//       addr.setZip("10001");
//       
//       CustomerManager customerManager = new CustomerManager();
//       customerManager.addCustomer("Ben","Stone","555-555-5555",addr);
//       Set<Customer> customerList =  customerManager.getAllCustomers();
//       Customer firstCustomer = customerList.iterator().next();
//       customerManager.updateCustomer(firstCustomer.getCustomerID(), "444-444-4444", addr);
//       customerManager.getCustomer(firstCustomer.getCustomerID());  
//       customerManager.AddorUpdateCustomerPayment(firstCustomer.getCustomerID(), "AMEX", "555555555555", "04/20", "1234", "Customer J Daniel");
//       customerManager.deleteCustomer(firstCustomer.getCustomerID());
//       
//       
//       
//       ProductManager productManager = new ProductManager();
//       productManager.addProduct("ballbox", "Box o balls", 4, 0);
//       productManager.updateProduct(1, 5);
//       productManager.getAllProducts();
//       productManager.addProductReview("Thats a lot of balls in that Box", 5, 1, 1);
//       productManager.deleteProduct(1);
//       
//       
//       
//       PartnerManager partnerManager = new PartnerManager();
//       partnerManager.addPartner("Partner1", 1);
//       partnerManager.updatePartner(1, 2);
//       partnerManager.getAllPartners();
//       partnerManager.getPartnerProduct(1);
//       partnerManager.deletePartner(1);
//       
//       OrderManager orderMangager = new OrderManager();
//       Integer[] ints = new Integer[] {1,2,3,4,5};
//       List<Integer> list = Arrays.asList(ints);
//       
//       orderMangager.addOrder(1,list,1, 1);
//       orderMangager.updateOrder(1, 2);
//       orderMangager.getAllOrders();
//       orderMangager.getOrder(1);
//       orderMangager.deleteOrder(1);
//       
//       
//       
//       
//       productManager.updateProductReview(productReviewId, rating);
//       Set<Customer> customerList =  customerManager.getAllCustomers();
//       Customer firstCustomer = customerList.iterator().next();
//       customerManager.updateCustomer(firstCustomer.getCustomerID(), "444-444-4444", addr);
//       customerManager.getCustomer(firstCustomer.getCustomerID());
//       
//       customerManager.deleteCustomer(firstCustomer.getCustomerID());
//       
//       
//       
//    	
//       
//       /*****************************************************************************************
//        * GET METHOD invoke for all employees
//        *****************************************************************************************/
//       System.out.println("GET METHOD for all employees..........................................");
//       WebClient getAllClient = WebClient.create("http://localhost:8081", providers);
//       WebClient.getConfig(getAllClient).getOutInterceptors().add(new LoggingOutInterceptor());
//       WebClient.getConfig(getAllClient).getInInterceptors().add(new LoggingInInterceptor());
//       
//       // change application/xml  to get in xml format
//       getAllClient = getAllClient.accept("application/json").type("application/json").path("/employeeservice/employee");
//                
//       String getAllRequestURI = getAllClient.getCurrentURI().toString();
//       System.out.println("Client GET METHOD Request URI:  " + getAllRequestURI);
//       String getAllRequestHeaders = getAllClient.getHeaders().toString();
//       System.out.println("Client GET METHOD Request Headers:  " + getAllRequestHeaders);
//       
//       //to see as raw XML/json
//       String getAllResponse = getAllClient.get(String.class);
//       System.out.println("GET All METHOD Response: ...." + getAllResponse);
//       
//       /*****************************************************************************************
//        * DELETE METHOD invoke
//       *****************************************************************************************/
//       System.out.println("DELETE METHOD .........................................................");
//       WebClient deleteClient = WebClient.create("http://localhost:8081", providers);
//       WebClient.getConfig(deleteClient).getOutInterceptors().add(new LoggingOutInterceptor());
//       WebClient.getConfig(deleteClient).getInInterceptors().add(new LoggingInInterceptor());
//       
//       // change application/xml  to application/json get in json format
//       deleteClient = deleteClient.accept("application/xml").type("application/json").path("/employeeservice/employee/XY1111");
//    	
//       String deleteRequestURI = deleteClient.getCurrentURI().toString();
//       System.out.println("Client DELETE METHOD Request URI:  " + deleteRequestURI);
//       String deleteRequestHeaders = deleteClient.getHeaders().toString();
//       System.out.println("Client DELETE METHOD Request Headers:  " + deleteRequestHeaders);
//       
//       deleteClient.delete();
//       System.out.println("DELETE MEDTHOD Response ......... OK");
        
       System.exit(0);
    }
}
