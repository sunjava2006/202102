package com.wangrui.tsd.bean;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class BookTest {
	@Autowired
	private Book book;

	@Test
	void testGetName() {
		System.out.println(book.getName());
	}

	@Test
	void testGetAuthor() {
		System.out.println(book.getAuthor());
	}

}
