package realjenius.jackson.java8;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;

import java.util.Optional;

/**
 * @author R.J. Lorimer [rj@realjenius.com]
 */
public class Java8OptionalBeanPropertyWriter extends BeanPropertyWriter {

    protected Java8OptionalBeanPropertyWriter(BeanPropertyWriter base) {
        super(base);
    }

    @Override
    public void serializeAsField(Object bean, JsonGenerator jgen, SerializerProvider prov) throws Exception {
        Object val = get(bean);
        if((val == null || Optional.empty().equals(val)) && _nullSerializer == null) {
            return;
        }
        super.serializeAsField(bean, jgen, prov);
    }
}
