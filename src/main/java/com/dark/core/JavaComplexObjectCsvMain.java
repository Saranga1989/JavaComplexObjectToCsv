package com.dark.core;

import java.io.File;
import java.io.FileWriter;

import com.dark.core.pojo.AddressInfo;
import com.dark.core.pojo.Person;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

public class JavaComplexObjectCsvMain {
    public static void main(String[] args) {

	Person person1 = new Person();
	person1.setName("Kamal");
	person1.setPosition("TL");

	AddressInfo add1 = new AddressInfo();
	add1.setAddress1("add1");
	add1.setAddress2("add2");
	add1.setAddress3("add3");
	person1.setInfo(add1);
	try {
	    exportCSV(person1);
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    public static void exportCSV(Person person) throws Exception {
	final String CSV_LOCATION = "Employees.csv ";

	// set file name and content type
	String file = "/Users/eleos/Desktop/csvFile/Employee-List.csv";
	FileWriter writer = new FileWriter(new File(file));

	ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();
	mappingStrategy.setType(Person.class);

	// Creating StatefulBeanToCsv object
	StatefulBeanToCsvBuilder<Person> builder = new StatefulBeanToCsvBuilder(writer);
	StatefulBeanToCsv beanWriter = builder.withMappingStrategy(mappingStrategy).build();

	// Write list to StatefulBeanToCsv object
	beanWriter.write(person);

	// closing the writer object
	writer.close();

    }
}