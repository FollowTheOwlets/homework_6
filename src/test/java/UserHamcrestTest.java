import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class UserHamcrestTest {

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
        int expected = 0;

        //when:
        int result = sut.checkAge() ? 1 : 0;

        //then:
        assertThat(result, greaterThanOrEqualTo(expected));

    }

    @ParameterizedTest
    @MethodSource("source")
    public void testCheckLoginAndPassword(String login, String password) {
        //given:
        sut = new User(login, password, 20, "test");
        int expected = 0;

        //when:
        int result = sut.checkLoginAndPassword(login, password) ? 1 : 0;

        //then:
        assertThat(result, greaterThanOrEqualTo(expected));
    }

    private static Stream<Arguments> source() {
        return Stream.of(Arguments.of("login", "password"));
    }

    @ParameterizedTest
    @MethodSource("sourceUser")
    public void testUserCreate(String login, String password, int age, String mail) {
        User user = new User(login, password, 0, mail);
        //when:

        sut = new User(login, password, age, mail);

        //then:
        assertThat(sut.toString(), equalTo(user.toString()));

    }

    private static Stream<Arguments> sourceUser() {
        return Stream.of(Arguments.of("test", "test", -9, "test"));
    }

}
