import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.Optional;

public class CheckNull {
    private C c;


    /** як уникнути NullPointerException в трейсі викликів*/
    private void someMethod(C c) {
        int integer = Optional.ofNullable(c.getB())
                .map(f -> f.getA())
                .map(g -> g.getField()).orElse(0);
    }
    /** Як перевірити на empty i null*/
    private void someMethod(String s) {
        boolean notEmpty = StringUtils.isNotEmpty(s);
        boolean empty = StringUtils.isEmpty(s);
        boolean notBlank = StringUtils.isNotBlank(s);
        boolean aNull = Objects.isNull(s);
        boolean b = Objects.nonNull(s);
    }

}

class A {
    private int field;

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }
}
class B {
    private  A a;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }
}

class C {
    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}