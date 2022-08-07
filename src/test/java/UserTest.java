import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class UserTest {

    User sut;

    @BeforeAll
    public static void initTests() {
        System.out.println("Run Tests");
    }

    @AfterAll
    public static void completeTests() {
        System.out.println("Complete Tests");
    }

    @BeforeEach
    public void initTest() {
        System.out.println("start new test");
    }

    @AfterEach
    public void finalizeTest() {
        System.out.println("complete test");
    }

    @Test
    public void testCheckAge() {
        //given:
        int age = 15;
        sut = new User("test", "test", age, "test");

        //when:
        boolean result = sut.checkAge();

        //then:
        Assertions.assertFalse(result);

    }

    @ParameterizedTest
    @MethodSource("source")
    public void testCheckLoginAndPassword(String login, String password) {
        //given:
        sut = new User(login, password, 20, "test");

        //when:
        boolean result = sut.checkLoginAndPassword(login, password);

        //then:
        Assertions.assertTrue(result);
    }

    private static Stream<Arguments> source(){
        return  Stream.of(Arguments.of("login", "password"));
    }
}
