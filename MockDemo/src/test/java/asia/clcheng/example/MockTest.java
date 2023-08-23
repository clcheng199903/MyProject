package asia.clcheng.example;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MockTest {
    @Test
    void verifyTest() {
        Person mockPerson = mock(Person.class);
        mockPerson.setId(1);
        mockPerson.setName("CCL");

        // 验证
        verify(mockPerson).setId(1);
        verify(mockPerson).setName("CCL");
    }

    @Test
    void stubTest() {
        Person mockPerson = mock(Person.class);
        when(mockPerson.getId()).thenReturn(18);
        when(mockPerson.getName()).thenReturn("CCL");

        System.out.println(mockPerson.getId());
        System.out.println(mockPerson.getName());
    }

    @Test
    void matchersTest() {
        Person mockPerson = mock(Person.class);
//        when(mockPerson.setName(anyString()))
    }

    /**
     * spy：间谍
     * mock：模仿
     */
    @Test
    void spyTest() {
        Person person = new Person(18, "CCL");
        Person spy = spy(person);

        when(spy.getName()).thenReturn("SPY间谍");
        System.out.println(spy.getId());
        System.out.println(spy.getName());

        // 使用spy对象时真实的对象也会被调用，除非它被mock了
        // 当真实对象不可被调用时，请使用 doReturn | Answer | Throw()
        doReturn("MOCK模拟").when(spy).setName("TTT");
//        System.out.println(spy.setName("TTT"));
    }
}