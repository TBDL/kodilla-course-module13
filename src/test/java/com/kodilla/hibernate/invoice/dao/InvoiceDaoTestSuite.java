package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("book1");
        Product product2 = new Product("book2");
        Product product3 = new Product("book3");
        Item item1 = new Item(new BigDecimal(25), 10);
        Item item2 = new Item(new BigDecimal(15), 20);
        Item item3 = new Item(new BigDecimal(10), 30);
        Invoice invoice1 = new Invoice("123/abc");

        item1.setProduct(product1);
        item2.setProduct(product2);
        item3.setProduct(product3);

        item1.setInvoice(invoice1);
        item2.setInvoice(invoice1);
        item3.setInvoice(invoice1);

        invoice1.getItems().add(item1);
        invoice1.getItems().add(item2);
        invoice1.getItems().add(item3);

        //When
        invoiceDao.save(invoice1);
        int id = invoice1.getId();

        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        //invoiceDao.delete(id);
    }
}
