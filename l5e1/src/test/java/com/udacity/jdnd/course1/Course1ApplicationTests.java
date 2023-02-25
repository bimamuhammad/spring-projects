package com.udacity.jdnd.course1;

import com.udacity.jdnd.course1.service.BuzzFizzService;
import com.udacity.jdnd.course1.service.FizzBuzzService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Course1ApplicationTests {

	@Test
	void testFizzBuzz(){
		FizzBuzzService fbs = new FizzBuzzService();

		// check non-divisible numbers return themselves
		assertEquals("1", fbs.fizzBuzz(1));
		assertEquals("47", fbs.fizzBuzz(47));
		assertEquals("121", fbs.fizzBuzz(121));

		// check numbers divisible by 3
		assertEquals("Fizz", fbs.fizzBuzz(3));
		assertEquals("Fizz", fbs.fizzBuzz(333));

		//check numbers divisible by 5
		assertEquals("Buzz", fbs.fizzBuzz(5));
		assertEquals("Buzz", fbs.fizzBuzz(85));

		//check numbers divisible by 3 and 5
		assertEquals("FizzBuzz", fbs.fizzBuzz(15));
		assertEquals("FizzBuzz", fbs.fizzBuzz(75));

		//check invalid inputs
		assertThrows(IllegalArgumentException.class, () -> fbs.fizzBuzz(0));
		assertThrows(IllegalArgumentException.class, () -> fbs.fizzBuzz(-1));
	}

	@Test
	void testBuzzFizz(){
		BuzzFizzService buzzFizzService = new BuzzFizzService();

		assertEquals(6, buzzFizzService.buzzFizz("Fizz", 2));
		assertEquals(10, buzzFizzService.buzzFizz("Buzz", 2));
		assertEquals(30, buzzFizzService.buzzFizz("FizzBuzz", 2));

		assertEquals(85, buzzFizzService.buzzFizz("85", 2));
		assertEquals(-1, buzzFizzService.buzzFizz("-1", 2));

		//illegal input
		assertThrows(NumberFormatException.class, ()->buzzFizzService.buzzFizz("fizz", 2));
		assertThrows(NumberFormatException.class, ()->buzzFizzService.buzzFizz("buzz", 2));
		assertThrows(NumberFormatException.class, ()->buzzFizzService.buzzFizz("fizzbuzz", 2));
		assertThrows(NumberFormatException.class, ()->buzzFizzService.buzzFizz("fizzbuzz", -1));
	}
}
