import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
public class Main {
    @RunWith(Parameterized.class) // Напиши аннотацию для параметризованных тестов
    public class CheckIsAdultTest {

        private final int age;
        private final boolean result;

        public CheckIsAdultTest(int age, boolean result) {
            this.age = age; // Инициализируй поля класса в конструкторе
            this.result = result;
        }

        @Parameterized.Parameters // Пометь метод аннотацией для параметров
        public static Object[][] getTextData() {
            return new Object[][] {
                    {18, true}, // Заполни массив тестовыми данными и ожидаемым результатом
                    {21, true},
                    {17, false},
                    {19, true},
            };
        }

        @Test
        public void checkIsAdultWhenAgeThenResult() {
            Program program = new Program();
            // Передай сюда возраст пользователя
            boolean isAdult = program.checkIsAdult(age);
            // Сравни полученный и ожидаемый результаты, не забудь про сообщение об ошибке
            assertEquals("Пользователь совершеннолетний", result, isAdult);
        }
    }
}
