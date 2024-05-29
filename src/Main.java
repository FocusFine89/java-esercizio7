import entities.Customer;
import entities.Order;
import entities.Product;
import functional_interfaces.Sconto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Product book1 = new Product("book1", "Books", 100);
        Product book2 = new Product("book2", "Books", 225);
        Product book3 = new Product("book3", "Books", 33);
        Product baby1 = new Product("baby1", "Baby", 33);
        Product baby2 = new Product("baby2", "Baby", 58);
        Product baby3 = new Product("baby3", "Baby", 125);
        Product boys1 = new Product("boys1", "Boys", 69);
        Product boys2 = new Product("boys2", "Boys", 90);
        Product boys3 = new Product("boys3", "Boys", 11);

        Customer customer1 = new Customer("Giorgio", 2);
        Customer customer2 = new Customer("Michele", 2);
        Customer customer3 = new Customer("Patrick", 1);
        Customer customer4 = new Customer("Rick", 5);

        List<Product> babyList = new ArrayList<>();
        babyList.add(baby1);
        babyList.add(baby2);
        babyList.add(baby3);

        List<Product> orderList1 = new ArrayList<>();
        orderList1.add(book1);
        orderList1.add(baby1);
        orderList1.add(boys1);

        List<Product> orderList2 = new ArrayList<>();
        orderList2.add(book2);
        orderList2.add(baby2);
        orderList2.add(boys2);
        List<Product> orderList3 = new ArrayList<>();
        orderList3.add(book3);
        orderList3.add(boys3);
        orderList3.add(boys2);


        LocalDate orderDate = LocalDate.of(2021, 4, 1);
        LocalDate deliveryDate = orderDate.plusDays(3);

        Order order1 = new Order(orderDate, deliveryDate, babyList, customer1);
        Order order2 = new Order(orderDate, deliveryDate, orderList1, customer2);
        Order order3 = new Order(orderDate, deliveryDate, orderList2, customer3);
        Order order4 = new Order(orderDate, deliveryDate, orderList3, customer4);


        List<Product> productList = new ArrayList<>();
        productList.add(book1);
        productList.add(book2);
        productList.add(book3);
        productList.add(baby1);
        productList.add(baby2);
        productList.add(baby3);
        productList.add(boys1);
        productList.add(boys2);
        productList.add(boys3);


        //-------Esercizio1-------


        List<Product> bookList = productList.stream().filter(product -> Objects.equals(product.getCategory(), "Books") & product.getPrice() > 100).toList();
        System.out.println(bookList);

        //---------Esercizio2---------


        //----------Esercizio 3----------
        Sconto sconto10 = prezzo -> {
            return prezzo - prezzo * 10 / 100;
        };
        List<Product> boysList = productList.stream().filter(product -> Objects.equals(product.getCategory(), "Boys")).peek(product -> product.setPrice(sconto10.sconto(product.getPrice()))).toList();
        System.out.println(boysList);
    }
}