package com.fika.basics;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class StreamPractice {

    record Product(long id, String name, String category, BigDecimal price, int stock) {}

    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product(1, "Espresso", "Coffee", new BigDecimal("30"), 100),
                new Product(2, "Latte", "Coffee", new BigDecimal("45"), 80),
                new Product(3, "Cinnamon Bun", "Bakery", new BigDecimal("35"), 5),
                new Product(4, "Chai", "Tea", new BigDecimal("40"), 0),
                new Product(5, "Croissant", "Bakery", new BigDecimal("38"), 12)
        );

        // 1. Group names by category
        Map<String, List<String>> byCategory = products.stream()
                .collect(Collectors.groupingBy(Product::category,
                        Collectors.mapping(Product::name, Collectors.toList())));
        System.out.println(byCategory);

        // 2. Low-stock items (stock < 10), sorted by stock
        products.stream()
                .filter(p -> p.stock() < 10)
                .sorted(Comparator.comparingInt(Product::stock))
                .forEach(System.out::println);

        // 3. Most expensive product (Optional)
        Optional<Product> priciest = products.stream()
                .max(Comparator.comparing(Product::price));
        priciest.ifPresent(p -> System.out.println("Priciest: " + p.name()));

        Map<String, BigDecimal> valueByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::category,
                        Collectors.reducing(BigDecimal.ZERO,
                                p -> p.price().multiply(BigDecimal.valueOf(p.stock())),
                                BigDecimal::add)));
        System.out.println(valueByCategory);

        String outOfStock = products.stream()
                .filter(product -> product.stock() == 0)
                .map(Product::name)
                .collect(Collectors.joining(", "));
        System.out.println("Out of stock: "+ outOfStock);


        products.forEach(product -> System.out.println(product.name+": "+stockLabel(product.stock())));
    }

    static String stockLabel(Integer stock){
        return  switch (stock){
            case Integer s when s < 10 -> "LOW";
            case Integer s when s < 50 -> "OK";
            case Integer s -> "HIGH";
        };
    }
}