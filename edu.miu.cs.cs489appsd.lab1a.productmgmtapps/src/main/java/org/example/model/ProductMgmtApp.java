package org.example.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.Product;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ProductMgmtApp {

    public static void main(String[] args) {

        Product[] arrayOfProduct =  new Product[]{
                new Product(new BigInteger("3128874119"),"Banana", LocalDate.of(2023,1,24),  124 ,0.55),
                new Product(new BigInteger("2927458265"),"Apple", LocalDate.of(2022,12,9),  18 ,1.09),
                new Product(new BigInteger("9189927460"),"Carrot", LocalDate.of(2023,3,31),  89 ,2.99)
        };

        printProducts(arrayOfProduct);

    }

    public static void printProducts(Product[] parameter){
        Stream<Product> listSorted = Arrays.stream(parameter).sorted(Comparator.comparing(Product::getName));
        List<Product> finalList = listSorted.toList();
        System.out.println("Printed in Json Format");
        System.out.println("------------------------");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);


        try {
            String json = objectMapper.writeValueAsString(finalList);
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Printed in Xml Format");
        System.out.println("------------------------");
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        xmlMapper.configure(com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT, true);


        try {
            String xml = xmlMapper.writeValueAsString(finalList);
            System.out.println(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Printed in comma-separated value(csv) format");
        System.out.println("------------------------");
        CsvMapper csvMapper = new CsvMapper();
        csvMapper.findAndRegisterModules();

        CsvSchema schema = csvMapper.schemaFor(Product.class).withHeader();

        try {
            StringWriter writer = new StringWriter();
            csvMapper.writer(schema).writeValue(writer, finalList);
            System.out.println(writer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
