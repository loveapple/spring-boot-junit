package com.example.springboot;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GreetingTest {

    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void test() {

	// countに対する最小値チェックと相関チェックがエラーとなる
	Greeting greeting2 = new Greeting("hoge", null, 9);

	// violation数が２となる。
	Set<ConstraintViolation<Greeting>> violations = validator.validate(greeting2);
	// assertEquals(1, violations.size());

	int size = violations.size();

	assertThat(size).isEqualTo(1);

	System.out.println("hoge:" + size);
    }

}
