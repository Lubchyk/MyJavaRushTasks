/**
 * Created by АНТ on 11.03.2017.
 */
public class PaternExample {

    /**приклад реалізації шаблона Singleton з лінивою ініціалізацією(lazy initialization)*/
    public class Sun {
        private /*static*/ Sun instance;

        private Sun() {
        }
        public/*static*/ Sun getInstance() {
            if (instance == null) instance = new Sun();
            return instance;
        }
    }
}
